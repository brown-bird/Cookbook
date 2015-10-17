## Single Table Queries, T-SQL Fundamentals ch.2

####Links

1. [MSDN reference conventions] (https://msdn.microsoft.com/en-us/library/ms177563(v=sql.110))
2. [Delimiting Identifier Names] (https://msdn.microsoft.com/en-us/library/ms175874)

Statement logical processing order:

		1. FROM
		2. WHERE
		3. GROUP BY
		4. HAVING
		5. SELECT
			- Expressions
			- DISTINCT
		6. ORDER BY
			- TOP / OFFSET-FETCH


__Note:__ Output order from a query is __not__ guaranteed unless the `Order By` clause is used. 

#### GROUP BY
		
`GROUP BY` produces a group for each unique combination of `GROUP BY` list items in the order specified. 
One row in the result set represents one group. 

If the query involves grouping, all phases subsequent to the `GROUP BY` phase -- including
`HAVING, SELECT, ORDER BY` -- must operate on **groups** as opposed to operating on individual rows. 
Each group is ultimately represented by a **single** row in the final result of the query. This
implies that all expressions that you specify in clauses that are processed in phases subsequent to the
`GROUP BY` phase are required to guarantee returning a **scalar** (singular value) per group.

Elements that do not participate in the `GROUP BY` list are allowed only as inputs to an aggregate function such as `COUNT`, `SUM`, `AVG`, `MIN`, or `MAX`.

~~~sql
SELECT 
		empid, 
		YEAR(orderdate) AS orderYear,
		SUM(freight) AS totalFreight, --returns the sum of all freight values in each group
		COUNT(*) AS numOrders		  --returns the count of rows in each group
	FROM Sales.Orders
	WHERE custid = 71
	GROUP BY empid, YEAR(orderdate);	
~~~	
	
	
#### HAVING
		
Specify a predicate filter to apply to groups as opposed to filtering individual rows, like `WHERE`. Groups which evaluate to __FALSE__ or __UNKNOWN__ are filtered out.

Becuase the `HAVING` clause is processed after the rows have been grouped, you can refer to aggregate functions in the logical expression. 

`HAVING` example using aggregate function on groups:

~~~sql
SELECT
		empid,
		YEAR(orderdate) AS orderYear
	FROM Sales.Orders
	WHERE custid = 71
	GROUP BY empid, YEAR(orderdate)
	HAVING COUNT(*) > 1;
~~~