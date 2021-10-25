package com.blog.model.user;

import com.blog.model.post.Post;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

@Entity
@NoArgsConstructor
@ToString
@Data
public class User {
    @Id
    private String username;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String bio;
    private String profileImageUrl;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    private Date dateOfRegistration;

    @OneToMany(mappedBy = "author")
    @JsonIgnore
    private Collection<Post> posts;
}
