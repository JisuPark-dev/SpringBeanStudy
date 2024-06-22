package springbean.core;

import springbean.core.discount.FixDiscountPolicy;
import springbean.core.member.MemberService;
import springbean.core.member.MemberServiceImpl;
import springbean.core.member.MemoryMemberRepository;
import springbean.core.order.OrderService;
import springbean.core.order.OrderServiceImpl;

public class AppConfig {
    // memberService 메소드는 MemberService 객체를 생성하여 반환합니다.
    public MemberService memberService() {
        return new MemberServiceImpl(getMemberRepository());
    }

    // orderService 메소드는 OrderService 객체를 생성하여 반환합니다.
    public OrderService orderService() {
        return new OrderServiceImpl(getMemberRepository(), getDiscountPolicy());
    }

    private MemoryMemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    private FixDiscountPolicy getDiscountPolicy() {
        return new FixDiscountPolicy();
    }
}
