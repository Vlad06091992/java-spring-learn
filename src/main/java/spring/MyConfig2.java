package spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MyConfig2 {

    @Bean
    //по дефолту как обычно - singleton
//    @Scope("singleton")
    @Scope("prototype")
    public Pet mouseBean() {
        return new Mouse();
    }

    @Bean
    public People peopleBean() {
        return new People(mouseBean());
    }
}
