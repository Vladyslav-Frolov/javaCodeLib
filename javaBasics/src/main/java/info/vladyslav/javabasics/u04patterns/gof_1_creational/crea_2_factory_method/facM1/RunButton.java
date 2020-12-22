package info.vladyslav.javabasics.u04patterns.gof_1_creational.crea_2_factory_method.facM1;


public class RunButton {
    public static void main(String[] args) {
        ButtonFactory buttonFactory = createButtonByName("Windows"); // the new approach

        Button button = buttonFactory.createButton();
        button.wrightButtonName();
    }

    static ButtonFactory createButtonByName(String buttonName){
        if(buttonName.equalsIgnoreCase("Windows")){
            return new WindowsButtonFactory();
        } else if (buttonName.equalsIgnoreCase("HTML")){
            return new HTTPButtonFactory();
        }
        else {
            throw new RuntimeException(buttonName + " is unknown buttonName.");
        }
    }
}
