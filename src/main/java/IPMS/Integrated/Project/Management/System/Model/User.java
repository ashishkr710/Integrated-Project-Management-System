package IPMS.Integrated.Project.Management.System.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
//import reactor.util.annotation.NonNull;

import java.math.BigInteger;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;


    @NotNull
    @Column(nullable = false)
    private String UserName;


    @Column(nullable = false, unique = true)
    @NotNull
    @Email(message = "{error.invalid_email}")
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String role;

    public User(Long userId) {
        this.userId = userId;
    }
}
