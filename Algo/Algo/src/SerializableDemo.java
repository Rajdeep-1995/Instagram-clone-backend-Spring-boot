import java.io.*;

public class SerializableDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Demo dm = new Demo();
        System.out.println("Original state of the object");
        System.out.println(dm.i+"....."+ dm.j + "....." +dm.k +  "....." + dm.l + "....." + dm.m);
        // Serialization
        FileOutputStream fos = new FileOutputStream("objectState.src");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(dm);

        System.out.println("********************************************");

        //DeSerialization
        FileInputStream fis = new FileInputStream("objectState.src");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Demo dmsDeserialize = (Demo)ois.readObject();
        System.out.println("Original state of the object retired post DeSerialization");
        System.out.println(dmsDeserialize.i + "....." + dmsDeserialize.j +  "....." + dmsDeserialize.k +
                    "....." +dmsDeserialize.l + "....." + dmsDeserialize.m);
    }
}

 class Demo implements Serializable{
    int i = 20;
    int j = 30;

    /**
     Transient means do not serialize the variable (ex. any security constrains like password or other
     sensitive information)and hence the default value
     of the variable will be saved during Serialization process.(Here default value for int is 0)
     In other word, transient variables do not save their actual values during Serialization.
     */
     transient int k = 40;

     /**
      static variables are class level variables and not object level that is why they do not participate in
      Serialization process. They will be used directly from class level.
      Due to this, it is redundant to use transient keyword with static variables.
      EX.
        transient static int l = 50;
        static int ; = 50;
      These both variables will ignore serialization since they are static.
      */
     static int l = 50;

     /**
      final variables are replaced by its value at compile time hence transient keyword does not apply to them, because
      JVM only checks against the variables (non-final variables) while checking for the access modifiers(transient).
      Due to this behaviour, it is redundant to use transient keyword as the actual value itself will be replaced during
      Serialization process.
      EX.
       transient final int m = 60;
       final int m = 60;
      These both variables will ignore the access specifier(transient) since they are final and the variable names
      get replaced with actual value during compile time by JVM.
      */
      final int m = 60;
}

