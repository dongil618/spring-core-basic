package com.inflearn.springcorebasic.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();

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
}
