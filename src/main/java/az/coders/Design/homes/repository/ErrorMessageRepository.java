package az.coders.Design.homes.repository;

import az.coders.Design.homes.entity.ErrorMessage;
import az.coders.Design.homes.enums.ErrorCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ErrorMessageRepository extends JpaRepository<ErrorMessage,Integer> {

    Optional<ErrorMessage> findByErrorCode(ErrorCode errorCode);
}
