package az.coders.Design.homes.service;

import az.coders.Design.homes.dto.ListBloglDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ListBlogService {
    List<ListBloglDto> getAllBlogs();        // Get all blogs
    ListBloglDto getBlogById(Integer id);    // Get a single blog by ID
    ListBloglDto saveBlog(ListBloglDto blog);  // Add new blog
    ListBloglDto updateBlog(Integer id, ListBloglDto blog); // Update existing blog
    void deleteBlog(Integer id);           // Delete a blog
    List<ListBloglDto> getRecentBlogs();  // at end of page gave 2 recommented blog
}
