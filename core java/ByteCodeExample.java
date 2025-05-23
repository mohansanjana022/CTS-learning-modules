public class BytecodeExample {

    public int square(int x) {
        return x * x;
    }

    public static void main(String[] args) {
        BytecodeExample example = new BytecodeExample();
        int result = example.square(7);
        System.out.println("Square of 7 is: " + result);
    }
}



//output

C:\Users\cse&student\Documents>javac BytecodeExample.java

C:\Users\cse&student\Documents>javap -c BytecodeExample
Compiled from "BytecodeExample.java"
public class BytecodeExample {
  public BytecodeExample();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public int square(int);
    Code:
       0: iload_1
       1: iload_1
       2: imul
       3: ireturn

  public static void main(java.lang.String[]);
    Code:
       0: new           #7                  // class BytecodeExample
       3: dup
       4: invokespecial #9                  // Method "<init>":()V
       7: astore_1
       8: aload_1
       9: bipush        7
      11: invokevirtual #10                 // Method square:(I)I
      14: istore_2
      15: getstatic     #14                 // Field java/lang/System.out:Ljava/io/PrintStream;
      18: iload_2
      19: invokedynamic #20,  0             // InvokeDynamic #0:makeConcatWithConstants:(I)Ljava/lang/String;
      24: invokevirtual #24                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      27: return
}
