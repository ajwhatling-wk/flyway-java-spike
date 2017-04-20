package com.workiva.db.migration;

import org.flywaydb.core.api.migration.jdbc.JdbcMigration;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class V1_1_1__AddProducts implements JdbcMigration {
    public void migrate(Connection connection) throws Exception {
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO product (name, properties) VALUES " +
                "('Pokemon Go - Old People Edition', '{\"sku_id\": \"S-162345\"}'), " +
                "('Fake News Generator', '{\"sku_id\": \"S-2200932\"}'), " +
                "('Glass of Water', '{\"sku_id\": \"M-0011151\"}')");

        try {
            stmt.execute();
        } finally {
            stmt.close();
        }
    }
}
