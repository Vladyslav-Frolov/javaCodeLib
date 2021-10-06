package info.vladyslav.myhadoop;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import info.vladyslav.myhadooptests.MyAlternativeWordCount;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;
import org.apache.hadoop.yarn.webapp.hamlet2.Hamlet;

import java.io.DataInput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Job1_2_GroupByMark {
    public static class GroupByMarksMap extends MapReduceBase implements org.apache.hadoop.mapred.Mapper<Object, Text, Text, Text> {
        ObjectMapper objectMapper = new ObjectMapper();
        StudentsGroupByMark studentsGroupByMark = new StudentsGroupByMark();
        Student student = new Student();

        public void map(Object key, Text value, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {
            studentsGroupByMark = objectMapper.readValue(value.toString(), StudentsGroupByMark.class);
            student = studentsGroupByMark.getStudents().get(0);
            Text integer = new Text(Integer.toString(studentsGroupByMark.getMark()));
            output.collect(integer, new Text(objectMapper.writeValueAsString(student)));
        }
    }


    public static class GroupByMarksReduce extends MapReduceBase implements Reducer<Text, Text, Text, Text> {
        public void reduce(Text key, Iterator<Text> values, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {
            ObjectMapper objectMapper = new ObjectMapper();
            ArrayList<Student> students = new ArrayList<>();
            StudentsGroupByMark studentsGroupByMark = new StudentsGroupByMark();
            while (values.hasNext()) {
                students.add(objectMapper.readValue(values.next().toString(), Student.class));
            }
            studentsGroupByMark.setMark(Integer.parseInt(key.toString()));
            studentsGroupByMark.setStudents(students);
            output.collect(new Text(objectMapper.writeValueAsString(studentsGroupByMark)), new Text());
        }
    }


    public static void main(String[] args) throws Exception {
        JobConf conf = new JobConf(Job1_2_GroupByMark.class);
        conf.setJobName("group_by_mark");

        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(Text.class);

        conf.setMapperClass(Job1_2_GroupByMark.GroupByMarksMap.class);
//        conf.setCombinerClass(Job1_2_GroupByMark.GroupByMarksReduce.class);
        conf.setReducerClass(Job1_2_GroupByMark.GroupByMarksReduce.class);

        conf.setInputFormat(TextInputFormat.class);
        conf.setOutputFormat(TextOutputFormat.class);

        FileInputFormat.setInputPaths(conf, new Path(args[0]));
        FileOutputFormat.setOutputPath(conf, new Path(args[1]));

        JobClient.runJob(conf);
    }
}
