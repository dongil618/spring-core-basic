package com.inflearn.springcorebasic.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        System.out.println("MemberServiceImpl의 save 메소드 실행");
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        System.out.println("MemberServiceImpl의 findMember 메소드 실행");
        return memberRepository.findById(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
