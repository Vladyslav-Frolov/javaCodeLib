package info.vladyslav.codeLibrary.u04patterns.gof_2_structural.str4decorator;

public class Task {
    public static void main(String[] args) {
        Developer developer = new JavaTeamLead(new SeniorJavaDeveloper(new JavaTeamLead(new SeniorJavaDeveloper(new JavaDeveloper()))));
        System.out.println(developer.makeJob());
    }
}
