package lesson7;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.*;

public class Main {

    private static final int MAX_PRIORITY = 10;
    private static final int MIN_PRIORITY = 1;

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException {
        start(TestClass.class);
    }

    public static void start(Class<?> test) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Method[] methods = test.getDeclaredMethods();
        checkAnnotations(methods, BeforeSuite.class);
        checkAnnotations(methods, AfterSuite.class);
//        Object testObject = test.getDeclaredConstructor().newInstance();
        Object testObject = test.newInstance();  // Deprecated since 9 version
        doMethods(methods, testObject, BeforeSuite.class);
        doMethods(methods, testObject, Test.class);
        doMethods(methods, testObject, AfterSuite.class);
    }

    private static void checkAnnotations(Method[] methods, Class<? extends Annotation> annotationClass) {
        int count = 0;
        for (Method method : methods) {
            if (method.isAnnotationPresent(annotationClass)) {
                if (++count > 1) {
                    throw new RuntimeException();
                }
            }
        }
    }

    private static void doMethods(Method[] methods, Object testObject, Class<? extends Annotation> annotationClass) throws InvocationTargetException, IllegalAccessException {
        if (annotationClass.getName().equals(Test.class.getName())) {
            doTestMethods(methods, testObject);
            return;
        }
        for (Method method : methods) {
            if (method.isAnnotationPresent(annotationClass)) {
                method.setAccessible(true);
                method.invoke(testObject);
            }
        }
    }

    private static void doTestMethods(Method[] methods, Object testObject) throws InvocationTargetException, IllegalAccessException {
        TreeMap<Integer, ArrayList<Method>> treeMap = new TreeMap<>();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                int priority = method.getAnnotation(Test.class).priority();
                if (priority >= MIN_PRIORITY && priority <= MAX_PRIORITY) {  // Set priority range. Out of range will be ignore
                    treeMap.computeIfAbsent(priority, k -> new ArrayList<>()).add(method);
                    method.setAccessible(true);
                }
            }
        }
        for (ArrayList<Method> toDo : treeMap.values()) {
            for (Method m : toDo) {
                m.invoke(testObject);
                System.out.print(System.lineSeparator());  // Chose this line or next, if need to display priority
//                System.out.println(" priority = " + m.getAnnotation(Test.class).priority());
            }
        }
    }
}
