package ozgurbaybas.hrmsProject.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "educations")
@AllArgsConstructor
@NoArgsConstructor
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_id")
    private int educationId;

    @Column(name = "candidate_id")
    private int candidateId;

    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "graduation_date")
    private LocalDate graduationDate;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "active")
    private boolean active;

}
