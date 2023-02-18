package com.inflearn.core.member;

import com.inflearn.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

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
