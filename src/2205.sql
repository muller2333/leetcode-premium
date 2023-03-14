CREATE FUNCTION getUserIDs(startDate DATE, endDate DATE, minAmount INT) RETURNS INT
BEGIN
    RETURN (
        select count(distinct user_id)
        from Purchases
        where time_stamp >= startDate
          and time_stamp <= endDate
          and amount >= minAmount
    );
END