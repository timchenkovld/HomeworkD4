SELECT project.NAME, SUM(worker.SALARY * DATEDIFF(MONTH, project.START_DATE, project.FINISH_DATE)) AS PRICE
FROM project
JOIN project_worker ON project.ID = project_worker.PROJECT_ID
JOIN worker ON project_worker.WORKER_ID = worker.ID
GROUP BY project.NAME
ORDER BY PRICE DESC, project.NAME ASC;