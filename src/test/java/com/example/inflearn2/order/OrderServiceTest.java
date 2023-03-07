package com.example.inflearn2.order;

import com.example.inflearn2.AppConfig;
import com.example.inflearn2.member.Grade;
import com.example.inflearn2.member.Member;
import com.example.inflearn2.member.MemberService;
import com.example.inflearn2.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberB", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemB", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
