# Lambda Re-use

#### Problem

Multiple lambdas are similar save for components which could be parameterized. 

#### Solution

Define a higher order function that returns a lambda constructed in  part by a passed in parameter. 