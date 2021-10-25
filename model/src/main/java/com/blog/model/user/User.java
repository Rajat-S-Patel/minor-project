package com.blog.model.user;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
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
    private Date dateOfBirth;
    private Date dateOfRegistration;



}
