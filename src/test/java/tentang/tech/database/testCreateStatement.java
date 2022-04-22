package tentang.tech.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import org.junit.jupiter.api.Test;

/**
 * testCreateStatement
 */
public class testCreateStatement {

  @Test
  void testCreateStatement() throws SQLException {
    Connection connection = ConnectionUtil.getDataSource().getConnection();
    Statement statement = connection.createStatement();

    connection.close();
    statement.close();
  }

  @Test
  void testExecuteUpdate() throws SQLException {
    Connection connection = ConnectionUtil.getDataSource().getConnection();
    Statement statement = connection.createStatement();

    String sql = """
        INSERT INTO customers(id, name, email)
        VALUES("imam", "Imam", "imam@mail.com")
        """;

    int update = statement.executeUpdate(sql);
    System.out.println(update);
    connection.close();
    statement.close();
  }

  @Test
  void testExecuteDelete() throws SQLException {
    Connection connection = ConnectionUtil.getDataSource().getConnection();
    Statement statement = connection.createStatement();

    String sql = """
        DELETE FROM customers;
                """;

    int update = statement.executeUpdate(sql);
    System.out.println(update);
    connection.close();
    statement.close();
  }

  @Test
  void testExecuteQuery() throws SQLException {
    Connection connection = ConnectionUtil.getDataSource().getConnection();
    Statement statement = connection.createStatement();

    String sql = """
        SELECT * FROM customers;
                """;

    ResultSet resultSet = statement.executeQuery(sql);
    resultSet.close();
    connection.close();
    statement.close();
  }

}
