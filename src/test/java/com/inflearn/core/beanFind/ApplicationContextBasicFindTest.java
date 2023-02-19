package com.inflearn.core.beanFind;

import com.inflearn.core.AppConfig;
import com.inflearn.core.member.MemberService;
import com.inflearn.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext appCtx = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    void find_bean_by_name() {
        MemberService memberService = appCtx.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    void find_bean_by_type() {
        MemberService memberService = appCtx.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    // 비추. 구현에 의존하고 있기 때문
    @Test
    void find_bean_by_implementation() {
        MemberService memberService = appCtx.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    void should_throw_when_bean_not_exist() {
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> appCtx.getBean("abcd", MemberService.class));
    }
}
