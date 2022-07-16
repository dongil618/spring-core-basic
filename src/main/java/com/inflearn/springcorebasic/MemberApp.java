package com.inflearn.springcorebasic;

import com.inflearn.springcorebasic.member.Grade;
import com.inflearn.springcorebasic.member.Member;
import com.inflearn.springcorebasic.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);  // 첫번째 파라미터 name은 AppConfig의 메소드를 가르쳐준다, 두번째 파라미터는 타입이다.

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println(member.toString());
        System.out.println("new Member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
