package interview;

import java.io.Serializable;
import java.util.Objects;

public class People implements Serializable {
        String name;
        int age;

        public People(String name, int age) {
                this.name = name;
                this.age = age;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public int getAge() {
                return age;
        }

        public void setAge(int age) {
                this.age = age;
        }

        @Override
        public String toString() {
                return "People{" +
                        "name='" + name + '\'' +
                        ", age=" + age +
                        '}';
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof People people)) return false;
                return getAge() == people.getAge() && Objects.equals(getName(), people.getName());
        }

        @Override
        public int hashCode() {
                return Objects.hash(getName(), getAge());
        }
}
