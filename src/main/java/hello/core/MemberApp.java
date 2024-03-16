package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        //  AppConfig appConfig = new AppConfig();
        //  MemberService memberService = appConfig.memberService();
        //  MemberService memberService = new MemberServiceImpl();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); // Appconfig에 있는 Bean을 컨테이터에 넣음
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "MemberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("findMember = " + findMember.getName());
        System.out.println("New Member = " + member.getName());

    }
}
