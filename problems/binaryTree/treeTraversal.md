# Binary Tree Traversal

## Pre Order

~~~java
void preOrder(Tree root)
{
    if (root != null)
    {
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }
}
~~~

## In Order 

~~~java
void inOrder(Tree root)
{
    if (root != null)
    {
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }
}
~~~

## Post Order

~~~java
void postOrder(Tree root)
{
    if (root != null)
    {
        System.out.println(root.left);
        System.out.println(root.right);
        System.out.println(root.data);
    }
}
~~~