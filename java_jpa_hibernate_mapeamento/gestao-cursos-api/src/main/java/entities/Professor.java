package entities;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_professor")
public class Professor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nomeCompleto;

    @Column(name = "numero_matricula")
    private String matricula;

    @Column
    private String email;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "professor")
    private List<Curso> cursos = new ArrayList<>();

    @Override
    public String toString() {
        return "Professor {" +
                "id: " + id +
                ", Nome Completo: '" + nomeCompleto + '\'' +
                ", Matricula: '" + matricula + '\'' +
                ", Email: '" + email + '\'' +
                '}';
    }
}