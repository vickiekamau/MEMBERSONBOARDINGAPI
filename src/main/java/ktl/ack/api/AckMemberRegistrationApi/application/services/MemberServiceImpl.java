package ktl.ack.api.AckMemberRegistrationApi.application.services;


import ktl.ack.api.AckMemberRegistrationApi.application.model.Member;
import ktl.ack.api.AckMemberRegistrationApi.application.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    @Override
    public List<Member> getMembers() {
        List<Member> members = new ArrayList<>();
        memberRepository.findAll().forEach(members::add);
        return members;
    }

    @Override
    public Member getMembersById(Long regNo) {
        return memberRepository.findById(regNo).get();
    }

    @Override
    public Member insert(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public void updateMember(Long regNo, Member member) {

        Member memberDB = memberRepository.findById(regNo).get();
        System.out.println(memberDB.toString());
        memberDB.setFname(member.getFname());
        memberDB.setSurname(member.getSurname());
        memberDB.setOtherNames(member.getOtherNames());
        memberDB.setGender(member.getGender());
        memberDB.setMaritalStatus(member.getMaritalStatus());
        memberDB.setDob(member.getDob());
        memberDB.setConfirmed(member.getConfirmed());
        memberDB.setCellGroup(member.getCellGroup());
        memberDB.setService(member.getService());
        memberDB.setProfession(member.getProfession());
        memberDB.setOccupation(member.getOccupation());
        memberDB.setPhoneNo(member.getPhoneNo());
        memberRepository.save(memberDB);

    }

    @Override
    public void deleteMember(Long regNo) {
           memberRepository.deleteById(regNo);
    }
}
