package com.inflearn.springcorebasic;

import com.inflearn.springcorebasic.discount.DiscountPolicy;
import com.inflearn.springcorebasic.discount.RateDiscountPolicy;
import com.inflearn.springcorebasic.member.MemberRepository;
import com.inflearn.springcorebasic.member.MemberService;
import com.inflearn.springcorebasic.member.MemberServiceImpl;
import com.inflearn.springcorebasic.member.MemoryMemberRepository;
import com.inflearn.springcorebasic.order.OrderService;
import com.inflearn.springcorebasic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
