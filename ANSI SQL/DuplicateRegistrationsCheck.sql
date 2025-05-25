SELECT 
    user_id,
    event_id,
    COUNT(*) AS registration_count
FROM 
    Registration
GROUP BY 
    user_id, event_id
HAVING 
    COUNT(*) > 1;

