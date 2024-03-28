package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository; // 생성자는 한번 만들어지면 바꿀 수 없다 - 불변. 필수 의존 관계를 사용함. 무조건 값이 있어야함.
    private final DiscountPolicy discountPolicy; //DIP만족 및 OCP 확장 열려있고 변경에는 닫아져있다.

    // 생성자가 딱 한개 있으면 Autowired를 생략해도 됨.
    // setter를 쓸 때 set- , 필드 값을 메서드를 통해서 하는데 Autowired를 사용 가능함. 빈을 등록하면 의존관계가 같이 일어남.

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) { //외부에서 객체를 선언해서 받아옴 (DI)
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
