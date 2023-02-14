package com.inflearn.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        // given
        Member member = new Member(1L, "first member", Grade.VIP);

        // when
        memberService.join(member);

        // then
        Assertions.assertThat(memberService.findMember(1L)).isEqualTo(member);
    }
}