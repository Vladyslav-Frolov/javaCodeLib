package info.vladyslav.mytests;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class JsonJettisonTest {
    public static void main(String[] args) throws JSONException {
        // create simple array
        JSONArray pets = new JSONArray();
        pets.put("cat");
        pets.put("dog");
        System.out.println(pets);

        // create simple map
        JSONObject person = new JSONObject();
        person.put("name", "John Brown");
        person.put("age", 35);
        person.put("pets", pets);
        System.out.println(person);

        // create gson with inner array
        JSONObject marks = new JSONObject();

        JSONObject stud = new JSONObject();
        stud.put("name", "Maryna A");
        stud.put("class", "3");
        stud.put("mark", "5");

        JSONObject stud2 = new JSONObject();
        stud2.put("name", "John Brown");
        stud2.put("class", "2");
        stud2.put("mark", "5");

        JSONArray students = new JSONArray();
        students.put(stud);
        students.put(stud2);

        marks.put("mark", 5);
        marks.put("students", students);

        System.out.println(marks);

        // get inner array from json
        JSONArray getJSArray = marks.getJSONArray("students");
        System.out.println(getJSArray);

        // get value from array of jsons
        for (int i = 0; i < getJSArray.length(); i++) {
            System.out.println(getJSArray.getJSONObject(i).getString("name"));
        }

    }
}
