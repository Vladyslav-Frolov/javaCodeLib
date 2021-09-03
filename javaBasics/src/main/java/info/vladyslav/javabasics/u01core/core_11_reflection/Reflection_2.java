package info.vladyslav.javabasics.u01core.core_11_reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

import lombok.SneakyThrows;

public class Reflection_2 {
    @SneakyThrows
    public static void main(String[] args) {
        SomeClass someClass = new SomeClass();
        Class<?> aClass = Class.forName(SomeClass.class.getName());
        Constructor<?> constructor = aClass.getConstructor();
        Object object = constructor.newInstance();

        Method[] methods = object.getClass().getMethods();
        Arrays.stream(methods).map(Method::toString).forEach(System.out::println);

    }
}
