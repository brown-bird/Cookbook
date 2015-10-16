# Test Smells

* System (functional, component, integration, etc.) test failing but no unit test failing
This indicates a missing unit test. Unit tests provide defect localization or the ability to zoom
in on the problem area in a way that higher level tests don't. 
