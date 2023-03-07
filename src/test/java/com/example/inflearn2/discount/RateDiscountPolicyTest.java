package com.example.inflearn2.discount;

import com.example.inflearn2.member.Grade;
import com.example.inflearn2.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// static에 추가해줌
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest
{
    RateDiscountPolicy dicountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o(){
        //given
        Member member = new Member(1L, "RYU", Grade.VIP);
        //when
        int discount = dicountPolicy.discount(member, 10000);
        //then
        System.out.println(discount);
        //검증
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x(){
        // given
        Member member = new Member(2L, "JUN", Grade.BASIC);
        // when
        int discount = dicountPolicy.discount(member, 20000);
        // then
        assertThat(discount).isEqualTo(0);
    }
}