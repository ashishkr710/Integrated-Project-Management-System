package IPMS.Integrated.Project.Management.System.Services;

import IPMS.Integrated.Project.Management.System.Model.DiscussionForum;
import IPMS.Integrated.Project.Management.System.Repositories.DiscussionForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussionForumService {
    @Autowired
    private DiscussionForumRepository discussionForumRepository;

    public List<DiscussionForum> getAllDiscussionForums() {
        return discussionForumRepository.findAll();
    }

    public DiscussionForum getDiscussionForumById(Long id) {
        return discussionForumRepository.findById(id).orElse(null);
    }

    public DiscussionForum createDiscussionForum(DiscussionForum discussionForum) {
        return discussionForumRepository.save(discussionForum);
    }

    public DiscussionForum updateDiscussionForum(Long id, DiscussionForum updatedDiscussionForum) {
        if (discussionForumRepository.existsById(id)) {
            updatedDiscussionForum.setForumId(id);
            return discussionForumRepository.save(updatedDiscussionForum);
        }
        return null;
    }

    public void deleteDiscussionForum(Long id) {
        discussionForumRepository.deleteById(id);
    }
}
