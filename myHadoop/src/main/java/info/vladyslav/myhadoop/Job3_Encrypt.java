package info.vladyslav.myhadoop;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;
import org.apache.hadoop.fs.Path;
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Job3_Encrypt {
    public static class GroupByMarksMap extends MapReduceBase implements Mapper<Object, Text, Text, Text> {
        ObjectMapper objectMapper = new ObjectMapper();
        StudentsGroupByMark studentsGroupByMark = new StudentsGroupByMark();
        Student student = new Student();

        StudentsGroupByRate studentsGroupByRate = new StudentsGroupByRate();

        public void map(Object key, Text value, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {
            studentsGroupByRate = objectMapper.readValue(value.toString(), StudentsGroupByRate.class);
            StudentsWithSchoolEncr studentsWithSchoolEncr = new StudentsWithSchoolEncr();
            ArrayList<StudentWithSchool> students = studentsGroupByRate.getStudents();
            for (StudentWithSchool studentWithSchool : students) {
                StudentWithSchoolEncr studentWithSchoolEncrypt = new StudentWithSchoolEncr();
                studentWithSchoolEncrypt.setName(Base64.encodeBase64(studentWithSchool.getName().getBytes()));
                studentWithSchoolEncrypt.setMark(studentWithSchool.getMark());
                studentWithSchoolEncrypt.setCLass(studentWithSchool.getCLass());
                studentWithSchoolEncrypt.setSchoolName(studentWithSchool.getSchoolName());
                studentWithSchoolEncrypt.setSchoolAddress(studentWithSchool.getSchoolAddress());

                studentsWithSchoolEncr.getStudentsWithSchoolEncr().add(studentWithSchoolEncrypt);
            }

            String performance = studentsGroupByRate.getPerformance();
            studentsWithSchoolEncr.setPerformance(performance);
            output.collect(new Text(), new Text(objectMapper.writeValueAsString(studentsWithSchoolEncr)));
        }
    }


/*    public static class GroupByMarksReduce extends MapReduceBase implements Reducer<Text, Text, Text, Text> {
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
    }*/


    public static void main(String[] args) throws Exception {
        JobConf conf = new JobConf(Job3_Encrypt.class);
        conf.setJobName("group_by_mark");

        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(Text.class);

        conf.setMapperClass(Job3_Encrypt.GroupByMarksMap.class);
//        conf.setCombinerClass(Job1_2_GroupByMark.GroupByMarksReduce.class);
//        conf.setReducerClass(Job3_Encrypt.GroupByMarksReduce.class);

        conf.setInputFormat(TextInputFormat.class);
        conf.setOutputFormat(TextOutputFormat.class);
        conf.setNumReduceTasks(0);

        FileInputFormat.setInputPaths(conf, new Path(args[0]));
        FileOutputFormat.setOutputPath(conf, new Path(args[1]));

        JobClient.runJob(conf);
    }
}
