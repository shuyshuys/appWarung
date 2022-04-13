package com.shuyshuys.appwarung;

import java.sql.*;

// import javax.sql.DataSource;
// import org.springframework.context.ApplicationContext;
// import org.springframework.context.support.ClassPathXmlApplicationContext;
// import org.springframework.jdbc.core.JdbcTemplate;

public class PostgresTest {
    public static void main(String[] args) {
        // ApplicationContext context = new
        // ClassPathXmlApplicationContext("applicationContext.xml");
        // DataSource dataSource = (DataSource) context.getBean("dataSource");
        // JdbcTemplate jt = new JdbcTemplate(dataSource);

        // js.execute("create table login (Nama varchar, Password varchar)");
        // js.execute("insert into login (Nama, Password) values ('admin','admin'");

        try {
            String sql = "SELECT * FROM login WHERE Nama = ? AND Password = ?";

            PreparedStatement ps = Post.getCon().prepareStatement(sql);
            ps.setString(1, "admin");
            ps.setString(2, "admin");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Login Berhasil");
            } else {
                System.out.println("Login Gagal");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
