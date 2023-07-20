package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( //basepackage 지정 안하면 이 클래스의 package인 hello.core에서 뒤짐
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) //AppConfig 제외
)
public class AutoAppConfig {

}
