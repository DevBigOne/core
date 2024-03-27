package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Autowired // 자동으로 의존관계 주입 ac.getBean(MemberRepositroy.class)
    public MemberServiceImpl(MemberRepository MemberRepository) {
        this.memberRepository = MemberRepository;
    }

   @Override // 추상한 된 메소드를 구현하기 위해 오버라이드를 사용해야 스프링에서 알 수 있다.
    public void join(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
