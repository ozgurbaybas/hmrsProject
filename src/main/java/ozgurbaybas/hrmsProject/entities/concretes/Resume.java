package ozgurbaybas.hrmsProject.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "resumes")
@AllArgsConstructor
@NoArgsConstructor
public class Resume {

    @Id
    @Column(name = "resume_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int resumeId;

    @Column(name = "candidate_id")
    private int candidateId;

    @Column(name = "cover_letter")
    private String coverLetter;

    @Column(name = "github_link")
    private String githubLink;

    @Column(name = "linkedin_link")
    private String linkedinLink;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "active")
    private boolean active;

}