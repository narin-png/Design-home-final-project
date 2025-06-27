package az.coders.Design.homes.repository.footer;

import az.coders.Design.homes.entity.footer.OfficeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeInfoRepository extends JpaRepository<OfficeInfo,Integer> {
}
