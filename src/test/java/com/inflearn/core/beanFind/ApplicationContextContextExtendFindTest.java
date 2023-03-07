package com.inflearn.core.beanFind;

import com.inflearn.core.discount.DiscountPolicy;
import com.inflearn.core.discount.FixDiscountPolicy;
import com.inflearn.core.discount.RateDiscountPolicy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextContextExtendFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ExtendFindTestConfig.class);

    @Test
    void findBeanByParentTypeDuplicate() {
        assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(DiscountPolicy.class));
    }

    @Test
    void findBeanByParentTypeWithBeanName() {
        DiscountPolicy discountPolicy = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);
        assertThat(discountPolicy).isInstanceOf(DiscountPolicy.class);
    }

    // WARN: Not recommended
    @Test
    void findBeanBySubType() {
        RateDiscountPolicy rateDiscountPolicy = ac.getBean(RateDiscountPolicy.class);
        assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    void findAllBeanByParentType() {
        Map<String, DiscountPolicy> discountPolicies = ac.getBeansOfType(DiscountPolicy.class);

        for (Map.Entry<String, DiscountPolicy> stringDiscountPolicyEntry : discountPolicies.entrySet()) {
            String key = stringDiscountPolicyEntry.getKey();
            DiscountPolicy value = stringDiscountPolicyEntry.getValue();

            System.out.println("key = " + key + "; value = " + value);
        }

        assertThat(discountPolicies.size()).isEqualTo(2);
    }

    @Configuration
    static class ExtendFindTestConfig {
        @Bean
        public DiscountPolicy rateDiscountPolicy() {
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fixDiscountPolicy() {
            return new FixDiscountPolicy();
        }
    }
}
