package com.inflearn.core;

import com.inflearn.core.discount.DiscountPolicy;
import com.inflearn.core.discount.FixDiscountPolicy;
import com.inflearn.core.member.MemberRepository;
import com.inflearn.core.member.MemberService;
import com.inflearn.core.member.MemberServiceImpl;
import com.inflearn.core.member.MemoryMemberRepository;
import com.inflearn.core.order.OrderService;
import com.inflearn.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// app 실제 동장에 필요한 구현 객체를 생성, 주입
@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
