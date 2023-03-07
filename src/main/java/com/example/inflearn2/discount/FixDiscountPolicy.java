package com.example.inflearn2.discount;

import com.example.inflearn2.member.Grade;
import com.example.inflearn2.member.Member;

public class FixDiscountPolicy implements  DiscountPolicy{

    private int discountFixAmout = 1000; //

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return discountFixAmout;
        }else {
            return  0;
        }
    }
}
