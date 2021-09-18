package info.vladyslav.javabasics.u01core.core_11_reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLOutput;
import java.util.Objects;
import java.util.Scanner;

public class Reflection_ {
    private int number;
    private String name = "default";

        public Reflection_(int number, String name) {
        this.number = number;
        this.name = name;
    }
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void printData() {
        System.out.println(number + name);
    }

    public static void main(String[] args) {
        Reflection_ reflection = new Reflection_(0, "default");
        int number = reflection.getNumber();
        String name = null; //no getter =(
        System.out.println(number + name); //output --> 0null
        try {
            Field field = reflection.getClass().getDeclaredField("name");
            field.setAccessible(true);
            name = (String) field.get(reflection); // <-- get field
            System.out.println(number + name); //output --> 0default
            field.set(reflection, "new value");
            name = (String) field.get(reflection); // <-- get field
            System.out.println(number + name); //output --> 0new value

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        printDataWithReflection(reflection); //output --> 0new value

        Reflection_ reflection2 = null;

        Class<?> clazz = null;
        try {
            clazz = Class.forName(Reflection_.class.getName());
            Class<?>[] params = {int.class, String.class};
            reflection2 = (Reflection_) clazz.getConstructor(params).newInstance(1, "default2");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(reflection2);//--> info.vladyslav.javabasics.u01core.core_11_reflection.Reflection_@42d3bd8b
        System.out.println("======================================================");

        Constructor<?>[] constructors = Objects.requireNonNull(clazz).getConstructors();
        for (Constructor<?> constructor : constructors) {
            Class<?>[] paramTypes = constructor.getParameterTypes();
            for (Class<?> paramType : paramTypes) {
                System.out.print(paramType.getName() + " ");
            }
            System.out.println();
        }
    }

    public static void printDataWithReflection(Object myClass) {
        try {
            Method method = myClass.getClass().getDeclaredMethod("printData");
            method.setAccessible(true);
            method.invoke(myClass);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
