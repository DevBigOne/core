package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

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
