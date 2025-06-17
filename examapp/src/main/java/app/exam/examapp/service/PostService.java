package app.exam.examapp.service;

import app.exam.examapp.entities.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepo postRepo;

    public Post findPostById(Long id) {
        return postRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("No post with id" + id));
    }

    public List<Post> findAllPost() {
        return postRepo.findAll();
    }

    public Post savePost(Post post) {
        if (post == null) {
            throw new IllegalArgumentException("Something went wrong");
        }

        return postRepo.save(post);
    }

    public Post updatePost(long postId, Post newPost) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new IllegalArgumentException("No post with id" + postId));

        post.setContent(newPost.getContent());
        post.setDepartment(newPost.getDepartment());

        return postRepo.save(post);
    }

    public void deletePost(long postId) {
        postRepo.deleteById(postId);
    }
}
