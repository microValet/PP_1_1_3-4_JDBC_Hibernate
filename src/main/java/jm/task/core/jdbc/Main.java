package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

import static jm.task.core.jdbc.util.Util.USER_NAME;
import static jm.task.core.jdbc.util.Util.statement;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // реализуйте алгоритм здесь
        UserDao userDao = new UserDaoJDBCImpl();

        userDao.createUsersTable();

        userDao.saveUser("Name1", "LastName1", (byte) 20);
        System.out.println("User с именем - " + userDao.getAllUsers().get(0).getName() + " добавлен в таблицу");
        userDao.saveUser("Name2", "LastName2", (byte) 25);
        System.out.println("User с именем - " + userDao.getAllUsers().get(1).getName() + " добавлен в таблицу");
        userDao.saveUser("Name3", "LastName3", (byte) 31);
        System.out.println("User с именем - " + userDao.getAllUsers().get(2).getName() + " добавлен в таблицу");
        userDao.saveUser("Name4", "LastName4", (byte) 38);
        System.out.println("User с именем - " + userDao.getAllUsers().get(3).getName() + " добавлен в таблицу");

        //userDao.removeUserById(1);
        System.out.println(userDao.getAllUsers());
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}
