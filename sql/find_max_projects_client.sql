SELECT client.NAME, COUNT(project.ID) AS PROJECT_COUNT
FROM client
JOIN project ON client.ID = project.CLIENT_ID
GROUP BY client.NAME

