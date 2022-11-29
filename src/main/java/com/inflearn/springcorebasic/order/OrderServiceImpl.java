package com.inflearn.springcorebasic.order;

import com.inflearn.springcorebasic.discount.DiscountPolicy;
import com.inflearn.springcorebasic.discount.FixDiscountPolicy;
import com.inflearn.springcorebasic.discount.RateDiscountPolicy;
import com.inflearn.springcorebasic.member.Member;
import com.inflearn.springcorebasic.member.MemberRepository;
import com.inflearn.springcorebasic.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
//   private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();    해당 코드는 DIP 위반  => 생성자 주입으로 해결
    private final DiscountPolicy discountPolicy;

    @Autowired // 지금처럼 생성자가 1개면 생략가능
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
