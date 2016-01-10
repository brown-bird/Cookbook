# Working with Stored Procedures

**Problem:** You want to `SELECT` from the result set of a stored procedure without using `EXEC INTO`. 

**Solution:**

1. Re-write the stored procedure into a Table Valued Function (TVF).
2. Re-write the stored procedure into a Table Valued Function (TVF) and wrap that function in a stored procedure. *Preserves interface with existing clients of original stored procedure.*
3. Inline the code from the Stored Procedure that you need to use via a CTE, View, or Temp Table

## Inline Table Valued Function

**Problem:** You want to create an inline TVF.

**Solution:**

~~~sql
CREATE FUNCTION fn_QuarterlySalesByStore
     (
      @StoreID int
     )
RETURNS table
AS
RETURN (
        SELECT *
        FROM SalesDB.dbo.vw_QuarterlySales
        WHERE StoreID = @StoreID
       )
~~~

**Notes:** 

- The RETURNS clause contains only the keyword **table**. You do not have to define the format of a return variable because it is set by the format of the result set of the SELECT statement in the RETURN clause.

- There is no function_body delimited by BEGIN and END.

- The RETURN clause contains a single SELECT statement in parentheses. The result set of the SELECT statement forms the table returned by the function. The SELECT statement used in an inline function is subject to the same restrictions as SELECT statements used in views.

- The table-valued function accepts only constants or @local_variable arguments

## Multistatement table-valued functions

**Problem:** You want to write a table valued function that uses multiple statements and cannot be defined as an inline TVF.

**Solution:**


*EXAMPLE From MSDN PAGES:*

 Creating a multi-statement table-valued function
The following example creates the table-valued function fn_FindReports(InEmpID) in the AdventureWorks2012 database. When supplied with a valid employee ID, the function returns a table that corresponds to all the employees that report to the employee either directly or indirectly. The function uses a recursive common table expression (CTE) to produce the hierarchical list of employees. For more information about recursive CTEs, see WITH common_table_expression (Transact-SQL).

~~~sql
IF OBJECT_ID (N'dbo.ufn_FindReports', N'TF') IS NOT NULL
    DROP FUNCTION dbo.ufn_FindReports;
GO
CREATE FUNCTION dbo.ufn_FindReports (@InEmpID INTEGER)
RETURNS @retFindReports TABLE 
(
    EmployeeID int primary key NOT NULL,
    FirstName nvarchar(255) NOT NULL,
    LastName nvarchar(255) NOT NULL,
    JobTitle nvarchar(50) NOT NULL,
    RecursionLevel int NOT NULL
)
--Returns a result set that lists all the employees who report to the 
--specific employee directly or indirectly.*/
AS
BEGIN
WITH EMP_cte(EmployeeID, OrganizationNode, FirstName, LastName, JobTitle, RecursionLevel) -- CTE name and columns
    AS (
        SELECT e.BusinessEntityID, e.OrganizationNode, p.FirstName, p.LastName, e.JobTitle, 0 -- Get the initial list of Employees for Manager n
        FROM HumanResources.Employee e 
INNER JOIN Person.Person p 
ON p.BusinessEntityID = e.BusinessEntityID
        WHERE e.BusinessEntityID = @InEmpID
        UNION ALL
        SELECT e.BusinessEntityID, e.OrganizationNode, p.FirstName, p.LastName, e.JobTitle, RecursionLevel + 1 -- Join recursive member to anchor
        FROM HumanResources.Employee e 
            INNER JOIN EMP_cte
            ON e.OrganizationNode.GetAncestor(1) = EMP_cte.OrganizationNode
INNER JOIN Person.Person p 
ON p.BusinessEntityID = e.BusinessEntityID
        )
-- copy the required columns to the result of the function 
   INSERT @retFindReports
   SELECT EmployeeID, FirstName, LastName, JobTitle, RecursionLevel
   FROM EMP_cte 
   RETURN
END;
GO
-- Example invocation
SELECT EmployeeID, FirstName, LastName, JobTitle, RecursionLevel
FROM dbo.ufn_FindReports(1); 

GO
~~~

## Rewriting Stored Procedures as Functions
This topic describes how to determine whether to rewrite existing stored procedure logic as user-defined functions. For example, if you want to invoke a stored procedure directly from a query, repackage the code as a user-defined function.
In general, if the stored procedure returns a (single) result set, define a table-valued function. If the stored procedure computes a scalar value, define a scalar function.

#### Criteria for Table-Valued Functions

If a stored procedure meets the following criteria, it is a good candidate for being rewritten as a table-valued function:

- The logic is expressible in a single SELECT statement but is a stored procedure, rather than a view, only because of the need for parameters. This scenario can be handled with an inline table-valued function.

- The stored procedure does not perform update operations (except to table variables).

- There is no need for dynamic EXECUTE statements

- The stored procedure returns one result set.

- The primary purpose of the stored procedure is to build intermediate results that are to be loaded into a temporary table, which is then queried in a SELECT statement. INSERT...EXEC statements can be written using table-valued functions. For example, consider the following sequence:

~~~sql
INSERT #temp EXEC sp_getresults
SELECT ...
    FROM #temp, t1
    WHERE ...
The sp_getresults stored procedure can be rewritten as a table-valued function, for example fn_results(), which means the preceding statements can be rewritten as:
SELECT ...
    FROM fn_results(), t1
    WHERE ...
~~~    