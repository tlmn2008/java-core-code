package kenny.lang.serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerialVersionUIDTest {

    public static void main(String[] args) throws Exception{

        Person person = new Person();
        person.setName("kenny");

        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream("test"));
        oo.writeObject(person);
        oo.close();

        ObjectInputStream oi = new ObjectInputStream(new FileInputStream("test"));
        Person person_back = (Person)oi.readObject();

        System.out.println("hi, my name is "+person_back.getName());
        oi.close();
    }
}
