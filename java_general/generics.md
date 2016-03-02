#Generics

**Problem:** You don't care about the types contained in a collection to do some work with that collection. 

**Solution:** Use an *unbounded wildcard*. Unbounded wildcards use a "?" as the type parameter. 

	public void doWork(List<?> listOfSomeElements){
		// do some work with the list that doesn't care about the type
		...
		
**Note:** You cannot insert elements into a `Collection<?>`, other than null. You will get a compile time error. 	