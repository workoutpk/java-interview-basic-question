package interview;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;

public class MetaspaceExample {
    public static void main(String[] args) {
        for (MemoryPoolMXBean mpBean : ManagementFactory.getMemoryPoolMXBeans()) {
            if (mpBean.getName().contains("Metaspace")) {
                System.out.println("Metaspace Usage:");
                System.out.println("Used: " + mpBean.getUsage().getUsed() / 1024 + " KB");
                System.out.println("Committed: " + mpBean.getUsage().getCommitted() / 1024 + " KB");
                System.out.println("Max: " + (mpBean.getUsage().getMax() == -1 ? "Unlimited" : mpBean.getUsage().getMax() / 1024 + " KB"));
            }
        }
    }
}
