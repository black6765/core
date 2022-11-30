package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        // primitive type인 long으로 해도 되지만, 그러면 null이 들어갈 수 없음
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        // org.assertj.core.api를 사용해야 .을 이용한 메소드 체인을 사용 가능
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}