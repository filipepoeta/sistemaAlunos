import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Getter @Setter @AllArgsConstructor
public class Aluno {
    public Aluno(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private int id;
        private String firstName;
        private String lastName;
        private List<Double> notas = new ArrayList<>();

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Aluno aluno = (Aluno) o;
            return id == aluno.id && Objects.equals(firstName, aluno.firstName) && Objects.equals(lastName, aluno.lastName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, firstName, lastName);
        }

        @Override
        public String toString() {
            return "Aluno{" +
                    "id=" + id +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", notas=" + notas +
                    '}';
        }

}
