# Fixing Duplication 

ch. 21

**Problem:** Multiple classes which do similar things contain lots of duplicated code. 

**Solution:** Pre-conditions: classes are similiar in function that they could be seen within an inheritance heirarchy. 


- Get classes under test if they are not already.
- Refactor the class to have a common super class by extracting code that is unique to each class in an overrideable method. 
- Pull common methods up into the super class. 
- Replace fields which have different values but the same name into abstract getters.
- (optional) Possibly convert more methods to a superclass method by genericing the parameters via a Collection or some other means. 

**Benefits:**

- Changes can be made in one place instead of multiple places. One knob per feature!
- Future additions to the hierarchy and simply subclass and override methods which require different implementations. 
- Special data conversions can be done via transformations in the subclass constructor. 
- Can remove this duplication without changing the clients of the code. 