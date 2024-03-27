package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        //@Configuration을 빼는 이유는 수동으로 등록한 @Configuration와 충돌이 날 수 있기 때문(실무에서는 제외를 하지 않음)
) //스프링 빈을 스캔에서 쫙 끌어올리는 역할
public class AutoAppConfig {

}
