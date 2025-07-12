package az.coders.Design.homes.repository;

import az.coders.Design.homes.entity.ListServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListServiceRepository extends JpaRepository<ListServiceEntity, Integer> {
}
