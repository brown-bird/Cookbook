# Code Smells 

#### Comments
High level javadoc style comments which describe the **(single!)** purpose of a class or method are not bad and may even be desireable when the class or method name itself does not describe the purpose well enough. 

Another good use of comments is to explain **why** you did something or to document something you are *unsure* about. Excessive comments throughout the code can indicate the presence of bad code. 

**Solution:** Use *Extract Method* with a good descriptive name to replace commented block of code. If a comment still seems necessary consider *Rename Method*. If a comment serves to document a required state use and exception or try *Introduce Assertion*. 