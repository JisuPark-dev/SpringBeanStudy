package springbean.core.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import springbean.core.member.Grade;
import springbean.core.member.Member;
import springbean.core.member.MemberService;
import springbean.core.member.MemberServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @DisplayName("주문을 생성한다.")
    @Test
    void createOrder(){
        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        //when
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        //then
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}