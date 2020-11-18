package yunmei.week05.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Class SpringBeanExample
 * @Description SpringBeanExample
 * @Author zeke
 * @Date 16/11/2020 9:46 下午
 * @Version 1.0.0
 **/
@Component
public class SpringBeanExample {

    @Autowired()
    private UserDao userDao;

    public void addUser(int userId) {
        userDao.save(userId);
    }
}
