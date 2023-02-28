package ktl.ack.api.AckMemberRegistrationApi.application.repository;


import ktl.ack.api.AckMemberRegistrationApi.application.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}


