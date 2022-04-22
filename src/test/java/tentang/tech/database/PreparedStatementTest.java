package tentang.tech.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementTest {
  @Test
  void testExecuteQuery() throws SQLException {
    Connection connection = ConnectionUtil.getDataSource().getConnection();
    String username = "admin";
    String sql = " SELECT * FROM admin WHERE username = ? AND password = ? ";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);


    ResultSet resultSet = preparedStatement.executeQuery(sql);

    while (resultSet.next()) {
      String id = resultSet.getString("id");
      String name = resultSet.getString("name");
      String email = resultSet.getString("email");

      System.out.println(
          String.join(", ", id, name, email)
      );
    }
    resultSet.close();
    connection.close();
    statement.close();
  }
}
