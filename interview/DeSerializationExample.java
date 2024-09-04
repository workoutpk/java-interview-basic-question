package interview;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerializationExample {
        public static void main(String[] args) throws IOException, ClassNotFoundException {
                //Creating stream to read the object
                ObjectInputStream in=new ObjectInputStream(new FileInputStream("file-ser.txt"));
                People s=(People)in.readObject();
                //printing the data of the serialized object
//                System.out.println(" Age"+s.getAge());
                //closing the stream
                in.close();
        }
}
