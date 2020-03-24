package oc.projet7.Service;

import oc.projet7.Entity.Member;
import oc.projet7.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public void save(Member theMember) {
        memberRepository.save(theMember);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Optional<Member> findMemberByEmail(String email){
        return memberRepository.findByEmail(email);
    }
}
