package IPMS.Integrated.Project.Management.System.Controllers;

import IPMS.Integrated.Project.Management.System.Model.DiscussionForum;
import IPMS.Integrated.Project.Management.System.Services.DiscussionForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/discussion-forums")
public class DiscussionForumController {

    @Autowired
    private DiscussionForumService discussionForumService;

    @GetMapping
    public ResponseEntity<List<DiscussionForum>> getAllDiscussionForums() {
        List<DiscussionForum> discussionForums = discussionForumService.getAllDiscussionForums();
        return ResponseEntity.ok(discussionForums);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiscussionForum> getDiscussionForumById(@PathVariable Long id) {
        DiscussionForum discussionForum = discussionForumService.getDiscussionForumById(id);
        if (discussionForum != null) {
            return ResponseEntity.ok(discussionForum);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<DiscussionForum> createDiscussionForum(@RequestBody DiscussionForum discussionForum) {
        DiscussionForum createdDiscussionForum = discussionForumService.createDiscussionForum(discussionForum);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDiscussionForum);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiscussionForum> updateDiscussionForum(@PathVariable Long id, @RequestBody DiscussionForum updatedDiscussionForum) {
        DiscussionForum discussionForum = discussionForumService.updateDiscussionForum(id, updatedDiscussionForum);
        if (discussionForum != null) {
            return ResponseEntity.ok(discussionForum);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiscussionForum(@PathVariable Long id) {
        discussionForumService.deleteDiscussionForum(id);
        return ResponseEntity.noContent().build();
    }
}
