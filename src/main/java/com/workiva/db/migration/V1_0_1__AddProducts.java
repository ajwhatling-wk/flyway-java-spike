package com.workiva.db.migration;

import org.flywaydb.core.api.migration.jdbc.JdbcMigration;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class V1_0_1__AddProducts implements JdbcMigration {
    public void migrate(Connection connection) throws Exception {
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO product(name) VALUES " +
                "('Doge Coin Collectable')," +
                "('Tears of the Raging Call of Duty Players')," +
                "('Replica Chuck Norris Beard');");

        try {
            stmt.execute();
        } finally {
            stmt.close();
        }
    }
}
