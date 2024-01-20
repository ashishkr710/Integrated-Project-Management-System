package IPMS.Integrated.Project.Management.System.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int taskId;

    @NotNull
    private String taskName;

    private String description;

    private Date startDate;

    private Date endDate;

    @NotNull
    private String status;
}
