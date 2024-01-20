package IPMS.Integrated.Project.Management.System.Repositories;

import IPMS.Integrated.Project.Management.System.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
