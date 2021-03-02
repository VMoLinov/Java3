package lesson7;

public class TestClass {

    @BeforeSuite
    private void begin() {
        System.out.println("Begin");
    }

//    @BeforeSuite
//    private void begin1() {
//        System.out.println("Begin");
//    }

    @Test(priority = 5)
    public void info1() {
        System.out.print("info1");
    }

    @Test(priority = 5)
    private void info2() {
        System.out.print("info2");
    }

    @Test(priority = 10)
    private void info3() {
        System.out.print("info3");
    }

    @Test(priority = 1)
    private void info4() {
        System.out.print("info4");
    }

    @Test
    private void info5() {
        System.out.print("info5");
    }

    @AfterSuite
    public void end() {
        System.out.println("End");
    }

//    @AfterSuite
//    public void end1() {
//        System.out.println("End");
//    }
}
