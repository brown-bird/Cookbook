# Test If A Binary Tree Is Height Balanced

A binary tree is said to be height balanced if for each node in the tree, the difference in the height of its left and right subtrees is at most one. 

Write a program that takes as input the root of a binary tree and checks whether the tree is height-balanced.

### Solution

Use **post order traversal** along with storing the height and whether the tree is balanced or not. Time complexity = **O(n)** and space complexity = **O(h)** where h = the height of the tree.

~~~java

// the pojo to store info about the tree
private static class BalancedStatusWithHeight
{
    public boolean balanced;
    public int height;

    public BalancedStatusWithHeight(boolean balanced, int height)
    {
        this.balanced = balanced;
        this.height = height;
    }
}

// the entry point method
public static boolean isBalanced(BinaryTreeNode<Integer> tree)
{
    return checkBalanced(tree).balanced;
}

private static BalancedStatusWithHeight checkBalanced(BinaryTreeNode<Integer> tree)
{
    if (tree == null)
    {
        return new BalancedStatusWithHeight(true, -1);
    }

    BalancedStatusWithHeight leftResult = checkBalanced(tree.left);
    if(!leftResult.balanced)
    {
        return leftResult;
    }

    BalancedStatusWithHeight rightResult = checkBalanced(tree.right);
    if(!rightResult.balanced)
    {
        return rightResult;
    }

    Boolean isBalanced = Math.abs(leftResult.height - rightResult.height) <= 1;
    int height = Math.max(leftResult.height, rightResult.height) + 1;
    return new BalancedStatusWithHeight(isBalanced, height);
}
~~~