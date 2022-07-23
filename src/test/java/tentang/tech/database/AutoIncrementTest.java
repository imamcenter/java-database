package tentang.tech.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AutoIncrementTest {

  @Test
  void testAutoIncrement() throws SQLException {
    Connection connection = ConnectionUtil.getDataSource().getConnection();
    String sql = "INSERT INTO comments(email, comment) VALUES(?,?)";
    PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

    preparedStatement.setString(1, "shaqil@test.com");
    preparedStatement.setString(2, "hallo");


    preparedStatement.executeUpdate();

    ResultSet resultSet = preparedStatement.getGeneratedKeys();

    if (resultSet.next()){
      System.out.println("id comment" +
          resultSet.getString(1));
    }

    preparedStatement.close();
    connection.close();


  }
}
