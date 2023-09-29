package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {
    public static void main(String[] args) {
        Connection connection = Database.getInstance().getConnection();
        String sqlFilePath = "sql/init_db.sql";

        try(BufferedReader reader = new BufferedReader(new FileReader(sqlFilePath));
            Statement statement = connection.createStatement()) {

            String line;
            StringBuilder sqlQuery = new StringBuilder();
            while ((line = reader.readLine()) != null){
                if (line.trim().isEmpty()){
                    continue;
                }
                sqlQuery.append(line).append("\n");
                if (line.endsWith(";")){
                    statement.execute(sqlQuery.toString());
                    sqlQuery.setLength(0);
                }
            }
        }catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
