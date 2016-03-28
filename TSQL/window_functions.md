# Window Functions

A *window function* is a function that, for each row, computes a scalar result value based on a calculation against a subset of the rows from the underlying query. 

You are not returning the row that matches the function definition but appending a column where the value is specified by the function definition over the window (subset of rows from underlying query result) definitioin. 

**Note:** the starting point of a window function is the underlying query's result set, which generated only when you reach the SELECT phrase. Window functions are allowed only in the SELECT and ORDER BY clauses. 

### OVER()
The window specification in the OVER clause has three main parts: partitioning, ordering, and framing. An empty OVER() clause exposes to the function a window made of all rows from the underlying query's result set. 

### PARTITION BY
The window partition clause restricts the window to the subset of rows from the underlying query's result set that share the same values in the partitioning columns as in the current row. 

### ORDER BY
The window order clause defines ordering in the window, but not the presentation order of the underlying query. The window ordering gives meaning to *window framing*.

### Framing
After order has been defined in the window, a window frame clause (ROWS BETWEEN <top delimiter> AND <bottom delimiter>) filters a frame, or a subset, of rows from the window partition between the two specified delimiters. e.g. `... ORDER BY orderMonth ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW`

### Ranking Window Functions

Ranking window functions allow you to rank each row in respect to others in several different ways. SQL Server supports four ranking functions: `ROW_NUMBER`, `RANK`, `DENSE_RANK`, and `NTILE`.

`ROW_NUMBER` must produce unique values even when there are ties in the ORDER BY criteria. Therefore, `ROW_NUMBER` does not produce unique results. To solve this problem you can:

1. Ensure there are no duplicates in the `ORDER BY` clause.
2. Use `RANK` which produces the same ranking value for values that are logically ranked the same. After duplicates `RANK` will increment to the next value. e.g. Two rows result in an order of 7 so the following row will in the window will rank as 9 instead of 8. This tells you there are 8 actual rows before this row. 
3. Use `DENSE_RANK` treats ties the same as `RANK` but produces a ranking value per distinct result. So, with a tie where two rows rank as 7, the next row is 8. This tells you there are 7 distinct values ranked before this row. It does not tell you how many actual rows come before this one. 

Ranking functions support window partition clauses. Remember that window partioning restricts tthe window to only those rows that share the same values in the partioning attributes as in the **current row**.

Don't use `ROW_NUMBER` and `DISTINCT` in the same `SELECT` clause.

### Offset Window Functions
Offset window functions allow you to return an element from a row that is at a crtain offset from the current row or from the beginning or end of window frame. SQL Server 2012 supports four offset functions: `LAG`, `LEAD`, `FIRST_VALUE`, `LAST_VALUE`

The `LAG` and `LEAD` functions support window partition and window order clauses. There's no relevance to window framing here. These functions allow you to obtain an element from a row that is at a certain offset from the current row within the partition, **based on the indicated ordering**.

`LAG` looks before the current row. `LEAD` looks ahead. Parameters:
`LAG (value-to-return [required], offset [optional. 1 if not specified], default [optional. NULL if not specified])`

~~~sql
SELECT custid, orderid, val,
	LAG(val) OVER(PARTITION BY custid
					ORDER BY orderdate, orderid) AS prevval,
	LEAD(val) OVER(PARTITION BY custid
					ORDER BY orderdate, orderid) AS nextval
FROM Sales.OrderValues	

~~~

`FIRST_VAL` returns the first value in a window. `LAST_VAL` returns the last value. If you want the first value in a window use `FIRST_VAL` with the window frame extent `ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW`. You should always be explicit about the frame extent, even with `FIRST_VAL`.