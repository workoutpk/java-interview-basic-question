package circuit_barrier;

public enum CircuitBreakerState {

        CLOSED("CLOSED"),
        OPEN("OPEN"),
        HALF_OPEN("HALF_OPEN"),
        DISABLED("DISABLED"),
        FORCED_OPEN("FORCED_OPEN");

        private final String name;

        CircuitBreakerState(String name) {
                this.name = name;
        }

        public String getName() {
                return name;
        }
}
