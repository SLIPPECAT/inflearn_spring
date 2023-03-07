package com.example.inflearn2.discount;

import com.example.inflearn2.member.Member;

public interface DiscountPolicy {
    /**
     *
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);

}
