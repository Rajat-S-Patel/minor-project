package com.blog.model.post;
import com.blog.model.user.User;
import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Post {
    private static final int MIN_TITLE_LENGTH = 7;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;


    @Column(name = "title", nullable = false)
    private String title;

    @Lob
    @Column(name = "content",nullable = false)
    private String content;

    @Column(name = "stars",nullable = false,columnDefinition = "int default 0")
    private Integer stars;

    @Column(name = "title_image_url",nullable = false)
    private String titleImageUrl;

    @CreationTimestamp
    @Column(name = "date_of_post",nullable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfPost;

    @CreationTimestamp
    @Column(name = "date_of_edit",nullable = false,updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfEdit;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "author",referencedColumnName = "username",nullable = false)
    private User author;

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", stars=" + stars +
                ", titleImageUrl='" + titleImageUrl + '\'' +
                ", dateOfPost=" + dateOfPost +
                ", dateOfEdit=" + dateOfEdit +
                '}';
    }
}
