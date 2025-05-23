SELECT 
    e.event_id,
    e.title,
    COUNT(s.session_id) AS session_count_10_to_12
FROM 
    Events e
JOIN 
    Sessions s ON e.event_id = s.event_id
WHERE 
    TIME(s.start_time) BETWEEN '10:00:00' AND '11:59:59'
GROUP BY 
    e.event_id, e.title
ORDER BY
    session_count_10_to_12 DESC;

