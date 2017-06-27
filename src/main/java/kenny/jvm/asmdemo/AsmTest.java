package kenny.jvm.asmdemo;

import com.sun.xml.internal.ws.org.objectweb.asm.ClassWriter;
import com.sun.xml.internal.ws.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;

import java.io.*;


/*
import java.io.PrintStream;
public class Programmer
{
  public void code()
  {
    System.out.println("I'm a programmer, just coding ...");
  }
}
*/

// 先用ASM生成上面的Programmer，
// 然后再通过classloader拿入内存。

public class AsmTest {

    public static void main(String[] args) {

        ClassWriter classWriter = new ClassWriter(0);
        classWriter.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Programmer", null, "java/lang/Object", null);

        MethodVisitor mv = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
        mv.visitCode();
        mv.visitVarInsn(Opcodes.AALOAD, 0);
        mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitEnd();

        MethodVisitor methodVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "code", "()V", null, null);
        methodVisitor.visitCode();
        methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "java/io/PrintStream");
        methodVisitor.visitLdcInsn("I'm a programmer, just coding ...");
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V");
        methodVisitor.visitInsn(Opcodes.RETURN);
        methodVisitor.visitMaxs(2, 2);
        methodVisitor.visitEnd();

        byte[] data = classWriter.toByteArray();
        File file = new File("C:/Users/emigkag/Programmer.class");
        try {
            FileOutputStream fout = new FileOutputStream(file);
            fout.write(data);
            fout.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try{
            System.out.println("load programmer begin!");

            InputStream in = new FileInputStream("C:/Users/emigkag/Programmer.class");
            byte[] buffer = new byte[1024];

            int count = in.read(buffer);

            MyClassLoader clsLoader = new MyClassLoader();
            Class<?> clazz = clsLoader.defineMyClass(buffer, 0, count);

            Object obj = clazz.newInstance();
            clazz.getMethod("code", null).invoke(obj, null);

            System.out.println("load programmer end!");
        } catch(Exception e){

        }


    }
}
