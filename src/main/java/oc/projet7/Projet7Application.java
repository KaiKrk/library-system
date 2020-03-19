package oc.projet7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@SpringBootApplication
@EnableScheduling
public class Projet7Application {
    public static void main(String[] args) throws MessagingException {

        SpringApplication.run(Projet7Application.class, args);

    }
}
