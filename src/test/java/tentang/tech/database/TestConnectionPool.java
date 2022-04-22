package tentang.tech.database;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestConnectionPool {
  @Test
  void testHikariCp() {
    HikariConfig config = new HikariConfig();
    config.setDriverClassName("com.mysql.cj.jdbc.Driver");
    config.setJdbcUrl("jdbc:mysql://localhost:3306/belajar_java_database");
    config.setUsername("root");
    config.setPassword("");

    config.setMaximumPoolSize(10);
    config.setMinimumIdle(5);
    config.setIdleTimeout(60_000);
    config.setMaxLifetime(10 * 60_000);

    try {
      HikariDataSource dataSource = new HikariDataSource(config);
      Connection connection = dataSource.getConnection();

      connection.close();
      dataSource.close();
    } catch (SQLException sqlException) {
      // TODO: handle exception
      Assertions.fail(sqlException);
    }
  }

  @Test
  void testUtil() throws SQLException {
    Connection connection = ConnectionUtil.getDataSource().getConnection();
  }
}
