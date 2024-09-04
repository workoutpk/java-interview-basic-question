package designpattern.command;

public class OpenCommand extends Command{
        private Receiver receiver;

        public OpenCommand(Receiver receiver) {
                this.receiver = receiver;
        }

        @Override
        public void execute() {
                receiver.open();
        }
}
