package az.coders.Design.homes.controller;

import az.coders.Design.homes.dto.ListBloglDto;
import az.coders.Design.homes.service.ListBlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/blog-detail")
public class ListBlogController {
        private final ListBlogService listBlogService;
    @GetMapping
    public ResponseEntity<List<ListBloglDto>> getAllBlogs() {
        return ResponseEntity.ok(listBlogService.getAllBlogs());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ListBloglDto> getBlogById(@PathVariable Integer id) {
        return ResponseEntity.ok(listBlogService.getBlogById(id));
    }
    @PostMapping
    public ResponseEntity<ListBloglDto> saveBlog(@RequestBody ListBloglDto blogDto) {
        return ResponseEntity.ok(listBlogService.saveBlog(blogDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ListBloglDto> updateBlog(@PathVariable Integer id, @RequestBody ListBloglDto blogDto) {
        return ResponseEntity.ok(listBlogService.updateBlog(id, blogDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable Integer id) {
        listBlogService.deleteBlog(id);
        return ResponseEntity.noContent().build();
    }

    // Get recent 2 blogs
    @GetMapping("/recent")
    public ResponseEntity<List<ListBloglDto>> getRecentBlogs() {
        return ResponseEntity.ok(listBlogService.getRecentBlogs());
    }
}
