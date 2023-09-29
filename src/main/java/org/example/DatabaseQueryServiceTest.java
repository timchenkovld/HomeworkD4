package org.example;

import java.util.List;

public class DatabaseQueryServiceTest {
    public static void main(String[] args) {
        Database database = Database.getInstance();
        DatabaseQueryService queryService = new DatabaseQueryService(database);
        List<MaxProjectCountClient> maxProjectCountClients = queryService.findMaxProjectsClient();
        for (MaxProjectCountClient client : maxProjectCountClients) {
            System.out.println("Name: " + client.getName());
            System.out.println("Project Count: " + client.getProjectCount());
            System.out.println();
        }
        List<WorkerInfoClient> workerInfo = queryService.findYoungestEldestWorkers();
        for (WorkerInfoClient info : workerInfo) {
            System.out.println("Name: " + info.getName());
            System.out.println("Type: " + info.getType());
            System.out.println("Birthday: " + info.getBirthday());
            System.out.println();
        }
        List<MaxSalaryWorkerClient> maxSalaryWorkerClients = queryService.findMaxSalaryWorker();
        for (MaxSalaryWorkerClient salary : maxSalaryWorkerClients){
            System.out.println("Name: " + salary.getName());
            System.out.println("Salary: " + salary.getSalary());
            System.out.println();
        }
        List<ProjectDurationClient> projectDurations = queryService.findProjectDurations();
        for (ProjectDurationClient projectDuration : projectDurations) {
            System.out.println("Name: " + projectDuration.getName());
            System.out.println("Month Count: " + projectDuration.getMonthCount());
            System.out.println();
        }
        List<ProjectPricesInfoClient> projectPricesInfoClients = queryService.findProjectPrices();
        for (ProjectPricesInfoClient price : projectPricesInfoClients){
            System.out.println("Name: " + price.getName());
            System.out.println("Price: " + price.getPrice());
            System.out.println();
        }
    }
}
