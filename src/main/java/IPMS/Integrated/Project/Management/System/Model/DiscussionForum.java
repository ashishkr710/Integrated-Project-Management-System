package IPMS.Integrated.Project.Management.System.Model;


import jakarta.persistence.*;
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
@Table(name = "DiscussionForum")
public class DiscussionForum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long forumId;

    @ManyToOne
    @JoinColumn(name = "projectId")
    private Project projectId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User userId;

    private String message;

    private Date TimmeStamp;

}
