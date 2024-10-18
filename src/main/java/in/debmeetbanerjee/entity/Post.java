package in.debmeetbanerjee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Post {
    @Id
    private String postId;
    private String caption;
    private String image;
    @ManyToOne
    private User user;
}
