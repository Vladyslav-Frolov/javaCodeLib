package info.vladyslav.myhadoop;

import com.fasterxml.jackson.databind.ObjectMapper;
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

public class Job2_AddNameAndAddressOfSchool {
    public static class GroupByMarksMap extends MapReduceBase implements Mapper<Object, Text, Text, Text> {
        ObjectMapper objectMapper = new ObjectMapper();
        StudentsGroupByMark studentsGroupByMark = new StudentsGroupByMark();
        Student student = new Student();
        StudentWithSchool studentWithSchool = new StudentWithSchool();

        public void map(Object key, Text value, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {
            studentsGroupByMark = objectMapper.readValue(value.toString(), StudentsGroupByMark.class);
            student = studentsGroupByMark.getStudents().get(0);
            studentWithSchool.setName(student.getName());
            studentWithSchool.setMark(student.getMark());
            studentWithSchool.setCLass(student.getCLass());
            studentWithSchool.setSchoolName("random school");
            studentWithSchool.setSchoolAddress("random school address");
            Text integer = new Text(Integer.toString(studentsGroupByMark.getMark()));
            output.collect(integer, new Text(objectMapper.writeValueAsString(studentWithSchool)));
        }
    }


    public static class GroupByMarksReduce extends MapReduceBase implements Reducer<Text, Text, Text, Text> {
        public void reduce(Text key, Iterator<Text> values, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {
            ObjectMapper objectMapper = new ObjectMapper();
            ArrayList<StudentWithSchool> studentsWithSchoolBest = new ArrayList<>();
            ArrayList<StudentWithSchool> studentsWithSchoolMiddle = new ArrayList<>();
            ArrayList<StudentWithSchool> studentsWithSchoolWorst = new ArrayList<>();
            StudentsGroupByRate studentsGroupByRate = new StudentsGroupByRate();
//            StudentWithSchool studentWithSchool = new StudentWithSchool();
            while (values.hasNext()) {
                StudentWithSchool student = objectMapper.readValue(values.next().toString(), StudentWithSchool.class);

                if (student.getMark() >= 4 && student.getMark() <= 5)
                    studentsWithSchoolBest.add(student);

                if (student.getMark() == 3)
                    studentsWithSchoolMiddle.add(student);

                if (student.getMark() >= 1 && student.getMark() <= 2)
                    studentsWithSchoolWorst.add(student);
            }
            studentsGroupByRate.setBestStudents(studentsWithSchoolBest);
            studentsGroupByRate.setMiddleStudents(studentsWithSchoolMiddle);
            studentsGroupByRate.setWorstStudents(studentsWithSchoolWorst);


            output.collect(new Text(objectMapper.writeValueAsString(studentsGroupByRate)), new Text());
        }
    }


    public static void main(String[] args) throws Exception {
        JobConf conf = new JobConf(Job2_AddNameAndAddressOfSchool.class);
        conf.setJobName("group_by_mark");

        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(Text.class);

        conf.setMapperClass(Job2_AddNameAndAddressOfSchool.GroupByMarksMap.class);
//        conf.setCombinerClass(Job1_2_GroupByMark.GroupByMarksReduce.class);
        conf.setReducerClass(Job2_AddNameAndAddressOfSchool.GroupByMarksReduce.class);

        conf.setInputFormat(TextInputFormat.class);
        conf.setOutputFormat(TextOutputFormat.class);

        FileInputFormat.setInputPaths(conf, new Path(args[0]));
        FileOutputFormat.setOutputPath(conf, new Path(args[1]));

        JobClient.runJob(conf);
    }
}
