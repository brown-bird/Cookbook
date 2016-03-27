# Window Functions

A *window function* is a function that, for each row, computes a scalar result value based on a calculation against a subset of the rows from the underlying query. 

### Over()
The window specification in the OVER clause has three main parts: partitioning, ordering, and framing. An empty OVER() clause exposes to the function a window made of all rows from the underlying query's result set. 

