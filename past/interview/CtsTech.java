package past.interview;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class CtsTech {
    public static void main(String[] args) {
        Set<Patient> patientSet =  new HashSet<>();
        patientSet.add(new Patient(1,"abc1", "A"));
        patientSet.add(new Patient(2,"abc2", "B"));
        patientSet.add(new Patient(3,"abc3", "C"));
        patientSet.add(new Patient(4,"abc4", "D"));

        Map<Integer, Patient> patientMap =  new ConcurrentHashMap<>();
        patientMap.put(1, new Patient(1,"abc1", "A"));
        patientMap.put(2, new Patient(2,"abc2", "E"));
        patientMap.put(3, new Patient(3,"abc3", "B"));
        patientMap.put(4, new Patient(4,"abc4", "C"));
        patientMap.put(5, new Patient(5,"abc5", "D"));


        patientMap.entrySet().stream().map(m->m.getValue())
                .filter(f->f.bloodGroup.equals("A")).forEach(System.out::println);
        List<String> patientName = patientMap.entrySet().stream().map(m->m.getValue())
                .filter(f->f.bloodGroup.equals("A"))
                .map(m->m.getName()).collect(Collectors.toList());

        System.out.println("Patinet Name  ::: " + patientName);
    }
}
