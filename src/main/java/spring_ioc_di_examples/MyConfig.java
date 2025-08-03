package spring_ioc_di_examples;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("spring_ioc_di_examples")
@PropertySource("myApp.properties")
public class MyConfig {
}

