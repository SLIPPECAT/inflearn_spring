package com.example.inflearn2;

import com.example.inflearn2.member.Grade;
import com.example.inflearn2.member.Member;
import com.example.inflearn2.member.MemberService;
import com.example.inflearn2.member.MemberServiceImpl;
import com.example.inflearn2.order.Order;
import com.example.inflearn2.order.OrderService;
import com.example.inflearn2.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService= appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);


        Long memberId = 1L;
        Member member = new Member(memberId, "RYU", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA", 10000);

        System.out.println("order = " + order.toString());

    }
}
