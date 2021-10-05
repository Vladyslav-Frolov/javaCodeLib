package info.vladyslav.myhadoop;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
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

public class Job1_SeparateInvalid extends Configured implements Tool {
    public static final String INVALID = "INVALID";
    public static final String MUMBAI = "MUMBAI";
    public static final String DELHI = "DELHI";
    public static final String GOAL = "GOAL";


    public static class TokenizerMapper extends Mapper<Object, Text, Text, Text> {

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
                    multipleOutputs.write(INVALID, NullWritable.get(), preparedLine, "INVALID/INVALID");
                } else {
                    // если всё правильно --> пишем в этот файл
                    multipleOutputs.write(GOAL, NullWritable.get(), preparedLine, "GOAL/GOAL");
                }
            } catch (IOException e) {
                //  при выбрасывании ошибки --> тоже заносим в невалидные строки
                multipleOutputs.write(INVALID, NullWritable.get(), preparedLine, "INVALID/INVALID");
            }
        }

        @Override
        protected void cleanup(Context context) throws IOException, InterruptedException {
            multipleOutputs.close();
        }
    }

    public static void main(String[] args) throws Exception {
        int exitCode = ToolRunner.run(new Configuration(),
                new Job1_SeparateInvalid(), args);
        System.exit(exitCode);
    }

    public int run(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("Please provide two arguments :");
            System.out.println("[ 1 ] Input dir path");
            System.out.println("[ 2 ] Output dir path");
            return -1;
        }
        Configuration c = new Configuration();
        String[] files = new GenericOptionsParser(c, args).getRemainingArgs();
        Path input = new Path(files[0]);
        Path output = new Path(files[1]);
        Job job = Job.getInstance();

        job.setJarByClass(Job1_SeparateInvalid.class);
        job.setMapperClass(TokenizerMapper.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        job.setInputFormatClass(KeyValueTextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);
        job.setNumReduceTasks(0);

        FileInputFormat.addInputPath(job, input);
        FileOutputFormat.setOutputPath(job, output);

        MultipleOutputs.addNamedOutput(job, GOAL, TextOutputFormat.class, Text.class, Text.class);
        MultipleOutputs.addNamedOutput(job, INVALID, TextOutputFormat.class, Text.class, Text.class);

        boolean success = job.waitForCompletion(true);
        return (success ? 0 : 1);
    }
}
