package ozgurbaybas.hrmsProject.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "work_experiences")
@AllArgsConstructor
@NoArgsConstructor
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_experience_id")
    private int workExperienceId;

    @Column(name = "candidate_id")
    private int candidateId;

    @Column(name = "job_name")
    private String jobName;

    @Column(name = "job_position_name")
    private String jobPositionName;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "active")
    private boolean active;

}
