package info.vladyslav.myhadoop;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Job1_1_SeparateInvalid extends Configured implements Tool {
    public static final String INVALID = "INVALID";
    public static final String GOAL = "GOAL";

/*    public static class JsonOutputFormat extends TextOutputFormat<Text, IntWritable> {
        @Override
        public RecordWriter<Text, IntWritable> getRecordWriter(
                TaskAttemptContext context) throws IOException,
                InterruptedException {
            Configuration conf = context.getConfiguration();
            Path path = getOutputPath(context);
            FileSystem fs = path.getFileSystem(conf);
            FSDataOutputStream out =
                    fs.create(new Path(path, context.getJobName()));
            return new JsonRecordWriter(out);
        }

        private static class JsonRecordWriter extends
                LineRecordWriter<Text, IntWritable> {
            boolean firstRecord = true;

            @Override
            public synchronized void close(TaskAttemptContext context)
                    throws IOException {
                out.writeChar('{');
                super.close(null);
            }

            @Override
            public synchronized void write(Text key, IntWritable value)
                    throws IOException {
                if (!firstRecord) {
                    out.writeChars(",\r\n");
                    firstRecord = false;
                }
                out.writeChars("\"" + key.toString() + "\":\"" +
                        value.toString() + "\"");
            }

            public JsonRecordWriter(DataOutputStream out)
                    throws IOException {
                super(out);
                out.writeChar('}');
            }
        }
    }*/

    public static class StudentsMapper extends Mapper<Object, Text, Text, Text> {

        MultipleOutputs<?, ?> multipleOutputs;

        @Override
        protected void setup(Context context) throws IOException, InterruptedException {
            multipleOutputs = new MultipleOutputs<>(context);
        }

        @Override
        public void map(Object key, Text value, Context context
        ) throws IOException, InterruptedException {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true);

            String preparedLine = key.toString().replaceAll("[“”]", "\"");
            try {
                // проверяем на наличие правильно заполненных полей
                Student getStudent = objectMapper.readValue(preparedLine, Student.class);
                if (getStudent.getCLass() < 1 || getStudent.getCLass() > 12 ||
                        getStudent.getMark() < 0 || getStudent.getMark() > 5 ||
                        getStudent.getName().equals("")) {
                    // если неправильно --> пишем в этот файл
                    multipleOutputs.write(INVALID, NullWritable.get(), new Text(preparedLine), "INVALID/INVALID");
                } else {
                    // если всё правильно --> пишем в этот файл

//                    multipleOutputs.write(GOAL, NullWritable.get(), preparedLine, "GOAL/GOAL");
//                    context.write(new Text(preparedLine), new Text());

                    StudentsGroupByMark studentsGroupByMark = new StudentsGroupByMark();
                    for (int i = 1; i <= 5; i++) {
                        if (getStudent.getMark() == i) {
                            studentsGroupByMark.setMark(i);
                            studentsGroupByMark.setStudents(new ArrayList<>(Collections.singletonList(getStudent)));

//                            context.write(new Text(objectMapper.writeValueAsString(studentsGroupByMark)), null);
                            multipleOutputs.write(GOAL, new Text(objectMapper.writeValueAsString(studentsGroupByMark)), NullWritable.get(), "GOAL/GOAL");
                        }
                    }
                }
            } catch (IOException e) {
                //  при выбрасывании ошибки --> тоже заносим в невалидные строки
                multipleOutputs.write(INVALID, NullWritable.get(), new Text(preparedLine), "INVALID/INVALID");
            }
        }

        @Override
        protected void cleanup(Context context) throws IOException, InterruptedException {
            multipleOutputs.close();
        }
    }

/*    public static class MarkReducer extends Reducer<IntWritable, Text, IntWritable, Text> {

        private MultipleOutputs<?, ?> multipleOutputs;
        ArrayList<Student> students = new ArrayList<>();
//        StudentsGroupByMark studentsGroupByMark = new StudentsGroupByMark();
        ObjectMapper objectMapper = new ObjectMapper();


        @Override
        public void setup(Context context) throws IOException, InterruptedException {
            multipleOutputs = new MultipleOutputs<>(context);
        }

        @Override
        public void reduce(IntWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            for (Text value : values) {
                students.add(objectMapper.readValue(value.toString(), Student.class));
            }
            context.write(key, new Text(objectMapper.writeValueAsString(new StudentsGroupByMark(key.get(), students))));
        }

        @Override
        public void cleanup(Context context) throws IOException, InterruptedException {
            multipleOutputs.close();
        }
    }*/

    public static class GroupByMarksMap extends MapReduceBase implements org.apache.hadoop.mapred.Mapper<LongWritable, Text, Text, IntWritable> {
        private final static IntWritable one = new IntWritable(1);
        private Text word = new Text();

        public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
            String line = value.toString();
            StringTokenizer tokenizer = new StringTokenizer(line);
            while (tokenizer.hasMoreTokens()) {
                word.set(tokenizer.nextToken());
                output.collect(word, one);
            }
        }
    }

    public static class GroupByMarksReduce extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {
        public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
            int sum = 0;
            while (values.hasNext()) {
                sum += values.next().get();
            }
            output.collect(key, new IntWritable(sum));
        }
    }



    public static void main(String[] args) throws Exception {
        int exitCode = ToolRunner.run(new Configuration(),
                new Job1_1_SeparateInvalid(), args);
        System.exit(exitCode);
    }

    public int run(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("Please provide two arguments :");
            System.out.println("[ 1 ] Input dir path");
            System.out.println("[ 2 ] Output dir path");
            return -1;
        }
        Configuration conf = new Configuration();
        String[] files = new GenericOptionsParser(conf, args).getRemainingArgs();
        Path input = new Path(files[0]);
        Path output = new Path(files[1]);

        Job job = Job.getInstance();
        job.setInputFormatClass(KeyValueTextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        job.setJarByClass(Job1_1_SeparateInvalid.class);
        job.setMapperClass(StudentsMapper.class);
//        job.setReducerClass(MarkReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        job.setNumReduceTasks(0);

//        job.waitForCompletion(true);

        FileInputFormat.addInputPath(job, input);
        FileOutputFormat.setOutputPath(job, output);

        MultipleOutputs.addNamedOutput(job, GOAL, TextOutputFormat.class, Text.class, Text.class);
        MultipleOutputs.addNamedOutput(job, INVALID, TextOutputFormat.class, Text.class, Text.class);

        boolean success = job.waitForCompletion(true);
        return (success ? 0 : 1);
    }


}
