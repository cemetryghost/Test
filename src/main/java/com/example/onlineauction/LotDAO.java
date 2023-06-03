package com.example.onlineauction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LotDAO {
    private final Connection connection;

    public LotDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(Lot lot) throws SQLException {
        String query = "INSERT INTO lots (name_lots, description_lots, start_price, current_price, step_price, " +
                "publication_date, closing_date, condition_lots, status_lots, seller_id, buyer_id, category_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, lot.getName());
            statement.setString(2, lot.getDescription());
            statement.setDouble(3, lot.getStartPrice());
            statement.setDouble(4, lot.getCurrentPrice());
            statement.setDouble(5, lot.getStepPrice());
            statement.setString(6, lot.getPublicationDate());
            statement.setString(7, lot.getClosingDate());
            statement.setString(8, lot.getCondition());
            statement.setString(9, lot.getStatusLot().getStatus());
            statement.setInt(10, lot.getSellerId());
            statement.setInt(11, lot.getBuyerId());
            statement.setInt(12, lot.getCategoryId());

            statement.executeUpdate();
        }
    }

    public void update(Lot lot) throws SQLException {
        String query = "UPDATE lots SET name_lots = ?, description_lots = ?, start_price = ?, current_price = ?, " +
                "step_price = ?, publication_date = ?, closing_date = ?, condition_lots = ?, status_lots = ?, " +
                "seller_id = ?, buyer_id = ?, category_id = ? WHERE idlots = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, lot.getName());
            statement.setString(2, lot.getDescription());
            statement.setDouble(3, lot.getStartPrice());
            statement.setDouble(4, lot.getCurrentPrice());
            statement.setDouble(5, lot.getStepPrice());
            statement.setString(6, lot.getPublicationDate());
            statement.setString(7, lot.getClosingDate());
            statement.setString(8, lot.getCondition());
            statement.setString(9, lot.getStatusLot().getStatus());
            statement.setInt(10, lot.getSellerId());
            statement.setInt(11, lot.getBuyerId());
            statement.setInt(12, lot.getCategoryId());
            statement.setInt(13, lot.getId());

            statement.executeUpdate();
        }
    }

    public void delete(int lotId) throws SQLException {
        String query = "DELETE FROM lots WHERE idlots = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, lotId);
            statement.executeUpdate();
        }
    }

    public Lot getById(int lotId) throws SQLException {
        String query = "SELECT * FROM lots WHERE idlots = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, lotId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Lot lot = new Lot();
                    lot.setId(resultSet.getInt("idlots"));
                    lot.setName(resultSet.getString("name_lots"));
                    lot.setDescription(resultSet.getString("description_lots"));
                    lot.setStartPrice(resultSet.getDouble("start_price"));
                    lot.setCurrentPrice(resultSet.getDouble("current_price"));
                    lot.setStepPrice(resultSet.getDouble("step_price"));
                    lot.setPublicationDate(resultSet.getString("publication_date"));
                    lot.setClosingDate(resultSet.getString("closing_date"));
                    lot.setCondition(resultSet.getString("condition_lots"));
                    lot.setStatusLot(StatusLot.valueOf(resultSet.getString("status_lots")));
                    lot.setSellerId(resultSet.getInt("seller_id"));
                    lot.setBuyerId(resultSet.getInt("buyer_id"));
                    lot.setCategoryId(resultSet.getInt("category_id"));

                    return lot;
                }
            }
        }

        return null;
    }

    public List<Lot> getAllLots() throws SQLException {
        List<Lot> lots = new ArrayList<>();
        String query = "SELECT * FROM lots";

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Lot lot = new Lot();
                lot.setId(resultSet.getInt("idlots"));
                lot.setName(resultSet.getString("name_lots"));
                lot.setDescription(resultSet.getString("description_lots"));
                lot.setStartPrice(resultSet.getDouble("start_price"));
                lot.setCurrentPrice(resultSet.getDouble("current_price"));
                lot.setStepPrice(resultSet.getDouble("step_price"));
                lot.setPublicationDate(resultSet.getString("publication_date"));
                lot.setClosingDate(resultSet.getString("closing_date"));
                lot.setCondition(resultSet.getString("condition_lots"));
                lot.setStatusLot(StatusLot.valueOf(resultSet.getString("status_lots")));
                lot.setSellerId(resultSet.getInt("seller_id"));
                lot.setBuyerId(resultSet.getInt("buyer_id"));
                lot.setCategoryId(resultSet.getInt("category_id"));

                lots.add(lot);
            }
        }

        return lots;
    }

    public List<Lot> getLotsByCategory(int categoryId) throws SQLException {
        List<Lot> lots = new ArrayList<>();
        String query = "SELECT * FROM lots WHERE category_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, categoryId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Lot lot = new Lot();
                    lot.setId(resultSet.getInt("idlots"));
                    lot.setName(resultSet.getString("name_lots"));
                    lot.setDescription(resultSet.getString("description_lots"));
                    lot.setStartPrice(resultSet.getDouble("start_price"));
                    lot.setCurrentPrice(resultSet.getDouble("current_price"));
                    lot.setStepPrice(resultSet.getDouble("step_price"));
                    lot.setPublicationDate(resultSet.getString("publication_date"));
                    lot.setClosingDate(resultSet.getString("closing_date"));
                    lot.setCondition(resultSet.getString("condition_lots"));
                    lot.setStatusLot(StatusLot.valueOf(resultSet.getString("status_lots")));
                    lot.setSellerId(resultSet.getInt("seller_id"));
                    lot.setBuyerId(resultSet.getInt("buyer_id"));
                    lot.setCategoryId(resultSet.getInt("category_id"));

                    lots.add(lot);
                }
            }
        }

        return lots;
    }

    public List<Lot> getActiveLots() throws SQLException {
        List<Lot> lots = new ArrayList<>();
        String query = "SELECT * FROM lots WHERE status_lots = 'Активный'";

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Lot lot = new Lot();
                lot.setId(resultSet.getInt("idlots"));
                lot.setName(resultSet.getString("name_lots"));
                lot.setDescription(resultSet.getString("description_lots"));
                lot.setStartPrice(resultSet.getDouble("start_price"));
                lot.setCurrentPrice(resultSet.getDouble("current_price"));
                lot.setStepPrice(resultSet.getDouble("step_price"));
                lot.setPublicationDate(resultSet.getString("publication_date"));
                lot.setClosingDate(resultSet.getString("closing_date"));
                lot.setCondition(resultSet.getString("condition_lots"));
                lot.setStatusLot(StatusLot.valueOf(resultSet.getString("status_lots")));
                lot.setSellerId(resultSet.getInt("seller_id"));
                lot.setBuyerId(resultSet.getInt("buyer_id"));
                lot.setCategoryId(resultSet.getInt("category_id"));

                lots.add(lot);
            }
        }

        return lots;
    }

    public List<Lot> getLotsBySeller(int sellerId) throws SQLException {
        List<Lot> lots = new ArrayList<>();
        String query = "SELECT * FROM lots WHERE seller_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, sellerId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Lot lot = new Lot();
                    lot.setId(resultSet.getInt("idlots"));
                    lot.setName(resultSet.getString("name_lots"));
                    lot.setDescription(resultSet.getString("description_lots"));
                    lot.setStartPrice(resultSet.getDouble("start_price"));
                    lot.setCurrentPrice(resultSet.getDouble("current_price"));
                    lot.setStepPrice(resultSet.getDouble("step_price"));
                    lot.setPublicationDate(resultSet.getString("publication_date"));
                    lot.setClosingDate(resultSet.getString("closing_date"));
                    lot.setCondition(resultSet.getString("condition_lots"));
                    lot.setStatusLot(StatusLot.valueOf(resultSet.getString("status_lots")));
                    lot.setSellerId(resultSet.getInt("seller_id"));
                    lot.setBuyerId(resultSet.getInt("buyer_id"));
                    lot.setCategoryId(resultSet.getInt("category_id"));

                    lots.add(lot);
                }
            }
        }

        return lots;
    }

    public void updateLotStatus(int lotId, StatusLot statusLot) throws SQLException {
        String query = "UPDATE lots SET status_lots = ? WHERE idlots = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, statusLot.getStatus());
            statement.setInt(2, lotId);
            statement.executeUpdate();
        }
    }
}
