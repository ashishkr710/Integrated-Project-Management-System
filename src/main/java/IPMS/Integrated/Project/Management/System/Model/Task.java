package IPMS.Integrated.Project.Management.System.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name ="task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long taskId;

    @NotNull
    private String taskName;

    private String description;

    private Date startDate;

    private Date endDate;

    @NotNull
    private String status;
}
