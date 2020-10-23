package info.vladyslav.codeLibrary.z_test;

public class Z_10 {


    public static void main(String[] args) {
        String forward = "redirect/frontControllerServlet?command=ownCabinet";
        forward = forward.replaceAll("\\Q redirect\\E", "");
        System.out.println(forward);
    }
}
