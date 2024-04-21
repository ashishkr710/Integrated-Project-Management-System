package IPMS.Integrated.Project.Management.System.Repositories;

import IPMS.Integrated.Project.Management.System.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
