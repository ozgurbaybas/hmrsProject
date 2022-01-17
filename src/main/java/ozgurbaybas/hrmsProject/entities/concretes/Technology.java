package ozgurbaybas.hrmsProject.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "technologies")
@AllArgsConstructor
@NoArgsConstructor
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "technology_id")
    private int technologyId;

    @Column(name = "candidate_id")
    private int candidateId;

    @Column(name = "name")
    private String technologyName;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "active")
    private boolean active;

}
