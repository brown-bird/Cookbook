## Single Table Queries, T-SQL Fundamentals ch.2

#### Links

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

---

##### GROUP BY
		
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

--- 
	
##### HAVING
		
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

---

#### SELECT
	
Projection from relational algebra. Second to last logical operation to be executed on dataset.

You can __alias__ columns by passing a new name after the column using the optional `AS` keyword or a space. Functions which transform the data do not have column names unless you alias them. When aliasing prefer the `AS` form to avoid the silent error which occurs when you fail to specify a delimiting comma between
two columns and sql server interprets the name of the second column to be an alias. 

The result set returned from `SELECT` is not guaranteed to be a Mathematical set and can return duplicate rows from a query. You can use the `DISTINCT` keyword to return unique rows. 

It is bad practice to use the `*` syntax with `SELECT` as you can create silent errors. If columns are removed are added from a table in which an application relies on ordinal positioning, also bad, bugs can silently be introduced to the application. It is safer to always specify the exact columns needed in a query even if all of the columns are requested. If a column is dropped for instance an error will be raised in a query requesting that column. If `SELECT *` syntax is used, the error would go unnoticed.

You are not allowed to refer to a alias created in the `SELECT` clause in any other clauses as the alias is not created yet. You cannot refer to an alias created in the same `SELECT` clause either. 

Expressions in the `SELECT` list are evaluated before the `DISTINCT` clause(if one exists). This applies
to expressions based on window functions. 

~~~sql
-- Alias a column
SELECT
		empid,
		YEAR(orderdate) AS orderYear,
		COUNT(*) AS numOrders
	FROM Sales.Orders
	WHERE custid = 71
	GROUP BY empid, YEAR(orderdate)
	HAVING COUNT(*) > 1;
~~~

#### ORDER BY
		
`ORDER BY` allows you to sort the rows in the output for presentation purposes. ORDER BY is logically
processed last. 

Only way to guarantee presetation order. Result is not a __table__ but a cursor. A query with an `ORDER BY` clause results in what standard SQL calls a __cursor__ -- _a nonrelational result with order guaranteed among rows._ Some language elements and operations in SQL expect to work with table results and not with cursors e.g. table expressions and set operators

`ORDER BY` is the only clause where aliases created in `SELECT` clauses can be refered to. 

`ASC` or `DESC` keywords specified after the `ORDER BY` expression change the sort order to ascending and descending respectively. Ascending is the default order and `ASC` is optional. 

You are allowed to specify ordinal positions of columns as they are specified in the `SELECT` clause, but this is bad practice as changes in the `SELECT` clause that aren't also applied to the `ORDER BY` clause can create silent errors. Explicitly specifying column names avoids these kinds of errors. 

You can specify columns in the `ORDER BY` clause that aren't present in the `SELECT` clause, meaning you can sort by something you don't necessarily want to return in the output. However, when `DISTINCT` is passed in the SELECT clause you cannot specify columns in `ORDER BY` that aren't in the `SELECT` clause also.

Using `ORDER BY` on a column with duplicate values will not give a deterministic result ordering unless tie breaker is specified in the `ORDER BY` clause. 

~~~sql
	SELECT 
		empid,
		YEAR(orderdate) AS orderYear,
		COUNT(*) AS numOrders
	FROM Sales.Orders
	WHERE custid = 71
	GROUP BY empid, YEAR(orderdate)
	HAVING COUNT(*) > 1
	ORDER BY empid, orderYear
~~~

