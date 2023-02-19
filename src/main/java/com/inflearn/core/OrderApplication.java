package com.inflearn.core;

import com.inflearn.core.member.Grade;
import com.inflearn.core.member.Member;
import com.inflearn.core.member.MemberService;
import com.inflearn.core.order.Order;
import com.inflearn.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Member newMember = new Member(1L, "new_member", Grade.VIP);
        memberService.join(newMember);

        Order order = orderService.createOrder(1L, "item_A", 20000);
        System.out.println("Order: " + order);
    }
}
