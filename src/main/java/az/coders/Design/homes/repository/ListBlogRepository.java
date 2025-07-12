package az.coders.Design.homes.repository;

import az.coders.Design.homes.dto.ListBloglDto;
import az.coders.Design.homes.entity.blog.ListBlog;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ListBlogRepository extends JpaRepository<ListBlog,Integer> {
    @Query("SELECT b FROM ListBlog b ORDER BY " +
            "CASE WHEN b.updatedAt > b.createdAt THEN b.updatedAt ELSE b.createdAt END DESC")
    List<ListBlog> findTop2ByLatestActivity(Pageable pageable);

   List<ListBlog> findAllByOrderByUpdatedAtDescCreatedAtDesc();

}
