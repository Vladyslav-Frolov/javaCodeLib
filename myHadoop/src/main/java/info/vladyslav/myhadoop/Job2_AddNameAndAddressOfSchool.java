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
        ArrayList<StudentWithSchool> studentsWithSchool = new ArrayList<>();
        StudentsWithSchool studentssWithSchool = new StudentsWithSchool();

        public void map(Object key, Text value, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {
            studentsGroupByMark = objectMapper.readValue(value.toString(), StudentsGroupByMark.class);
            ArrayList<Student> students = studentsGroupByMark.getStudents();
            int i = 0;
            for (Student studentIter : students) {
                StudentWithSchool studentWithSchool = new StudentWithSchool();
                studentWithSchool.setName(studentIter.getName());
                studentWithSchool.setMark(studentIter.getMark());
                studentWithSchool.setCLass(studentIter.getCLass());
                studentWithSchool.setSchoolName("random school");
                studentWithSchool.setSchoolAddress("random school address");
                studentsWithSchool.add(i, studentWithSchool);
                i++;
            }

            studentssWithSchool.setStudentsWithSchool(studentsWithSchool);
            Text performance = new Text();
            if (studentsGroupByMark.getMark() >= 1 && studentsGroupByMark.getMark() <= 2) {
                performance = new Text("worstStudents");
            }

            if (studentsGroupByMark.getMark() == 3) {
                performance = new Text("middleStudents");
            }

            if (studentsGroupByMark.getMark() >= 4 && studentsGroupByMark.getMark() <= 5) {
                performance = new Text("bestStudents");
            }

            output.collect(performance, new Text(objectMapper.writeValueAsString(studentssWithSchool)));
        }
    }

    public static class GroupByMarksReduce extends MapReduceBase implements Reducer<Text, Text, Text, Text> {
        public void reduce(Text key, Iterator<Text> values, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {
            ObjectMapper objectMapper = new ObjectMapper();
            ArrayList<StudentWithSchool> studentsWithSchool = new ArrayList<>();
            StudentsGroupByRate studentsGroupByRate = new StudentsGroupByRate();
            while (values.hasNext()) {
                StudentsWithSchool students = objectMapper.readValue(values.next().toString(), StudentsWithSchool.class);

                ArrayList<StudentWithSchool> studentssWithSchool = students.getStudentsWithSchool();
                for (StudentWithSchool studentWithSchool : studentssWithSchool) {
                    if (studentWithSchool.getMark() >= 4 && studentWithSchool.getMark() <= 5)
                        studentsWithSchool.add(studentWithSchool);

                    if (studentWithSchool.getMark() == 3)
                        studentsWithSchool.add(studentWithSchool);

                    if (studentWithSchool.getMark() >= 1 && studentWithSchool.getMark() <= 2)
                        studentsWithSchool.add(studentWithSchool);
                }

            }
            studentsGroupByRate.setStudents(studentsWithSchool);
            studentsGroupByRate.setPerformance(key.toString());



            output.collect(new Text(objectMapper.writeValueAsString(studentsGroupByRate)), new Text());
        }
    }


    public static void main(String[] args) throws Exception {
        JobConf conf = new JobConf(Job2_AddNameAndAddressOfSchool.class);
        conf.setJobName("group_by_mark");

        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(Text.class);

        conf.setMapperClass(Job2_AddNameAndAddressOfSchool.GroupByMarksMap.class);
        conf.setReducerClass(Job2_AddNameAndAddressOfSchool.GroupByMarksReduce.class);

        conf.setInputFormat(TextInputFormat.class);
        conf.setOutputFormat(TextOutputFormat.class);

        FileInputFormat.setInputPaths(conf, new Path(args[0]));
        FileOutputFormat.setOutputPath(conf, new Path(args[1]));

        JobClient.runJob(conf);
    }
}
