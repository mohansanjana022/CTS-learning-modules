SELECT 
    u.user_id,
    u.full_name
FROM 
    Users u
LEFT JOIN 
    Registration r ON u.user_id = r.user_id 
    AND r.registration_date >= CURDATE() - INTERVAL 90 DAY
WHERE 
    r.user_id IS NULL;

