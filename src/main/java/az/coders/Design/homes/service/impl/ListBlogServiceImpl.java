package az.coders.Design.homes.service.impl;

import az.coders.Design.homes.config.EnhancedObjectMapper;
import az.coders.Design.homes.dto.ListBloglDto;
import az.coders.Design.homes.entity.blog.ListBlog;
import az.coders.Design.homes.enums.ErrorCode;
import az.coders.Design.homes.exception.NotFoundException;
import az.coders.Design.homes.repository.ListBlogRepository;
import az.coders.Design.homes.service.ListBlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListBlogServiceImpl implements ListBlogService {
    private final ListBlogRepository listBlogRepository;
    private final EnhancedObjectMapper enhancedObjectMapper;

    @Override
    public List<ListBloglDto> getAllBlogs() {
        return enhancedObjectMapper.convertList(
                listBlogRepository.findAllByOrderByUpdatedAtDescCreatedAtDesc(),
                ListBloglDto.class
        );
    }

    @Override
    public ListBloglDto getBlogById(Integer id) {
        return enhancedObjectMapper.convertValue(
                listBlogRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Service not found with id: " + id)),
                ListBloglDto.class
        );  }

    @Override
    public ListBloglDto saveBlog(ListBloglDto blog) {
        return enhancedObjectMapper.convertValue(listBlogRepository.save(enhancedObjectMapper.convertValue(blog, ListBlog.class)), ListBloglDto.class);
    }


    @Override
    public ListBloglDto updateBlog(Integer id, ListBloglDto blog) {
        ListBlog existingBlog = listBlogRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND));

        // Update fields
        existingBlog.setTitle(blog.getTitle());
        existingBlog.setUpdatedAt(blog.getUpdatedAt());
        existingBlog.setImage(blog.getImage());
        existingBlog.setContent(blog.getContent());
        // updatedAt will be updated automatically by @PreUpdate

        ListBlog updatedBlog = listBlogRepository.save(existingBlog);

        return enhancedObjectMapper.convertValue(updatedBlog, ListBloglDto.class);
    }

    @Override
    public void deleteBlog(Integer id) {
        if (!listBlogRepository.existsById(id)) {
            throw new NotFoundException(ErrorCode.NOT_FOUND);
        }
        listBlogRepository.deleteById(id);
    }

    @Override
    public List<ListBloglDto> getRecentBlogs() {
        Pageable topTwo = PageRequest.of(0, 2);
        List<ListBlog> recentBlogs = listBlogRepository.findTop2ByLatestActivity(topTwo);

        return recentBlogs.stream()
                .map(blog -> enhancedObjectMapper.convertValue(blog, ListBloglDto.class))
                .collect(Collectors.toList());
    }


}
