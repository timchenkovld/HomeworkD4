package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private Database database;

    public DatabaseQueryService(Database database) {
        this.database = database;
    }

    public List<ProjectPricesInfoClient> findProjectPrices(){
        List<ProjectPricesInfoClient> projectPricesInfoClients = new ArrayList<>();
        Connection connection = database.getConnection();
        String sqlFilePath = "sql/print_project_prices.sql";
        StringBuilder sqlQuery = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(sqlFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                sqlQuery.append(line).append("\n");
            }
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sqlQuery.toString())) {
                while (resultSet.next()) {
                    String name = resultSet.getString("project.NAME");
                    int price = resultSet.getInt("PRICE");
                    ProjectPricesInfoClient client = new ProjectPricesInfoClient(name, price);
                    projectPricesInfoClients.add(client);
                }
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return projectPricesInfoClients;
    }
    public List<ProjectDurationClient> findProjectDurations() {
        List<ProjectDurationClient> projectDurations = new ArrayList<>();
        Connection connection = database.getConnection();
        String sqlFilePath = "sql/find_longest_project.sql";
        StringBuilder sqlQuery = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(sqlFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                sqlQuery.append(line).append("\n");
            }
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sqlQuery.toString())) {
                while (resultSet.next()) {
                    String name = resultSet.getString("project.NAME");
                    int monthCount = resultSet.getInt("MONTH_COUNT");
                    ProjectDurationClient client = new ProjectDurationClient(name, monthCount);
                    projectDurations.add(client);
                }
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return projectDurations;
    }
    public List<MaxSalaryWorkerClient> findMaxSalaryWorker(){
        List<MaxSalaryWorkerClient> maxSalaryWorkerClient = new ArrayList<>();
        Connection connection = database.getConnection();
        String sqlFilePath = "sql/find_max_salary_worker.sql";
        StringBuilder sqlQuery = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(sqlFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                sqlQuery.append(line).append("\n");
            }
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sqlQuery.toString())) {
                while (resultSet.next()) {
                    String name = resultSet.getString("NAME");
                    int salary = resultSet.getInt("SALARY");
                    MaxSalaryWorkerClient client = new MaxSalaryWorkerClient(name, salary);
                    maxSalaryWorkerClient.add(client);
                }
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return maxSalaryWorkerClient;
    }
    public List<WorkerInfoClient> findYoungestEldestWorkers() {
        List<WorkerInfoClient> workerInfoList = new ArrayList<>();
        Connection connection = database.getConnection();
        String sqlFilePath = "sql/find_youngest_eldest_workers.sql";
        StringBuilder sqlQuery = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(sqlFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                sqlQuery.append(line).append("\n");
            }
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sqlQuery.toString())) {
                while (resultSet.next()) {
                    String type = resultSet.getString("TYPE");
                    String name = resultSet.getString("NAME");
                    LocalDate birthday = resultSet.getDate("BIRTHDAY").toLocalDate();
                    WorkerInfoClient worker = new WorkerInfoClient(type, name, birthday);
                    workerInfoList.add(worker);
                }
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return workerInfoList;
    }
    public List<MaxProjectCountClient> findMaxProjectsClient() {
        List<MaxProjectCountClient> maxProjectCountClients = new ArrayList<>();
        Connection connection = database.getConnection();
        String sqlFilePath = "sql/find_max_projects_client.sql";
        StringBuilder sqlQuery = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(sqlFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                sqlQuery.append(line).append("\n");
            }
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sqlQuery.toString())) {
                while (resultSet.next()) {
                    String name = resultSet.getString("NAME");
                    int projectCount = resultSet.getInt("PROJECT_COUNT");
                    MaxProjectCountClient client = new MaxProjectCountClient(name, projectCount);
                    maxProjectCountClients.add(client);
                }
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return maxProjectCountClients;
    }
}
