# XQUERY

### SEQUENCE OF DEVELOPMENT

1. XPATH - path expressions + conditions
2. XSLT - XPATH  + transformations, output formatting
3. XQUERY - XPATH + full-featured Query Language


Path expressions - path down the tree

Conditions - selection criteria

## XPATH 

`/` can be root, if at the start of an expression. Can signify traversing one level down the tree. 

`*` searches all sub paths

`//` searches all sub paths of the current node. Includes current node

`@` matches an attribute name `@meat` matches the attribute meat

### Conditions

`[condition]` matches condition

`[n]` matches the nth sub-element of the current node where n is an integer

`[element_name]` specifying an element name as the **condition** is an **existance** condition in xpath. Only return elements which have a matching element name. 

### Built-in Functions

`contains(s1, s2)` returns true if the first string contains the second string as a substring

`name()` returns the tag of the current element in our path

### Navigation axes

`parent::`

`following-sibling::`

`descendents::`

`self::` matches the current element

### XPATH EXAMPLES

Get the title from each book

    doc("Bookstore.xml")/Bookstore/Book/Title
    
Get Book or magazine title

    doc("Bookstore.xml")/Bookstore/{Book|Magazine}/Title

Get the title of any element below Bookstore

    doc("Bookstore.xml")/Bookstore/*/Title

Get any title element anyhere at all in the xml tree

    doc("Bookstore.xml")//Title

Get any element in the tree of any type

    doc("Bookstore.xml")//*

Get all the isbn numbers in the database

    doc("Bookstore.xml")/Bookstore/Book/data(@ISBN)

Get books that cost < $90

    doc("Bookstore.xml")/Bookstore/Book[@Price < 90]

Get the title of the book where cost < 90

    doc("Bookstore.xml")/Bookstore/Book[@Price < 90]/Title

Get books that have a remark (existance check)

    doc("Bookstore.xml")/Bookstore/Book[Remark]/Title

Get titles of books where price < 90 and Ullman is one of the authors

    doc("Bookstore.xml")/Bookstore/Book[@Price < 90 and 
        Authors/Author/Last_Name = "Ullman"]/Title

Get titles of books where price < 90 and there exist an author whose last name is Ullman and the first name is Jeffrey

    doc("Bookstore.xml")/Bookstore/Book[@Price < 90 and 
    Authors/Author[Last_Name = "Ullman" and first_Name = "Jeffrey]]/Title

*note* no slash before square bracket at condition

Get all 2nd authors

    doc("Bookstore.xml")//Authors/Author[2]

### Built-in functions and predicates

Titles of books with a remark containing "great"

    doc("Bookstore.xml")//Book[contains(Remark, "great")]/Title

Find all magazines where there's a book with the same title. Similar to a self join.

    doc("Bookstore.xml")//Magazine[Title = doc("Bookstore.xml")//Book/Title]

Find all elements whose parent element tag is not Bookstore or Book

    doc("Bookstore")/Bookstore//*[name(parent::*) != "Bookstore"
        and name(parent::*) != "Book"]

Find all books and magazines with non-unique titles

    doc("Bookstore")//Bookstore/{Book|Magazine}[Title = 
        following-sibling::*/Title or Title = preceding-sibling::*/Title]

Find all books or magazines with the same title as some other book

    doc("Bookstore")//Bookstore/{Book|Magazine}[Title = 
        following-sibling::Book/Title or Title = preceding-sibling::Book/Title]

Find books where every author's first name includes "J"

    doc("Bookstore")//Book[
        count(Authors/Author[contains(First_Name, "J")]) = 
        count(Authors/Author/First_Name)
    ]

Get title of books where "Ullman" is an author and "Widom" is not an author

    doc("Bookstore.xml")/Bookstore/Book[
        Authors/Author/Last_Name = "Ullman" and
        count(Authors/Author[Last_Name = "Widom"]) = 0
    ]