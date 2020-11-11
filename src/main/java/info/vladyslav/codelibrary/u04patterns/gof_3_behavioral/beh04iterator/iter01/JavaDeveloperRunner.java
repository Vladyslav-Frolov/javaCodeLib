package info.vladyslav.codelibrary.u04patterns.gof_3_behavioral.beh04iterator.iter01;

public class JavaDeveloperRunner {
    public static void main(String[] args) {
        String[] skills = {"Java", "Spring", "Hibernate", "Maven", "PostgresSQL"};

        JavaDeveloper javaDeveloper = new JavaDeveloper("Vladyslav Frolov", skills);

        Iterator iterator = javaDeveloper.getIterator();
        System.out.println("Developer: " + javaDeveloper.getName());
        System.out.println("Skills: ");

        while (iterator.hasNext()){
            System.out.println(iterator.next().toString() + " ");
        }
    }
}
