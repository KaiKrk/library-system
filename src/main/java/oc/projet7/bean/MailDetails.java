package oc.projet7.bean;

import oc.projet7.Entity.Book;
import oc.projet7.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MailDetails {

    @Autowired
    MemberService memberService;

    @Value("${account}")
    private  String myAccountEmail;

    @Value("${password}")
    private  String password;

    private String subject = "Retour de livre emprunté";

    private String message = "Bonjour vous avez oublier de rendre votre livre veuillez nous le faire parvenir";

    public String getSubject() {
        return subject;
    }


    public String getMessage() {
        return message;
    }


    public String getMyAccountEmail() {
        return myAccountEmail;
    }

    public String getPassword() {
        return password;
    }
}
