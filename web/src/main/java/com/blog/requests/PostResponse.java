package com.blog.requests;

import com.blog.model.post.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse {
    private Long postId;
    private String title;
    private String content;
    private Integer stars;
    private String titleImageUrl;
    private Date dateOfPost;
    private Date dateOfEdit;
    private String author;

    public PostResponse(Post post){
        this.postId=post.getPostId();
        this.title=post.getTitle();
        this.content=post.getContent();
        this.stars=post.getStars();
        this.titleImageUrl= post.getTitleImageUrl();
        this.dateOfEdit=post.getDateOfEdit();
        this.dateOfPost=post.getDateOfPost();
        this.author=post.getAuthor().getUsername();
    }
}
