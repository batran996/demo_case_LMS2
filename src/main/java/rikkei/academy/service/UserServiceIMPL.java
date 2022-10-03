package rikkei.academy.service;

import rikkei.academy.config.ConnectSQL;
import rikkei.academy.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserServiceIMPL implements IUserService {
    private static Connection connection = ConnectSQL.getConnection();
    private static final String CHECK_USER = "select * from databaseUSER where username = ? and password =?";
    private static final String ADD_USER = "insert into databaseUSER (username,password,role) values (?,?,'user')";


    @Override
    public User findByUserNameAndPass(String userName, String password) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CHECK_USER);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                int id = resultSet.getInt("id");
//                String name = resultSet.getString("userName");
//                String password = resultSet.getString("password");
                String role = resultSet.getString("role");
                return new User(id, userName, password, role);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public void addUser(String userName, String password) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
