package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration           // 설정 정보 무조건 넣어라 설정 정보에는 !
public class AppConfig { // 나의 애플케이션을 설정 및 구성 (실제로 동작에 필요한 구현 객체를 만듬)
                         // 생성한 객체 인스턴스의 참조를 생성자를 통해서 주입해줌.
    // @Bean memberService -> new MemoryMemberServiceRepository
    // @Bean orderService -> new MemoryMemberServiceRepository
    // @Configuration을 붙이면 바이트코드를 조작하는 CGLIB 기술을 사용해서 보장하지만, 만약 @Bean만 적용하면
    // -> 순수한 Appconfig가 호출 되는 것을 볼 수 있음.

    @Bean // Bean 사용하면 스프링 컨테이너에 등록 됨
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public static MemberRepository memberRepository() { //나의 애플케이션에서 사용할 메소드 , 나중에 다른 구현체로 변경한다면 여기만 변경하면 됨.
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() { //나의 애플케이션에션에서 사용할 오더 서비스
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(
                memberRepository(),
                new RateDiscountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() { // 고정할인 금액 메소드
        // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
