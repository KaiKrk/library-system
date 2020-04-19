package oc.projet7.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MailDetails {

//    @Autowired
//    MemberService memberService;

    private  String myAccountEmail = "annalibraryoc@gmail.com";

    private  String password = "12345LibraryOC";

    private String subject = "Retour de livre emprunté";

    private String message = "Bonjour vous avez oublier de rendre votre livre veuillez nous le faire parvenir.\n Livre : ";

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
