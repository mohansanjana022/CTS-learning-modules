INSERT INTO Sessions (event_id, title, speaker_name, start_time, end_time)
VALUES (3, 'Advanced CSS', 'Bob Smith', '2025-07-02 14:00:00', '2025-07-02 16:00:00');

SELECT 
    speaker_name,
    COUNT(*) AS session_count
FROM 
    Sessions
GROUP BY 
    speaker_name
HAVING 
    COUNT(*) > 1;
