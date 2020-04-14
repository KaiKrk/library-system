package oc.projet7.Controller;

import oc.projet7.Entity.Member;
import oc.projet7.Service.MemberService;
import oc.projet7.bean.MemberDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class MemberController {

    Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private MemberService memberService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/saveMember")
    public ResponseEntity<MemberDto> save(@RequestBody Member member) {
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        member.setAdmin(false);
        MemberDto memberDto = new MemberDto(memberService.save(member));
        logger.info("new Member Added " + member.getName());
        return new ResponseEntity<>(memberDto, HttpStatus.CREATED);
    }

    @GetMapping("/members")
    public ResponseEntity<List<MemberDto> >listContact() {
        List<MemberDto> members = memberService.findAll();
        System.out.println(members);
        return new ResponseEntity<>(members,HttpStatus.OK);
    }
}
