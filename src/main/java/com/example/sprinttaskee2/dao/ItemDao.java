package com.example.sprinttaskee2.dao;

import com.example.sprinttaskee2.entity.Item;
import com.example.sprinttaskee2.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDao {

    private static final ItemDao INSTANCE = new ItemDao();

    private static final String FIND_ALL = """
            SELECT id,
                name,
                description,
                price
            FROM item
            """;


    public List<Item> findAll() {
        try (var connection = ConnectionManager.open();
             var preparedStatement = connection.prepareStatement(FIND_ALL)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            List<Item> items = new ArrayList<>();
            while (resultSet.next()) {
                items.add(buildItem(resultSet));
            }
            return items;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Item buildItem(ResultSet resultSet) throws SQLException {
        return new Item(resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getString("description"),
                resultSet.getDouble("price"));
    }


    private ItemDao() {
    }

    public static ItemDao getInstance() {
        return INSTANCE;
    }
}
