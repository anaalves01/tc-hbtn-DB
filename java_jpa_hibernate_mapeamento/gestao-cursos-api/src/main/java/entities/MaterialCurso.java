package entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_material_curso")
public class MaterialCurso implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String url;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "materialCurso")
    private Curso curso;

    @Override
    public String toString() {
        return "Material Curso {" +
                "id: " + id +
                ", url: '" + url + '\'' +
                '}';
    }
}