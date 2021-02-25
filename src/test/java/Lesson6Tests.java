import lesson6.Main;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Lesson6Tests {

    @ParameterizedTest
    @MethodSource("Exception")
    public void testException(int[] array) {
        Assertions.assertThrows(RuntimeException.class, () -> {
            Main.convertArrayAfter4(array);
        });
    }

    static Stream<Arguments> Exception() {
        return Stream.of(
                Arguments.arguments(new int[]{0, 1, 2, 3, 5, 6}),
                Arguments.arguments(new int[]{0, 1, 2, 3, 5, 8}),
                Arguments.arguments(new int[]{0, 1, 0, 3, 5, 8}),
                Arguments.arguments(new int[]{0, 1, 4, 3, 5, 8})
        );
    }

    @ParameterizedTest
    @DisplayName("ConvertTest")
    @MethodSource("convertData")
    public void massConvertTest(int[] original, int[] convert) {
        Assertions.assertArrayEquals(convert, Main.convertArrayAfter4(original));
    }

    static Stream<Arguments> convertData() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 4, 3, 4, 5, 6}, new int[]{5, 6}),
                Arguments.arguments(new int[]{2, 2, 4, 8, 7, 9}, new int[]{8, 7, 9}),
                Arguments.arguments(new int[]{0, 4, 9, 4, 2, 0}, new int[]{2, 0}),
                Arguments.arguments(new int[]{0, 1, 2, 3, 5, 6}, new int[]{}),
                Arguments.arguments(new int[]{4, 4, 4, 4, 4, 4}, new int[]{}),
                Arguments.arguments(new int[]{1, 3, 8, 4, 0, 0}, new int[]{0, 0})
        );
    }

    @ParameterizedTest
    @DisplayName("CheckTest")
    @MethodSource("generateData")
    public void massCheckTest(int[] original) {
        Assumptions.assumeTrue(Main.checkArrayFor1or4(original), () -> "false result");
    }

    static Stream<Arguments> checkData() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 1, 1, 1, 1, 1}),
                Arguments.arguments(new int[]{4, 4, 4, 4, 4, 4}),
                Arguments.arguments(new int[]{1, 4, 1, 4, 1, 4}),
                Arguments.arguments(new int[]{1, 1, 1, 4, 4, 4}),
                Arguments.arguments(new int[]{1, 4, 3, 4, 4, 4}),
                Arguments.arguments(new int[]{1, 4, 4, 4, 1, 1})
        );
    }

    static Stream<Arguments> generateData() {
        ArrayList<Arguments> data = new ArrayList<>();
        int length = 4;
        for (int i = 0; i < 20; i++) {
            int[] a = new int[length];
            for (int j = 0; j < length; j++) {
                a[j] = (int) (Math.random() * 4 + 1);
            }
            data.add(Arguments.arguments(a));
        }
        return data.stream();
    }
}

