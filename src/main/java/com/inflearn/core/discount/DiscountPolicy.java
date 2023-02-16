package com.inflearn.core.discount;

import com.inflearn.core.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
