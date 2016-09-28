# Binary Trees

A **binary tree** is a data structure that is useful for representing hierarchy. Formally, a binary tree is either empty or a root node r together with a left binary tree and a right binary tree. The subtrees themselves are binary trees.

A node that has no descendants except for itself is called a **leaf**.

The **depth** of a node n is the number of nodes on the search path from the root to n, not including n itself.

The **height** of a binary tree is the maximum depth of any node in that tree. 

A **level** of a tree is all nodes at the same depth. 

A **full binary tree** is a binary tree in which every node other than the leaves has two children. 

A **perfect binary tree** is a full binary tree in which all the leaves are at the same depth, and in which every parent has two children.  

A **complete binary tree** is a full binary tree in which all leaves are at the same depth, and in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible. (This terminology is not universal, some swap the definitions of perfect and complete binary trees.) 

A **left skewed binary tree** is a tree in which no node has a right child. A **right skewed binary tree** is a tree in which no node has a left child.