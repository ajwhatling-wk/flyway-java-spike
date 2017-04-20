package com.workiva.db.migration;

import org.flywaydb.core.api.migration.jdbc.JdbcMigration;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class V1__ProductTable implements JdbcMigration {

    public void migrate(Connection connection) throws Exception {
        PreparedStatement stmt = connection.prepareStatement("CREATE TABLE product ("
                + "pid INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + "name VARCHAR(255) NOT NULL"
                + ");");

        try {
            stmt.execute();
        } finally {
            stmt.close();
        }
    }
}
