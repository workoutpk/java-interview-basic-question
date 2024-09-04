package interview;

import java.io.*;

public class SerializationExample {
        public static void main(String[] args) throws IOException, ClassNotFoundException {
                People people =new People("s1",24);
                FileOutputStream fileOutputStream = new FileOutputStream("file-ser.txt");
                ObjectOutput objectOutput = new ObjectOutputStream(fileOutputStream);

                System.out.println("Start writing ...");
                objectOutput.write(people.getAge());
                objectOutput.flush();
                System.out.println("Start flushing ...");
                objectOutput.close();
                System.out.println("File closed ...");

        }
}
