# XQuery

Transact-SQL supports a subset of the XQuery language that is used for querying the xml data type.

[MSDN XQuery Reference](https://msdn.microsoft.com/en-us/library/ms189075(v=sql.110).aspx)
### Path Expressions

Selects elements or attributes from an input document. 

	doc("catalog.xml")/catalog/product

Returns all the product elements fromt the *catalog.xml* document. `doc` is an XQuery function which opens an file.

### XML Data type methods

You can use the xml data type methods to query an XML instance stored in a variable or column of xml type. The topics in this section describe how to use the xml data type methods.

#### query

[MSDN](https://msdn.microsoft.com/en-us/library/ms190798(v=sql.110).aspx)

#### value

[MSDN](https://msdn.microsoft.com/en-us/library/ms178030(v=sql.110).aspx)

#### exist

[MSDN](https://msdn.microsoft.com/en-us/library/ms189869(v=sql.110).aspx)

#### modify

#### nodes

The xml data type methods `query()`, `value()`, and `exist()` return `NULL` if executed against a NULL XML instance. Also, `modify()` does not return anything, but `nodes()` returns rowsets and an empty rowset with a `NULL` input.

### XML Construction

[MSDN](https://msdn.microsoft.com/en-us/library/ms189928(v=sql.110).aspx)