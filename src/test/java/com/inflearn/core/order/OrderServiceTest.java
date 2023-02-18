package com.inflearn.core.order;

import com.inflearn.core.AppConfig;
import com.inflearn.core.member.Grade;
import com.inflearn.core.member.Member;
import com.inflearn.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member newMember = new Member(memberId, "first member", Grade.VIP);
        memberService.join(newMember);

        Order order = orderService.createOrder(memberId, "first item", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}