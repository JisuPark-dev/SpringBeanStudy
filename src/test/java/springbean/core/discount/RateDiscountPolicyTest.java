package springbean.core.discount;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import springbean.core.member.Grade;
import springbean.core.member.Member;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @DisplayName("vip는 10% 할인이 적용되어야 한다.")
    @Test
    void vip_ok(){
        //given
        Member member = new Member(1L, "memberVip", Grade.VIP);
        //when
        int discount = rateDiscountPolicy.discount(member, 20000);

        //then
        assertThat(discount).isEqualTo(2000);
    }

    @DisplayName("vip가 아니면 할인이 되지 않는다.")
    @Test
    void dontDiscountIfNotVip(){
        //given
        Member member = new Member(1L, "memberVip", Grade.BASIC);
        //when
        int discount = rateDiscountPolicy.discount(member, 20000);

        //then
        assertThat(discount).isEqualTo(0);

    }

}