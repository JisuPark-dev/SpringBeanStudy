package springbean.core.order;

import springbean.core.discount.DiscountPolicy;
import springbean.core.discount.FixDiscountPolicy;
import springbean.core.member.Member;
import springbean.core.member.MemberRepository;
import springbean.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice) ;
    }
}
