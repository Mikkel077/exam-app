package app.exam.examapp.controller;

import app.exam.examapp.entities.Post;
import app.exam.examapp.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return ResponseEntity.ok(postService.savePost(post));
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postService.findAllPost());
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable long postId) {
        return ResponseEntity.ok(postService.findPostById(postId));
    }

    @PutMapping
    public ResponseEntity<Post> updatePost(@RequestBody Post post) {
        return ResponseEntity.ok(postService.updatePost(post.getId(), post));
    }

    @DeleteMapping
    public ResponseEntity<String> deletePost(@RequestBody Post post) {
        postService.deletePost(post.getId());
        return ResponseEntity.ok("Deleted post with id " + post.getId());
    }

}
