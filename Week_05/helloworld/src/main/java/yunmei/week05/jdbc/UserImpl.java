package yunmei.week05.jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Class UserImpl
 * @Description UserImpl
 * @Author zeke
 * @Date 16/11/2020 9:59 下午
 * @Version 1.0.0
 **/
public class UserImpl implements IUserDao {

    private static String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf-8";
    private static String userName = "root";
    private static String password = "12345678";

    @Override
    public List<User> query() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> list = new ArrayList<>();
        String sql = "select id, name from user";
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            Class.forName("com.mysql.jdbc.Driver");
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                User user = new User(rs.getInt("id"),rs.getString("name"));
                list.add(user);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try {
                ps.close();
                rs.close();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public int add(User user) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public User queryById(int id) {
        return null;
    }

    static DataSource ds = null;

    static {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.jdbc.Driver");
        config.setJdbcUrl(url);
        config.setUsername(userName);
        config.setPassword(password);

        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        ds = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static void release(Connection conn, Statement st, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
