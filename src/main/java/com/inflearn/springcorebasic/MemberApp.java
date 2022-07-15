package com.inflearn.springcorebasic;

import com.inflearn.springcorebasic.member.Grade;
import com.inflearn.springcorebasic.member.Member;
import com.inflearn.springcorebasic.member.MemberService;
import com.inflearn.springcorebasic.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println(member.toString());
        System.out.println("new Member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
