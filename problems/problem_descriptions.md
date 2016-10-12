# Problems

## Array Equilibrium

The equilibrium point of an array is the index in the array where the sum of all the elements left of the equilibrium point equal the sum of all the elements to the right of the equilibrium point.

## Dutch Flag Partition

Given an array and a pivot index into the array, re-organize the elements in the array so that elements less than the pivot appear first followed by elements equal to the pivot followed by elements greater than the pivot.

## Buy and Sell a Stock Once

Design an algorithm that determines the maximum profit that could have been made my buying and selling a single share over a given day range, subject to the constraint that the buy and the sell have to take place at the start of the day.

## Integer Square Root

Write a program which takes a non-negative integer and returns the largest integer whose square is less than or equal to the input integer.

## Stack with Max

Implement a stack with push, pop, and max api

## Integer is Palindrome

Write a function which determines if a word is an palindrome

## String Integer Interconversion

Write two functions, one to convert an integer to a string and another to convert a string to an integer. You may not use library functions such as Integer.parseInt. The programs should handle negative numbers.


## Search a sorted array for the first occurrence of an integer k

Brute force #1: Walk the array stopping on the first occurrence of k. O(n)

Brute force #2: Binary search to find the first occurrence of k, then walk backwards to find the first occurrence. O(n) when the entire array contains k. 

Optimized Binary Search: Use Binary search to process the entire array, updating the first occurrence variable with the index of mid every time mid is equal to k. Stop when left and right indexes cross. 

