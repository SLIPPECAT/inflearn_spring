package com.example.inflearn2;

import com.example.inflearn2.discount.DiscountPolicy;
import com.example.inflearn2.discount.FixDiscountPolicy;
import com.example.inflearn2.discount.RateDiscountPolicy;
import com.example.inflearn2.member.*;
import com.example.inflearn2.order.OrderService;
import com.example.inflearn2.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    // @Bean memberService -> new MemoryMemberRepository()
    // @Bean orderService -> new MemoryMemberRepository()
    // 2번 호출되었다.


    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        // 구현체가 생성된다.
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        // DB를 바꾸고 싶은 경우 나중에 여기만 바꾸면 된다.
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        // 할인 정책을 바꾸고 싶은 경우 나중에 여기만 바꾸면 된다.
        return new RateDiscountPolicy();
    }
}
