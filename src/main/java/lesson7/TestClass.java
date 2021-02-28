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

    @Test(priority = 3)
    private void info1(){
        System.out.println("info1");
    }

    @Test(priority = 2)
    private void info2(){
        System.out.println("info2");
    }

    @Test
    private void info3(){
        System.out.println("info3");
    }

    private void info4(){
        System.out.println("info4");
    }

    private void info5(){
        System.out.println("info5");
    }

    @AfterSuite
    public void end() {
        System.out.println("end");
    }

//    @AfterSuite
//    public void end1() {
//        System.out.println("end");
//    }
}
