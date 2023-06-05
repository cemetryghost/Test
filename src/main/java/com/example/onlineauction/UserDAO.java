package com.example.onlineauction;

import com.example.onlineauction.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private Connection connection;
    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public UserDAO() {
    }

    public void saveUser(User user) throws SQLException {
        String query = "INSERT INTO users (name, surname, login, password, birth_date, role, status) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getLogin());
            statement.setString(4, user.getPassword());
            statement.setDate(5, java.sql.Date.valueOf(user.getBirth_date()));
            statement.setString(6, user.getRole().toString());
            statement.setString(7, user.getStatus().toString());

            // Проверяем, существует ли пользователь с таким логином
            if (isUserExist(user.getLogin())) {
                throw new IllegalArgumentException("Пользователь с таким логином уже существует");
            }

            statement.executeUpdate();
        }
    }

    public boolean isUserExist(String login) throws SQLException {
        String query = "SELECT COUNT(*) FROM users WHERE login = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, login);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        }
        return false;
    }


    public User getUserByUsernameAndPassword(String username, String password) throws SQLException {
        String query = "SELECT * FROM users WHERE login = ? AND password = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return createUserFromResultSet(resultSet);
                }
            }
        }
        return null;
    }

    public List<User> getAllUsers() throws SQLException {
        String query = "SELECT * FROM users";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                User user = createUserFromResultSet(resultSet);
                users.add(user);
            }
            return users;
        }
    }

    public User getById(int userId) throws SQLException {
        String query = "SELECT * FROM users WHERE idusers = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return createUserFromResultSet(resultSet);
                }
            }
        }
        return null;
    }

    public void blockUser(int userId) throws SQLException {
        String query = "UPDATE users SET status = 'block' WHERE idusers = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            statement.executeUpdate();
        }
    }

    public void unblockUser(int userId) throws SQLException {
        String query = "UPDATE users SET status = 'active' WHERE idusers = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            statement.executeUpdate();
        }
    }

    public void deleteUser(int userId) throws SQLException {
        String query = "DELETE FROM users WHERE idusers = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            statement.executeUpdate();
        }
    }

    private User createUserFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("idusers");
        String name = resultSet.getString("name");
        String surname = resultSet.getString("surname");
        String login = resultSet.getString("login");
        String password = resultSet.getString("password");
        LocalDate birthDate = resultSet.getDate("birth_date").toLocalDate();
        User.Role role = User.Role.valueOf(resultSet.getString("role"));
        User.Status status = User.Status.valueOf(resultSet.getString("status"));
        User user = new User(name, surname, login, password, birthDate, role, status);
        user.setId(id);
        return user;
    }

    public User.Role getUserRole(String username, String password) throws SQLException {
        String query = "SELECT role FROM users WHERE login = ? AND password = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String roleString = resultSet.getString("role");
                    return User.Role.valueOf(roleString.toUpperCase());
                }
            }
        }
        return null;
    }9
}
