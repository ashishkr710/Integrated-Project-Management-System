package IPMS.Integrated.Project.Management.System.Repositories;

import IPMS.Integrated.Project.Management.System.Model.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File,Long> {
}
