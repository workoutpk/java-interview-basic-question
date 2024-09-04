package designpattern.state;

public class Context {
        private State state;

        public Context() {
                state = new OnState();
        }

        public void setState(State state) {
                this.state = state;
        }

        public State getState() {
                return state;
        }
}
