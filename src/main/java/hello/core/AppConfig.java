package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig { // 나의 애플케이션을 설정 및 구성 (실제로 동작에 필요한 구현 객체를 만듬)
                         // 생성한 객체 인스턴스의 참조를 생성자를 통해서 주입해줌.
    public MemberService memberService() {
        return new MemberServiceImpl(MemberRepository());
    }

    private static MemberRepository MemberRepository() { //나의 애플케이션에서 사용할 메소드 , 나중에 다른 구현체로 변경한다면 여기만 변경하면 됨.
        return new MemoryMemberRepository();
    }

    public OrderService orderService() { //나의 애플케이션에션에서 사용할 오더 서비스
        return new OrderServiceImpl(
                MemberRepository(),
                new FixDiscountPolicy());
    }
    public DiscountPolicy discountPolicy() { // 고정할인 금액 메소드
        return new FixDiscountPolicy();
    }
}
