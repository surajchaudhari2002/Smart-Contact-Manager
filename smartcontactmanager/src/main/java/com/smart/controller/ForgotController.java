package com.smart.controller;

import com.smart.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Random;

public class ForgotController {
    Random random = new Random(1000);

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepository userRepsitory;

    @Autowired
    private BCryptPasswordEncoder bcrypt;


    //email id form open  handler
    @RequestMapping("/forgot")
    public String openEmailForm()
    {
        return "forgot_email_form";
    }

    @PostMapping("/send-otp")
    public String sendOTP(@RequestParam("email") String email, HttpSession session)
    {
        System.out.println("EMAIL "+email);

        //generating otp of 4 digit


        int otp = random.nextInt(999999);

        System.out.println("OTP "+otp);


        //write code for send otp to email...


        String subject="OTP From SCM";
        String message=""
                + "<div style='border:1px solid #e2e2e2; padding:20px'>"
                + "<h1>"
                + "OTP is "
                + "<b>"+otp
                + "</n>"
                + "</h1> "
                + "</div>";
        String to=email;

        boolean flag = this.emailService.sendEmail(subject, message, to);

        if(flag)
        {

            session.setAttribute("myotp", otp);
            session.setAttribute("email", email);
            return "verify_otp";

        }else
        {

            session.setAttribute("message", "Check your email id !!");

            return "forgot_email_form";
        }
}
