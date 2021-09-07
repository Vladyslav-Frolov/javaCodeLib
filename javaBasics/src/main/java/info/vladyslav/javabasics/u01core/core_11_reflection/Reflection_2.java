package info.vladyslav.javabasics.u01core.core_11_reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.stream.Collectors;

import lombok.SneakyThrows;

public class Reflection_2 {
    @SneakyThrows
    public static void main(String[] args) {

        // 1 --> class
        System.out.println("-------class---------");
        System.out.println(SomeClass.class.getName());

        Class<?> aClass = Class.forName(SomeClass.class.getName());

        // 2 --> constructor
        Constructor<?> constructor = aClass.getConstructor();

        // 3 --> object
        Object object = constructor.newInstance();

        // object in one row
        Object objInRow = aClass.getConstructor().newInstance();
        Object objInRowSet = aClass.getConstructor(String.class).newInstance("set my string");

        // 4 --> method
        // methods
        Method[] methods = object.getClass().getMethods();

        // specific method
        System.out.println("-------specific method---------");
        Method sMethod = objInRow.getClass().getMethod("someMethodThird", String.class, int.class, boolean.class);
        System.out.println(sMethod); // public void info.vladyslav.javabasics.u01core.core_11_reflection.SomeClass.someMethodThird(java.lang.String,int,boolean)

        // method name
        System.out.println("-------method name---------");
        String methodName = objInRow.getClass().getMethods()[0].toString(); // but they go out of order
        System.out.println(methodName); // public void info.vladyslav.javabasics.u01core.core_11_reflection.SomeClass.someMethod()
        String s = methodName
                .split("\\(")[0]
                .split("\\.")[methodName.split("\\(")[0].split("\\.").length - 1];
        System.out.println(s);

        // invoke particular method by index of method // but they go out of order
//        methods[0].invoke(object.getClass().getConstructor().newInstance(), (Object) null); // I am here

        // invoke particular method by name from object
        System.out.println("-------invoke method---------");
        objInRow.getClass().getMethod("someMethodSecond", String.class)
                .invoke(objInRow.getClass().getConstructor().newInstance(), (Object) null); // I am here second

        objInRow.getClass().getMethod("someMethodThird", String.class, int.class, boolean.class)
                .invoke(objInRow.getClass().getConstructor().newInstance(), " test for third", 1, true); // I am here third test for third

        objInRowSet.getClass().getMethod("printSetString")
                .invoke(objInRowSet.getClass().getConstructor(String.class).newInstance("my set string")); // my set string

        objInRow.getClass().getMethod("printStringAndSetString", String.class)
                .invoke(objInRow.getClass().getConstructor(String.class).newInstance("my set string"),
                        " and args set"); // my set string and args set

        aClass.getConstructor().newInstance().getClass()
                .getMethod("printStringAndSetString", String.class)
                        .invoke(aClass.getConstructor(String.class).newInstance("init via class constructor"),
                                " and args set"); // init via class constructor and args set

        // 5 --> parameter
        // parameters
        System.out.println("-------parameters---------");
        Parameter[] parameters = sMethod.getParameters();
        System.out.println(Arrays.toString(parameters));

        Parameter parameter = parameters[0];
        parameter.getType();

        // parameters type
        System.out.println("-------parameters type---------");
        Class<?>[] parameterType = sMethod.getParameterTypes();
        System.out.println(Arrays.toString(parameterType));

        Class<?>[] parameterType2 = Arrays.stream(parameters)
                .map(Parameter::getType)
                .toArray(Class[]::new);
        System.out.println(Arrays.toString(parameterType2));


        // 6 --> other
        System.out.println("==========Methods=============");
        Arrays.stream(methods).map(Method::toString).forEach(System.out::println);

    }

    /** I need (array and particular)
     * class
     * constructor
     * object (instance)
     * method
     * parameter of method
     * */
}
