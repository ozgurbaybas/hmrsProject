package ozgurbaybas.hrmsProject.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "type_of_works")
public class TypeOfWork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int typeOfWorkId;

    @Column(name = "name")
    private String typeOfWorkName;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "active")
    private boolean active;

}
