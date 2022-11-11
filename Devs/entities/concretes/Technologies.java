package kodlama.io.Devs.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name="technologies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Technologies extends ProgramingLanguage {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "Language_id")
    private ProgramingLanguage language;

}
