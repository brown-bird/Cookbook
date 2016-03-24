# Greatest N Per Group

### Problem:
Return *N* rows from each group for a given condition. 

**Example:** Given a table with the with schema table(userId, someValue, my_date) You want to get the UserId, Value for the max(my_date) for each UserId. 

<br>
### Returns multiple rows
*This solution can return multiple rows per userId when multiple rows match the max date

~~~sql
select userId,
       someValue,
       ...
from
(
select userid,
       someValue,
       ...
       max(my_date) over (partition by userid) max_my_date
from   users
)
where my_date = max_my_date

~~~
<br>
### Returns the max or min
This solution returns the **first** row or the row with the highest total. **preferred solution** 

~~~sql
WITH summary AS (
    SELECT p.id, 
           p.customer, 
           p.total, 
           ROW_NUMBER() OVER(PARTITION BY p.customer 
                                 ORDER BY p.total DESC) AS rk
      FROM PURCHASES p)
SELECT s.*
  FROM summary s
 WHERE s.rk = 1
~~~

**Note:** PARTITION BY [column, ...] will append the the result of the WINDOW FUNCTION for the partition that matches the current row's columns