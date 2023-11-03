import java.lang.reflect.Method;

public class TestRunner {
    public static void runTests(Class<?> testClass) {
        Method[] methods = testClass.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                Test testAnnotation = method.getAnnotation(Test.class);
                if (testAnnotation.enabled()) {
                    String testName = testAnnotation.name();
                    System.out.println("Running test: " + testName);

                    try {
                        method.invoke(testClass.newInstance());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // Example usage
        runTests(MyTestSuite.class);
    }
}
