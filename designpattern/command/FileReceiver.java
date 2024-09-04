package designpattern.command;

public class FileReceiver implements Receiver{

        @Override
        public void open() {
                System.out.println("Opening the file");
        }

        @Override
        public void close() {
                System.out.println("Closing the file");
        }
}
