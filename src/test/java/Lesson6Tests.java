import lesson6.Main;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

public class Lesson6Tests {

    private static Main main;

    @BeforeEach
    void initialize() {
        main = new Main();
    }

    @ParameterizedTest
    @DisplayName("ConvertTest")
    @MethodSource("convertData")
    public void massConvertTest(int[] original, int[] convert) {
        Assertions.assertArrayEquals(convert, main.convertArrayAfter4(original));
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
    @MethodSource("checkData")
    public void massCheckTest(int[] original) {
        Assumptions.assumeTrue(main.checkArrayFor1or4(original), () -> "false result");
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
}

