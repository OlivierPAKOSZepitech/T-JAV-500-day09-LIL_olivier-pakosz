import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Inspector<T> {
    private Class<T> inspectedClass;

    public Inspector(Class<T> inspectedClass) {
        this.inspectedClass = inspectedClass;
    }

    public void displayInformations() {
        System.out.println("Information of the \"" + inspectedClass.getName() + "\" class:");
        Class<?> superclass = inspectedClass.getSuperclass();
        System.out.println("Superclass: " + (superclass != null ? superclass.getName() : "None"));

        Method[] methods = inspectedClass.getDeclaredMethods();
        Field[] fields = inspectedClass.getDeclaredFields();

        System.out.println(methods.length + " methods:");
        for (Method method : methods) {
            System.out.println("- " + method.getName());
        }

        System.out.println(fields.length + " fields:");
        for (Field field : fields) {
            System.out.println("- " + field.getName());
        }
    }

    public static void main(String[] args) {
        Inspector<Number> inspector = new Inspector<>(Number.class);
        inspector.displayInformations();
    }
}
