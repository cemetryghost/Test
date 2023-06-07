package com.example.onlineauction.dao;

import com.example.onlineauction.model.Bid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BidDAO {
    private Connection connection;

    public BidDAO(Connection connection) {
        this.connection = connection;
    }

    // Метод для добавления ставки в таблицу bids
    public void addBid(Bid bid) throws SQLException {
        String query = "INSERT INTO bids (lot_id, buyer_id, bid_amount) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, bid.getLotId());
            statement.setInt(2, bid.getBuyerId());
            statement.setDouble(3, bid.getBidAmount());
            statement.executeUpdate();
        }
    }

    // Метод для получения всех ставок для определенного лота
    public List<Bid> getBidsByLotId(int lotId) throws SQLException {
        List<Bid> bids = new ArrayList<>();
        String query = "SELECT * FROM bids WHERE lot_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, lotId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Bid bid = new Bid(
                            resultSet.getInt("idbids"),
                            resultSet.getInt("lot_id"),
                            resultSet.getInt("byuer_id"),
                            resultSet.getDouble("bid_amount")
                    );
                    bids.add(bid);
                }
            }
        }
        return bids;
    }

    // Метод для обновления ставки в таблице bids
    public void updateBid(Bid bid) throws SQLException {
        String query = "UPDATE bids SET lot_id = ?, buyer_id = ?, bid_amount = ? WHERE idbids = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, bid.getLotId());
            statement.setInt(2, bid.getBuyerId());
            statement.setDouble(3, bid.getBidAmount());
            statement.setInt(4, bid.getId());
            statement.executeUpdate();
        }
    }

    // Дополнительные методы, если необходимо
}
