package designpattern.command;

public class CloseCommand extends  Command{
        private Receiver receiver;

        public CloseCommand(Receiver receiver) {
                this.receiver = receiver;
        }

        @Override
        public void execute() {
                receiver.close();
        }
}
