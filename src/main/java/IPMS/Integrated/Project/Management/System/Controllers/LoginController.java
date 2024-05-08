package IPMS.Integrated.Project.Management.System.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Assuming your login page is located in src/main/resources/templates/login.html
    }

}

