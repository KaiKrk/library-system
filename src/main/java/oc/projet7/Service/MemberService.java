package oc.projet7.Service;

import oc.projet7.Entity.Member;
import oc.projet7.Repository.MemberRepository;
import oc.projet7.bean.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member save(Member theMember) {
       return memberRepository.save(theMember);
    }

    public List<MemberDto> findAll() {
        List<Member> memberList = memberRepository.findAll();
        List<MemberDto> memberDtoList = MemberListToDto(memberList);
        return memberDtoList;

    }

    public MemberDto getMemberDto(String email){
        Member member = memberRepository.findMemberByEmail(email);
        return new MemberDto(member);
    }

    public Member getMember(String email){
        Member member = memberRepository.findMemberByEmail(email);
        return member;
    }

    public Member getMemberById(int id){
        Member member = memberRepository.findById(id);
        return member;
    }

    public List<MemberDto> MemberListToDto(List<Member> memberList){
        List<MemberDto> memberDtoList = new ArrayList<>();
        for (Member member: memberList) {
            memberDtoList.add(new MemberDto(member));
        }
        return memberDtoList;
    }
}
