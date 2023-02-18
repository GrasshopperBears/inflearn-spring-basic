package com.inflearn.core.discount;

import com.inflearn.core.member.Grade;
import com.inflearn.core.member.Member;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    void discount_should_apply_to_vip_member() {
        Member member = new Member(1L, "VIP member", Grade.VIP);

        int discount = rateDiscountPolicy.discount(member, 10000);

        assertThat(discount).isEqualTo(1000);
    }

    @Test
    void discount_should_not_apply_to_non_vip_member() {
        Member member = new Member(1L, "VIP member", Grade.BASIC);

        int discount = rateDiscountPolicy.discount(member, 10000);

        assertThat(discount).isEqualTo(0);
    }
}