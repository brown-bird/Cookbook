-- Single Table Queries, T-SQL Fundamentals ch.2

--USE TSQL2012

/*****************************************************************************************************************
	Links
		
		1. MSDN reference conventions: https://msdn.microsoft.com/en-us/library/ms177563(v=sql.110)
		2. Delimiting Identifier Names: https://msdn.microsoft.com/en-us/library/ms175874

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

	Output order from a query is not guaranteed unless the "Order By" clause is used. 
******************************************************************************************************************/
	
/*****************************************************************************************************************
	GROUP BY
		
		0. GROUP BY produces a group for each unique combination of GROUP BY list items in the order specified. 
		One row in the result set represents one group. 

		1. If the query involves grouping, all phases subsequent to the GROUP BY phase -- including
		HAVING, SELECT, ORDER BY -- must operate on groups as opposed to operating on individual rows. 
		Each group is ultimately represented by a single row in the final result of the query. This
		implies that all expressions that you specify in clauses that are processed in phases subsequent to the
		GROUP BY phase are required to guarantee returning a scalar (singular value) per group.

******************************************************************************************************************/
	
	-- Elements that do not participate in the GROUP BY list are allowed only as inputs to an aggregate
	-- function suc as COUNT, SUM, AVG, MIN, or MAX.
	SELECT 
		empid, 
		YEAR(orderdate) AS orderYear,
		SUM(freight) AS totalFreight, --returns the sum of all freight values in each group
		COUNT(*) AS numOrders		  --returns the count of rows in each group
	FROM Sales.Orders
	WHERE custid = 71
	GROUP BY empid, YEAR(orderdate);	

/*****************************************************************************************************************
	HAVING
		
		0. Specify a predicate filter to apply to groups as opposed to filtering individual rows, like "WHERE".
		Groups which evaluate to FALSE or UNKNOWN are filtered out

		1. Becuase the HAVING clause is processed after the rows have been grouped, you can refer to aggregate
		functions in the logical expression. 
******************************************************************************************************************/
	
-- 1. HAVING example using aggregate function on groups
	SELECT
		empid,
		YEAR(orderdate) AS orderYear
	FROM Sales.Orders
	WHERE custid = 71
	GROUP BY empid, YEAR(orderdate)
	HAVING COUNT(*) > 1;

/*****************************************************************************************************************
	SELECT
		
		0. Projection from relational algebra. Second to last logical operation to be executed on dataset.

		1. You can "alias" columns by passing a new name after the column using the optional "AS" keyword or a space. 
		Functions which transform the data do not have column names unless you alias them. When aliasing prefer
		the "AS" form to avoid the silent error which occurs when you fail to specify a delimiting comma between
		two columns and sql server interprets the name of the second column to be an alias. 

		2. The result set returned from SELECT is not guaranteed to be a Mathematical set and can return duplicate
		rows from a query. You can use the DISTINCT keyword to return unique rows. 

		3. It is bad practice to use the "*" syntax with SELECT as you can create silent errors. If columns are 
		removed are added from a table in which an application relies on ordinal positioning, also bad, bugs can 
		silently be introduced to the application. It is safer to always specify the exact columns needed in a 
		query even if all of the columns are requested. If a column is dropped for instance an error will be raised
		in a query requesting that column. If 'SELECT *' syntax is used, the error would go unnoticed.

		4. You are not allowed to refer to a alias created in the SELECT clause in any other clauses as the alias
		is not created yet. You cannot refer to an alias created in the same SELECT clause either. 

		5. Expressions in the SELECT list are evaluated before the DISTINCT clause(if one exists). This applies
		to expressions based on window functions. 
******************************************************************************************************************/

-- 1. Alias a column
	SELECT
		empid,
		YEAR(orderdate) AS orderYear,
		COUNT(*) AS numOrders
	FROM Sales.Orders
	WHERE custid = 71
	GROUP BY empid, YEAR(orderdate)
	HAVING COUNT(*) > 1;

/*****************************************************************************************************************
	ORDER BY
		
		0. ORDER BY allows you to sort the rows in the output for presentation purposes. ORDER BY is logically
		processed last. 

		1. Only way to guarantee presetation order. Result is not a "table" but a cursor. A query with an 
		ORDER BY clause results in what standard SQL calls a "cursor" -- a nonrelational result with order 
		guaranteed among rows. Some language elements and operations in SQL expect to work with table results
		and not with cursors e.g. table expressions and set operators

		2. ORDER BY is the only clause where aliases created in SELECT clauses can be refered to. 

		3. ASC or DESC keywords specified after the ORDER BY expression change the sort order to ascending and
		descending respectively. Ascending is the default order and ASC is optional. 

		4. You are allowed to specify ordinal positions of columns as they are specified in the SELECT clause,
		but this is bad practice as changes in the SELECT clause that aren't also applied to the ORDER BY 
		clause can create silent errors. Explicitly specifying column names avoids these kinds of errors. 

		5. You can specify columns in the ORDER BY clause that aren't present in the SELECT clause, meaning you 
		can sort by something you don't necessarily want to return in the output. However, when DISTINCT is 
		passed in the SELECT clause you cannot specify columns in ORDER BY that aren't in the SELECT clause also.

		6. Using ORDER BY on a column with duplicate values will not give a deterministic result ordering unless
		a tie breaker is specified in the ORDER BY clause. 
******************************************************************************************************************/
	SELECT 
		empid,
		YEAR(orderdate) AS orderYear,
		COUNT(*) AS numOrders
	FROM Sales.Orders
	WHERE custid = 71
	GROUP BY empid, YEAR(orderdate)
	HAVING COUNT(*) > 1
	ORDER BY empid, orderYear


/*****************************************************************************************************************
	Built-in Functions
******************************************************************************************************************/	

/*****************************************************************************************************************
	Date and Time Functions
		
		1. YEAR(date) - returns the year part of a date
******************************************************************************************************************/

-- 1. YEAR(date)
	SELECT empid, YEAR(orderdate) AS 'YEAR(orderdate)'
	FROM Sales.Orders
	WHERE custid = 71
	GROUP BY empid, YEAR(orderdate);

/*****************************************************************************************************************
	AGGREGATE FUNCTIONS
		
		0. All aggregate functions ignore "NULL" values except COUNT(*). If column "qty" contains {2, 2, null, 8}
		COUNT(qty) will return 3, but COUNT(*) will return 4. 

		1. If you want to handle only distinct occurrences of known values, specify the DISTINCT keyword in the 
		parenthesis of the aggregate function. ex: COUNT(DISTINCT qty). The distinct keyword can be used with other
		functions as well e.g. SUM(DISTICT qty), AVG(DISTINCT qty)
******************************************************************************************************************/
-- 1. DISTINCT keyword
	SELECT 
		empid, 
		YEAR(orderdate) AS 'YEAR(orderdate)',
		COUNT(DISTINCT custid) AS numcusts
	FROM Sales.Orders
	GROUP BY empid, YEAR(orderdate);

/*****************************************************************************************************************
	TOP
		
		0. TOP allows limiting the number or percentage of rows that a query returns. 
		It takes 2 parameters:
			-1- The number or percent of rows to return
			-2- The ordering 

		1. TOP, like ORDER BY, is evaluated after the SELECT clause including the DISTINCT option. If DISTINCT is
		specified in the SELECT clause then the TOP filter is evaluated after duplicates are removed. The result
		order of using TOP without an ORDER BY clause is undefined. SQL server returns the first n rows it accesses
		first where n is the number parameter specified in the TOP clause.

		2. When using TOP the ORDER BY clause gives TOP meaning. e.g. ORDER BY purchaseDate DESC 

		3. The PERCENT keyword is rounded up.

		4. If there are duplicate values in the ORDER BY clause you can either specify a tiebreaker column or
		you can use the WITH TIES option for TOP which will return the top n rows based on the ORDER BY parameter
		plus all other rows that have the same value as the last row of the original rows returned. 
******************************************************************************************************************/

-- return 5 most recent orders 
SELECT TOP (5) orderid, orderdate, custid, empid
FROM Sales.Orders
ORDER BY orderdate DESC;

-- PERCENT keyword example
SELECT TOP (1) PERCENT orderid, orderdate, custid, empid
FROM Sales.Orders
ORDER BY orderdate DESC;

-- 4. with ties option
SELECT TOP (5) WITH TIES orderid, orderdate, custid, empid
FROM Sales.Orders
ORDER BY orderdate DESC;

/*****************************************************************************************************************
	OFFSET-FETCH
		
		0. OFFSET-FETCH is considered part of the ORDER BY clause. Similar to TOP but is Standard SQL and supports 
		skipping where TOP doesn't. 

		1. OFFSET specifies how many rows to skip.

		2. FETCH specifies how many rows to filter after skipping. 

		3. OFFSET-FETCH must have an ORDER BY clause. FETCH cannot be used without OFFSET, but OFFSET can be used by itself.
		To use only FETCH: "OFFSET 0 ROWS"

		4. ROW and ROWS keywords are intercahngeable. Likewise FIRST and NEXT are interchangeable. 

		5. OFFSET-FETCH supports skipping which TOP doesn't, but OFFSET-FETCH doesn't support PERCENT or WITH TIES.
		Prefer OFFSET-FETCH when possible as it is standard SQL. 
******************************************************************************************************************/

-- OFFSET-FETCH
SELECT orderid, orderdate, custid, empid
FROM Sales.Orders
ORDER BY orderdate, orderid
OFFSET 50 ROWS FETCH NEXT 25 ROWS ONLY;


/******************************************************************************************************************
Quick look at Window Functions

	0. A window function is a function that, for each row in the underlying query, operates on a window (set) of 
	rows and computes a scalar (single) result value. The window of rows is defined using an OVER clause.

	1. The OVER clause exposes to the function a subset of the rows from the underlying query's result set. The 
	OVER clause can restrict the rows in the window by using the PARTITION BY clause subclause, and it can define ordering for
	the calculation using it's own ORDER BY subclause. 

	2. The ROW_NUMBER function assigns unique, sequential, incrementing integers to the rows in the result
	within the respective partition, based on the indicated ordering. Note that if the ORDER BY list is non-unique
	the result of ROW_NUMBER is non-deterministic. Add a tie-breaker to the ORDER BY list to ensure a single correct
	result. 
******************************************************************************************************************/
SELECT orderid, custid, val,
  ROW_NUMBER() OVER(PARTITION BY custid
                    ORDER BY val) AS rownum
FROM Sales.OrderValues
ORDER BY custid, val;


/******************************************************************************************************************
	Predicates and Operators

	0. Predicates are logical expressions that evaluate to TRUE, FALSE, or UNKNOWN. Examples include IN, BETWEEN, 
	and LIKE.

	1. IN checks whether a value , or scalar expression, is equal to at least one of the elements in a set. 

	2. BETWEEN allows you tocheck whether a value is in a specified range, inclusive of two specified boundary values. 

	3. LIKE checks whether a character string value meets a specified pattern. The prefix leter 'N' as in the example 
	N'D%' stands for National and is used to denote that a character string is of a Unicode data type(NCHAR or NVARCHAR)
	as opposed to a regular character data type(CHAR or VARCHAR). 

	4. T-SQL supports the folloning comparison operators: =, >, <, >=, <=, <>, !=, !>, !<, of which the last three are 
	not standard. Prefer the standard alternatives of non-standard operators. Combine logical exressions with the
	logical operators OR and AND. Negate an expression with NOT. 
******************************************************************************************************************/

/******************************************************************************************************************
	CASE Expressions

	0. A scalar expression that returns a value based on conditional logic. 

	1. Allowed wherever scalar expressions are allowed such as SELECT, WHERE, HAVING, and ORDER BY clauses and in 
	CHECK constraints.

	2. Two forms are "simple" and "searched". 
		a. Simple form allows comparison of one value or scalar expresison with
		a list of possible values and return a value for the first match. Else is the default when no match is found.
		If no ELSE clause is specified it defaults to ELSE NULL.

		b. The searched form allows specification of predicates in the WHEN clauses instead of simple equality 
		comparisons.

	3. Some functions which can be considered abbreviations of CASE expressions(ISNULL, COALESCE, IIF, and CHOOSE):
		a. ISNULL (non-std) - takes two args, ISNULL(col1, ""), and returns the first which is not null or NULL if both are NULL.
	
		b. COALESCE (std) - like ISNULL but takes 2 more args. The behavior is the same as ISNULL. Prefer COALESCE as it
		is standard. 

		c. IIF (non-std) - like java ternary operator. IIF(<logical_expression>, <return if true>, <return if false>)

		d. CHOOSE(non-std) returns the expression based on the passed in index value. 
		CHOOSE(<index>, <expr 1>, <expr 2>, <expr n>)
******************************************************************************************************************/

/******************************************************************************************************************
	NULL

	0. A logical expression involving a missing, NULL, value evaluates to UNKNOWN.

	1. The correct definition of the treatment SQL has for query filters is "accept TRUE", meaning reject FALSE and 
	UNKNOWN. In CHECK constraints the treatment is "reject FALSE" meaning accept TRUE and UNKNOWN.

	2. The negation of UNKOWN is UNKNOWN.

	3. NULL = NULL evaluates to UNKNOWN. Use the predicates IS NULL and IS NOT NULL instead of = NULL and <> NULL.
	Don't use the predicate ' = NULL ' as it always evaluates to UNKNOWN. 

	4. For grouping and sorting two NULL marks are considered equal. GROUP BY groups all NULL marks together and the
	ORDER BY sorts all NULL marks together. T-SQL sorts NULL marks before present values. 

	5. Standard SQL treats NULL marks as different with respect to the usage of the UNIQUE constraint. T-SQL considers
	two NULL marks equal (allowing only one NULL if the constraint is defined on a single column).
******************************************************************************************************************/

/******************************************************************************************************************
	All - at - once

	0. Beware of depending on execution order within a clause. All operations are considered to be executed at once.

	1. You can force the order of operations within a CASE statement or you can rewrite the condition to exclude
	order dependent operations. 
******************************************************************************************************************/

-- the alias "orderyear" cannot be used in the same SELECT statement
SELECT 
  orderid, 
  YEAR(orderdate) AS orderyear, 
  orderyear + 1 AS nextyear
FROM Sales.Orders;


-- The order of operations in the WHERE clause is not guaranteed therefore a divide by zero error is still possible.
SELECT col1, col2
FROM dbo.T1
WHERE col1 <> 0 AND col2/col1 > 2;


-- The CASE expression guarantees order of execution and can be used as a workaround
SELECT col1, col2
FROM dbo.T1
WHERE
  CASE
    WHEN col1 = 0 THEN 'no' -- or 'yes' if row should be returned
    WHEN col2/col1 > 2 THEN 'yes'
    ELSE 'no'
  END = 'yes';


-- Redefining the WHERE clause to avoid the error prone calculation altogether
SELECT col1, col2
FROM dbo.T1
WHERE (col1 > 0 AND col2 > 2*col1) OR (col1 < 0 AND col2 < 2*col1); 

/******************************************************************************************************************
	CHARACTER DATA TYPES

	O. SQL Server supports two character data types: regular and unicode.

	1. Regular data types include CHAR and VARCHAR, Unicode includes NCHAR and NVARCHAR. NCHAR and NVARCHAR
	are specified with a leading N like N'foo'. N stands for National. Unicode is suitable for character data
	stored in multiple languages. 

	2. Regular data types require one byte of storage for each character, Unicode two bytes unless a surrogate
	pair is needed, in which four bytes are used.

	3. CHAR and NCHAR columns have fixed sizes according to their definition. CHAR(25) preserves space for 25 
	characters. VARCHAR(25) defines a column of max size 25 but the space allocated depends on the length of 
	what is stored. 

	4. In standard SQL, single quotes are used to delimit literal character strings (for example 'literal')
	and double quotes are used to delimit irregular identifiers such as table or column names that include a
	space or start with a digit (for example "Irregular Identifier"). In SQL Server, there's a setting called
	QUOTED_IDENTIFIER that controls the meaning of double quotes. You can apply this setting either at the database
	level by using the ALTER DATABASE command or at the session level by using the SET command. When the setting is
	on, the behavior is according to standard SQL, meaning that double quotes are used to delimit identifiers. 
	When the setting is off the behavior is nonstandard and double quotes are used to delimit literal character
	strings. Most database interfaces, including OLEDB and ODBC, turn this setting on by default. SQL server
	also supports square brackets for irregular identifiers (for example [Irregular Identifier]). 

	5. If you want to specify a single quote character inside a literal string delimited by single quotes you must
	use two single quotes (for example 'Richard''s spaceship is purple')
******************************************************************************************************************/

/******************************************************************************************************************
	Collation

	0. A property of character data that encapsulates several aspects, including language support, sort order, 
	case sensitivity, accent sensitivity, and more. 

	1. The database collation determines the collation of the metadata of objects in the database and is used
	as the default for user table columns. If the database collation is case insensitive, you can't crete two
	tables called T1 and t1 within the same schema, but if the database is case sensitive you can. 

	2. You can specify the collation for a column as part of its definition. If you don't the database collation
	is used by default. 

	3. You can convert the collation of an expression by using the COLLATE clause. In a case-insensitive environment
	you can return a case sensitive comparison query. 
******************************************************************************************************************/

SELECT name, description
FROM sys.fn_helpcollations();

-- the lastname column's collation is case insensitive. Returns one row. 
SELECT empid, firstname, lastname
FROM HR.Employees
WHERE lastname = N'davis';

-- making the query case sensitive using COLLATE. Returns no rows. 
SELECT empid, firstname, lastname
FROM HR.Employees
WHERE lastname COLLATE Latin1_General_CS_AS = N'davis';

/******************************************************************************************************************
OPERATORS AND FUNCTIONS (CHARACTER DATA)

	0. FUNCTIONS:
		- CONCAT
		- SUBSTRING
		- LEFT
		- RIGHT
		- LEN
		- DATALENGTH
		- CHARINDEX
		- PATINDEX
		- REPLACE
		- REPLICATE
		- STUFF
		- UPPER
		- LOWER
		- RTRIM, LTRIM
		- FORMAT

	1. You can use the "+" to concantenate strings together. Standard SQL specifies that concantenation with a 
	NULL results in a NULL. This is true in SQL Server. You can treat NULL as an empty string using the COALESCE
	function. This functions takes a list of inputs and returns the first that is not NULL. 

	2. CONCAT accepts a list of inputs and concatenates them. CONCAT automatically substitues NULL marks with 
	empty strings. (2012 only)
******************************************************************************************************************/

-- Concatenation
SELECT empid, firstname + N' ' + lastname AS fullname
FROM HR.Employees;

-- Listing 2-7: Query Demonstrating String Concatenation
SELECT custid, country, region, city,
  country + N',' + region + N',' + city AS location
FROM Sales.Customers;

-- convert NULL to empty string
SELECT custid, country, region, city,
  country + COALESCE( N',' + region, N'') + N',' + city AS location
FROM Sales.Customers;

-- using CONCAT (2012-only)
SELECT custid, country, region, city,
  CONCAT(country, N',' + region, N',' + city) AS location
FROM Sales.Customers;

/******************************************************************************************************************
	3. SUBSTRING extracts a substring from a string. SUBSTRING(string, start, length)
	index is "1" based. If the value of the length parameter exceeds the length of the string the function returns
	all characters to the end of the string without raising an error. 
******************************************************************************************************************/

SELECT SUBSTRING('abcde', 1, 3); -- returns 'abc'

/******************************************************************************************************************
	4. LEFT and RIGHT are abbreviations of the SUBSTRING function, returning a requested number of characters
	from the left or right end of the input string. 
******************************************************************************************************************/

SELECT RIGHT('abcde', 3); -- returns 'cde'
SELECT LEFT('abcde', 3); -- returns 'abc'

/******************************************************************************************************************
	5. LEN and DATALENTH
		a. LEN returns the number of characters in the input string. LEN(string)
		
		b. DATALENTH returns the number of bytes of storage for a string. For regular strings both LEN and DATALENGTH
		return the same number. For Unicode characters LEN is 1/2 the number of bytes. LEN also excludes trailing
		whitespace while DATALENGTH does not. 
******************************************************************************************************************/
SELECT LEN(N'abcde'); --returns 5
SELECT DATALENGTH(N'abcde'); -- returns 10

/******************************************************************************************************************
	6. CHARINDEX returns the position of the first occurrence of a substring within a string.
	CHARINDEX(substring, string, [start_pos]). You can optionally specify a third argument "start_pos" which is 
	the location to start looking. If you don't specify a start position it starts looking from the beginning of 
	the string. If the substring is not found it returns 0.
******************************************************************************************************************/
SELECT CHARINDEX(' ','Itzik Ben-Gan'); -- returns 6
SELECT CHARINDEX(' ','Itzik Ben-Gan', 7); -- returns 0


/******************************************************************************************************************
	7. PATINDEX returns the first occurrence of a pattern within a string. 	PATINDEX(pattern, string)
	The argument "pattern" uses similar patterns to those used by the LIKE predicate in T-SQL
******************************************************************************************************************/
SELECT PATINDEX('%[0-9]%', 'abcd123efgh'); -- 5


/******************************************************************************************************************
	8. The REPLACE function replaces all occurrences of a substring with another.  
	REPLACE(string, substring1, substring2)
******************************************************************************************************************/
SELECT REPLACE('1-a 2-b', '-', ':'); -- '1:a 2:b'

-- Using REPLACE to count the number of occurrences of a substring
-- Replace the substring with an empty string and calculate the difference in length.
SELECT empid, lastname,
	LEN(lastname) - LEN(REPLACE(lastname, 'e', '')) AS numoccur
FROM HR.Employees;


/******************************************************************************************************************
	9. REPLICATE replicates a string a requested number of times. REPLICATE(string, n)
******************************************************************************************************************/
SELECT REPLICATE('abc', 3); -- 'abcabcabc'

-- Cool, but not necessary, use of RIGHT, REPLICATE, and CAST to pad a value with 0's 
SELECT supplierid,
  RIGHT(REPLICATE('0', 9) + CAST(supplierid AS VARCHAR(10)),
        10) AS strsupplierid
FROM Production.Suppliers;

/******************************************************************************************************************
	10. STUFF removes a substring from a string and insert a new substring instead. 
	STUFF(string, pos, delete_length, insertString); Pass a delete length of 0 to not delete and insert only.
******************************************************************************************************************/
SELECT STUFF('xyz', 2, 1, 'abc'); -- 'xabcz'

/******************************************************************************************************************
	11. UPPER and LOWER return the input string with all uppercase or lowercase characters.

	12. RTRIM and LTRIM return the input string with leading or trailing spaces removed. Use result of one as the
	argument to the other to trim both sides together. 
******************************************************************************************************************/

/******************************************************************************************************************
	13. FORMAT formats an input value as a character string based on a .NET format string and an optional culture.
	FORMAT(input, format_string, culture) examples: https://msdn.microsoft.com/library/26etazsy.aspx
******************************************************************************************************************/
-- padding with 10 0's like earlier example using RIGHT, REPLICATE, and CAST
SELECT FORMAT(1759, '0000000000'); -- '0000001759'
SELECT FORMAT(1759, 'd10');        -- '0000001759'

/******************************************************************************************************************
	14. The LIKE Predicate - check whether a string matches a pattern.
		Wildcards:
		'%'       Percent wildcard --matches a string of any size, including an empty string
		
		'_'       Underscore wildcard -- matches a single character
		
		'[A,B,C]' Square brackets wildcard -- matches a single character that is a member of the list in brackets.
		
		'[A-Z]'   Square brackets range wildcard -- matches a single character that is within the specified range.
		
		'[^A-M]'   Square brackets carrot wildcard -- matches a single character that is NOT within the 
					specified range.
******************************************************************************************************************/

-- Last name starts with D
SELECT empid, lastname
FROM HR.Employees
WHERE lastname LIKE N'D%';

-- Second character in last name is e
SELECT empid, lastname
FROM HR.Employees
WHERE lastname LIKE N'_e%';

-- First character in last name is A, B or C
SELECT empid, lastname
FROM HR.Employees
WHERE lastname LIKE N'[ABC]%';

-- First character in last name is A through E
SELECT empid, lastname
FROM HR.Employees
WHERE lastname LIKE N'[A-E]%';

-- First character in last name is not A through E
SELECT empid, lastname
FROM HR.Employees
WHERE lastname LIKE N'[^A-E]%';

-- First character in last name is not A through E
SELECT empid, lastname
FROM HR.Employees
WHERE lastname LIKE N'[^A,B,C,D,E]%';

/******************************************************************************************************************
	ESCAPE -- keyword used to escape characters that are also wildcards. After the patter use the keyword ESCAPE
	followed by the single character (which you know is not in the text) you want to use as an escape character.
		col1 LIKE '%!_%' ESCAPE '!'
	You can also use square brackets to escape the wildcard. col1 LIKE '%[_]%'
******************************************************************************************************************/