package springbean.core;

import springbean.core.member.Grade;
import springbean.core.member.Member;
import springbean.core.member.MemberService;
import springbean.core.member.MemberServiceImpl;
import springbean.core.order.Order;
import springbean.core.order.OrderService;
import springbean.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService  orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }
}
