package com.inflearn.core.discount;

import com.inflearn.core.member.Grade;
import com.inflearn.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private int DISCOUNT_PERCENT = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * DISCOUNT_PERCENT / 100;
        }
        return 0;
    }
}
