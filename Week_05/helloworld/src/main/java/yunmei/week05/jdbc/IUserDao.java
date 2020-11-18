package yunmei.week05.jdbc;

import java.util.List;

/**
 * @Class IUserDao
 * @Description IUserDao
 * @Author zeke
 * @Date 16/11/2020 9:58 下午
 * @Version 1.0.0
 **/
public interface IUserDao {

    List<User> query();

    int add(User user);

    int delete(int id);

    int update(User user);

    User queryById(int id);
}
