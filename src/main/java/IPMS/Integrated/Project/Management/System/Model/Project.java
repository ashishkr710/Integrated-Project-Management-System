package IPMS.Integrated.Project.Management.System.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int projectId;

    @NotNull
    private String projectName;

    private Date startDate;

    private Date endDate;

    private String description;
}
