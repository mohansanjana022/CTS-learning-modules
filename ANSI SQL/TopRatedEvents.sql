SELECT 
    e.event_id,
    e.title,
    COUNT(f.feedback_id) AS feedback_count,
    AVG(f.rating) AS average_rating
FROM 
    Events e
JOIN 
    Feedback f ON e.event_id = f.event_id
GROUP BY 
    e.event_id, e.title
HAVING 
    COUNT(f.feedback_id) >= 10
ORDER BY 
    average_rating DESC
LIMIT 10;  -- to get top 10 rated events

