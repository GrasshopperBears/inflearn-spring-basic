package com.inflearn.core.order;

import com.inflearn.core.member.Grade;
import com.inflearn.core.member.Member;
import com.inflearn.core.member.MemberService;
import com.inflearn.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member newMember = new Member(memberId, "first member", Grade.VIP);
        memberService.join(newMember);

        Order order = orderService.createOrder(memberId, "first item", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}