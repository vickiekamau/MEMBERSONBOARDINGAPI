package ktl.ack.api.AckMemberRegistrationApi.application.controller;


import ktl.ack.api.AckMemberRegistrationApi.application.model.Member;
import ktl.ack.api.AckMemberRegistrationApi.application.services.MemberService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/member")
public class MemberController {
    MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    //The function receives a GET request, processes it and gives back a list of Members as the response.
    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> members = memberService.getMembers();
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    //The function receives a GET request, processes it, and gives back a Member  as a response.
    @GetMapping({"/{regNo}"})
    public ResponseEntity<Member> getMember(@PathVariable Long regNo) {
        return new ResponseEntity<>(memberService.getMembersById(regNo), HttpStatus.OK);
    }

    //The function receives a POST request, processes it, creates a new Member and saves it to the database,
    // and returns a resource link to the created Member.
    @PostMapping
    public ResponseEntity<Member> saveMember(@RequestBody Member member) {
        Member member1 = memberService.insert(member);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("member", "/api/v1/member/" + member1.getRegNo().toString());
        return new ResponseEntity<>(member1, httpHeaders, HttpStatus.OK);
    }

    //The function receives a PUT request, updates the member with the specified regNo and returns the updated Members
    @PutMapping({"/{regNo}"})
    public ResponseEntity<Member> updateMember(@PathVariable("regNo") Long regNo, @RequestBody Member member) {
        memberService.updateMember(regNo, member);
        return new ResponseEntity<>(memberService.getMembersById(regNo), HttpStatus.OK);
    }

    //The function receives a DELETE request, deletes the Member with the specified RegNO.
    @DeleteMapping({"/{regNo}"})
    public ResponseEntity<Member> deleteMember(@PathVariable("regNo") Long regNo) {
        memberService.deleteMember(regNo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
