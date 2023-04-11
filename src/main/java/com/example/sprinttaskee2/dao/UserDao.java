package com.example.sprinttaskee2.dao;

import com.example.sprinttaskee2.entity.User;
import com.example.sprinttaskee2.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserDao {

    private static final UserDao INSTANCE = new UserDao();
    private static final String FIND_BY_EMAIL_AND_PASS = """
                SELECT id,
                    email,
                    password,
                    full_name
                FROM users
                WHERE email = ?
                AND password = ?
            """;

    public Optional<User> findByPasswordAndEmail(String password, String email) {
        try (var connection = ConnectionManager.open();
             var preparedStatement = connection.prepareStatement(FIND_BY_EMAIL_AND_PASS)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = buildUser(resultSet);
            }
            return Optional.ofNullable(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static User buildUser(ResultSet resultSet) throws SQLException {
        return new User(resultSet.getLong("id"),
                resultSet.getString("email"),
                resultSet.getString("password"),
                resultSet.getString("full_name"));
    }


    private UserDao() {
    }

    public static UserDao getInstance() {
        return INSTANCE;
    }
}
