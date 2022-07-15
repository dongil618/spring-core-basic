package com.inflearn.springcorebasic;

import com.inflearn.springcorebasic.member.Grade;
import com.inflearn.springcorebasic.member.Member;
import com.inflearn.springcorebasic.member.MemberService;
import com.inflearn.springcorebasic.member.MemberServiceImpl;
import com.inflearn.springcorebasic.order.Order;
import com.inflearn.springcorebasic.order.OrderService;
import com.inflearn.springcorebasic.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(member.getId(), "ItemA", 10000);
        System.out.println("order : " + order);
        System.out.println("order calculate : " + order.calculatePrice());
    }
}
