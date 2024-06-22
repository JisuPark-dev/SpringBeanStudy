package springbean.core.discount;

import springbean.core.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
