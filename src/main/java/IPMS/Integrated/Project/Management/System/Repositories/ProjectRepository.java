package IPMS.Integrated.Project.Management.System.Repositories;

import IPMS.Integrated.Project.Management.System.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Long> {
}
