package az.coders.Design.homes.repository.footer;

import az.coders.Design.homes.entity.footer.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactInfoRepository extends JpaRepository<ContactInfo, Integer> {
}
