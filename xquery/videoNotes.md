# XQUERY

### SEQUENCE OF DEVELOPMENT

1. XPATH - path expressions + conditions
2. XSLT - XPATH  + transformations, output formatting
3. XQUERY - XPATH + full-featured Query Language


Path expressions - path down the tree

Conditions - selection criteria

### XPATH 

`/` can be root, if at the start of an expression. Can signify traversing one level down the tree. 

`*` searches all sub paths

`//` searches all sub paths of the current node. Includes current node

### Conditions

`[condition]` matches condition

`[n]` matches the nth sub-element of the current node

`[element_name]` specifying an element name as the **condition** is an **existance** condition in xpath. Only return elements which have a matching element name. 