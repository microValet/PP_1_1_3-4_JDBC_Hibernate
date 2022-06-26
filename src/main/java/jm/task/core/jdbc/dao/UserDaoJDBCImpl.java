package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.statement;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        statement.executeUpdate("CREATE TABLE users (" +
                "id int auto_increment primary key," +
                "name varchar(30) not null," +
                "lastname varchar(30) not null," +
                "age int)");
    }

    public void dropUsersTable() throws SQLException {
        statement.executeUpdate("DROP TABLE IF EXISTS users");
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        statement.executeUpdate("INSERT INTO users (name, lastname, age) value ('" + name + "', '" + lastName + "', " + age + " )");
    }

    public void removeUserById(long id) throws SQLException {
        statement.executeUpdate("DELETE FROM users WHERE id = '" + id + "'");
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> userList = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

        while(resultSet.next()) {
            User user = new User(resultSet.getString(2), resultSet.getString(3), resultSet.getByte(4));
            user.setId(resultSet.getLong(1));
            userList.add(user);
        }
        return userList;
    }

    public void cleanUsersTable() throws SQLException {
        statement.executeUpdate("DELETE FROM users;");
    }
}
