package yunmei.week05.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

/**
 * @Class SpringBeanExample2
 * @Description SpringBeanExample2
 * @Author zeke
 * @Date 16/11/2020 9:50 下午
 * @Version 1.0.0
 **/
@Configuration
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml","classpath:scan.xml"})
public class SpringBeanExample2 {

    @Bean(name="userDao2")
    public UserDao userDao(){
        return new UserDao();
    }
}
