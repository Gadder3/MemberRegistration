package com.example.member.contoller;

import com.example.member.entity.Member;
import com.example.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")
    public String showRegistrationPage() {
        return "registration";
    }

    @PostMapping("/register")
    public String registerMember(@RequestParam String name, @RequestParam String email) {
        Member existingMember = memberService.findByEmail(email);
        if (existingMember != null) {
            return "existingUser";
        } else {
            Member member = new Member();
            member.setName(name);
            member.setEmail(email);
            memberService.saveMember(member);
            return "registrationSuccess";
        }
    }

    @GetMapping("/members")
    public String showAllMembers(Model model) {
        Iterable<Member> members = memberService.getAllMembers();
        model.addAttribute("members", members);
        return "members";
    }
}
