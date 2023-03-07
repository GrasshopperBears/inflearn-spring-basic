package com.inflearn.core.beanFind;

import com.inflearn.core.member.MemberRepository;
import com.inflearn.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextSameBeanFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    void findBeanByTypeDuplicate() {
        assertThrows(NoUniqueBeanDefinitionException.class, () -> {
            MemberRepository memberRepository = ac.getBean(MemberRepository.class);
        });
    }

    @Test
    void findBeanByName() {
        MemberRepository memberRepository = ac.getBean("memberRepository1", MemberRepository.class);
        assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }

    @Test
    void findAllBeansByType() {
        Map<String, MemberRepository> memberRepositories = ac.getBeansOfType(MemberRepository.class);

        for (Map.Entry<String, MemberRepository> stringMemberRepositoryEntry : memberRepositories.entrySet()) {
            String key = stringMemberRepositoryEntry.getKey();
            MemberRepository value = stringMemberRepositoryEntry.getValue();

            System.out.printf("key = %s; value = %s\n", key, value);
        }

        assertThat(memberRepositories.size()).isEqualTo(2);
    }

    @Configuration
    static class SameBeanConfig {
        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }
}
