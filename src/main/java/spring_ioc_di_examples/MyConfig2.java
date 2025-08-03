package spring_ioc_di_examples;

import org.springframework.context.annotation.*;

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
