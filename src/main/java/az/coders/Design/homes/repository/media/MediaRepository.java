package az.coders.Design.homes.repository.media;

import az.coders.Design.homes.entity.media.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaRepository extends JpaRepository<Media,Integer> {
}
