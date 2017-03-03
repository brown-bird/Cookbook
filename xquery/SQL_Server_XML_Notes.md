# SQL Server XML Notes

### XML Type Methods

Methods available on XML instances.

**query()** Returns untyped xml.

**value()** Returns scalar value cast to a SQL Server type.

**exist()** Returns a SQL bit value of 1 if the XQuery returns a result, 0 if there XQuery returns no result, or NULL if the xml instance is NULL.

**modify()** Can only be used with the SET clause. Execute XML Data Manipulation Language statements against xml.

**nodes()** Shred xml instances. Convert xml data into relational form.

### Comparators

#### Value Comparison Operators

compare singleton atomic values to one another

#### General Comparision Operators

"existential operators", Return true if any of the singleton atomic values from the sequence on the left-hand side of the operator fulfills the operator comparison with any of the singleton atomic values from the right-hand sequence

`(1, 2, 3) = (3, 4, 5)` returns true!

`(3, 4, 5) < (1, 2, 3)` returns false!

`(3, 4, 5, 0) < (1, 2, 3)` returns true!

#### Node Comparison Operators
