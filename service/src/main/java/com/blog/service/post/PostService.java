package com.blog.service.post;

import com.blog.dao.post.PostRepository;
import com.blog.model.post.Post;
import com.blog.service.user.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserService userService;

    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public List<Post> getAllPost(){
        return postRepository.findAll();
    }

    public Post getPostById(Long id){
        return postRepository.findById(id).orElse(null);
    }

    public Post createPost(Post post,String author){
        if(post.getPostId()!=null) return null;
        post.setDateOfPost(new Date());
        post.setDateOfEdit(post.getDateOfPost());
        post.setStars(0);
        post.setAuthor(userService.findByUserName(author));
        return postRepository.save(post);
    }
    public Post updatePost(Post post){
        if(postRepository.existsById(post.getPostId())){
            return postRepository.save(post);
        }
        return null;
    }
    public boolean deletePostById(Long id){
        if(postRepository.existsById(id)) {
            postRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
