package ktl.ack.api.AckMemberRegistrationApi.application.repository;

import ktl.ack.api.AckMemberRegistrationApi.application.model.Member;
import ktl.ack.api.AckMemberRegistrationApi.application.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    }

