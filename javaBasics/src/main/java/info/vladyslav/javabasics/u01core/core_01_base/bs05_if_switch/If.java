package info.vladyslav.javabasics.u01core.core_01_base.bs05_if_switch;

public class If {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        if (5 == ++i) {
            System.out.println(j++);
        } else if (5 == ++i){
            System.out.println(j++);
        } else if (5 == ++i) {
            System.out.println(j++);
        } else if (5 == ++i) {
            System.out.println(j++);
        } else if (5 == ++i) {
            System.out.println(j++);
            System.out.println(j++);
        }
    }
}
