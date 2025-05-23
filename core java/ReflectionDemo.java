import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectionDemo {
    public static void main(String[] args) {
        try {
            // 1. Load the class dynamically
            Class<?> clazz = Class.forName("Sample");

            // 2. Create an instance of the class
            Object obj = clazz.getDeclaredConstructor().newInstance();

            // 3. Get all declared methods
            Method[] methods = clazz.getDeclaredMethods();

            for (Method method : methods) {
                System.out.println("Method Name: " + method.getName());

                Parameter[] params = method.getParameters();
                System.out.print("Parameters: ");
                if (params.length == 0) {
                    System.out.print("None");
                } else {
                    for (Parameter param : params) {
                        System.out.print(param.getType().getSimpleName() + " " + param.getName() + ", ");
                    }
                }
                System.out.println();

                if (method.getName().equals("greet")) {
                    method.invoke(obj, "World");
                }

                if (method.getName().equals("add")) {
                    method.setAccessible(true);
                    Object result = method.invoke(obj, 5, 7);
                    System.out.println("Result of add(5,7): " + result);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

*/
output
  C:\Users\cse&student\Documents>java ReflectionDemo
Method Name: greet
Parameters: String arg0,
Hello, World!
Method Name: show
Parameters: None
Method Name: add
Parameters: int arg0, int arg1,
Result of add(5,7): 12
*/
  
  
