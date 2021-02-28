package lesson7;

import java.lang.reflect.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        Class<?> test = Class.forName("lesson7.TestClass");

        start(test);
    }

    private static void start(Class<?> test) throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        Method[] methods = test.getDeclaredMethods();
        checkAnnotations(methods);
//        Object testObject = test.getDeclaredConstructor().newInstance();
        Object testObject = test.newInstance(); /* Deprecated since 9 version */
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                method.setAccessible(true);
                method.invoke(testObject);
            }
        }
    }

    private static void checkAnnotations(Method[] methods) {
        int count1 = 0, count2 = 0;
        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (++count1 > 1) {
                    throw new RuntimeException();
                }
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                if (++count2 > 1) {
                    throw new RuntimeException();
                }
            }
        }
    }
}
