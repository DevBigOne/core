package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // basePackages = "hello.core.member", //해당 패키지부터 찾음 member만 찾는다는 것, (어디서 찾을 수 있도록 지정하는 것)
        // basePackageClasses = AutoAppConfig, //core 패키지 부터 찾는 것
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        //@Configuration을 빼는 이유는 수동으로 등록한 @Configuration와 충돌이 날 수 있기 때문(실무에서는 제외를 하지 않음)
) //스프링 빈을 스캔에서 쫙 끌어올리는 역할
public class AutoAppConfig {
/*
    @Bean( name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
*/
}
// TIP : 개인적으로 즐겨 사용하는 방법은 패키지를 지정하지 않고, 설정 정보 클래스이 위치를 프로젝트 최상단에 두는 것
