package ktl.ack.api.AckMemberRegistrationApi.application.services;



import ktl.ack.api.AckMemberRegistrationApi.application.model.Member;

import java.util.List;

public interface MemberService {
    List<Member> getMembers();

    Member getMembersById(Long regNo);

    Member insert(Member member);

    void updateMember(Long regNo, Member member);

    void deleteMember(Long regNo);
}
