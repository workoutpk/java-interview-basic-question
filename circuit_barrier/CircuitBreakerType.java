package circuit_barrier;

public enum CircuitBreakerType {

        STATELESS("STATELESS"),
        STATEFUL("STATEFUL");

        private final String name;

        CircuitBreakerType(String name) {
                this.name = name;
        }

        public String getName() {
                return name;
        }
}

