package com.example.inflearn2.order;

import com.example.inflearn2.discount.DiscountPolicy;
import com.example.inflearn2.discount.FixDiscountPolicy;
import com.example.inflearn2.discount.RateDiscountPolicy;
import com.example.inflearn2.member.Member;
import com.example.inflearn2.member.MemberRepository;
import com.example.inflearn2.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //    private final DiscountPolicy discountPolicy =  new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy =  new RateDiscountPolicy();


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
