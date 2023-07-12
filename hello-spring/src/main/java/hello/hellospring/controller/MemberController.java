package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    //@Autowired private MemberService memberService; //필드 주입
    private MemberService memberService;

    /*
    @Autowired //setter 주입 : public 해야하는 문제
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }
    */
    @Autowired //매개변수로 받은 memberService를 spring이 spring container에 있는 memberService를 가져다 연결시켜줌
    //service와 controller 연결시켜줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}