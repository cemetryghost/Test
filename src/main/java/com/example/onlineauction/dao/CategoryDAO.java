package com.example.onlineauction.dao;

import com.example.onlineauction.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    private final Connection connection;

    public CategoryDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(Category category) throws SQLException {
        String query = "INSERT INTO category (name_category) VALUES (?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, category.getName());

            statement.executeUpdate();
        }
    }

    public void update(Category category) throws SQLException {
        String query = "UPDATE category SET name_category = ? WHERE idcategory = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, category.getName());
            statement.setInt(2, category.getId());

            statement.executeUpdate();
        }
    }

    public void delete(int categoryId) throws SQLException {
        String query = "DELETE FROM category WHERE idcategory = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, categoryId);

            statement.executeUpdate();
        }
    }

    public boolean isCategoryUsed(int categoryId) throws SQLException {
        String query = "SELECT COUNT(*) FROM lots WHERE category_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, categoryId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        }

        return false;
    }

    public List<Category> getAllCategories() throws SQLException {
        List<Category> categories = new ArrayList<>();
        String query = "SELECT * FROM category";

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("idcategory");
                String name = resultSet.getString("name_category");

                Category category = new Category(id, name);
                categories.add(category);
            }
        }

        return categories;
    }
}

