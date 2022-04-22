package tentang.tech.database;

import com.mysql.cj.jdbc.Driver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

  @BeforeAll
  static void beforeAll() {
    try {

      Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();
      DriverManager.registerDriver(mysqlDriver);
    } catch (SQLException exception) {
      Assertions.fail(exception);
    }
  }

  @Test
  void connectionTest() {
    String username = "root";
    String password = "";
    String jdbcUrl = "jdbc:mysql://localhost:3306/belajar_java_database";
    try {
      Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
      System.out.println("Success connect to database");
    } catch (SQLException e) {
      Assertions.fail(e);
    }
  }

  @Test
  void testConnectionClose() {
    String username = "root";
    String password = "";
    String jdbcUrl = "jdbc:mysql://localhost:3306/belajar_java_database";
    try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);) {

      System.out.println("Success connect to database");
    } catch (SQLException e) {
      Assertions.fail(e);
    }
  }

}
