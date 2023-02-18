package com.inflearn.core;

import com.inflearn.core.discount.FixDiscountPolicy;
import com.inflearn.core.member.MemberService;
import com.inflearn.core.member.MemberServiceImpl;
import com.inflearn.core.member.MemoryMemberRepository;
import com.inflearn.core.order.OrderService;
import com.inflearn.core.order.OrderServiceImpl;

// app 실제 동장에 필요한 구현 객체를 생성, 주입
public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
