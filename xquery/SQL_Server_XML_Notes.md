# SQL Server XML Notes

### XML Type Methods

Methods available on XML instances.

**query()** Returns untyped xml.

**value()** Returns scalar value cast to a SQL Server type.

**exist()** Returns a SQL bit value of 1 if the XQuery returns a result, 0 if there XQuery returns no result, or NULL if the xml instance is NULL.

**modify()** Can only be used with the SET clause. Execute XML Data Manipulation Language statements against xml.

**nodes()** Shred xml instances. Convert xml data into relational form.