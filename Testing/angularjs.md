# AngularJS Testing

### Working with globally scoped controllers

#### Creating a controller

You can create a globally scoped controller via the `new` keyword. 

	var ctrl = new AwesomeController(scope);
	
### Working with non-globally scoped controllers

**Problem:** You need a reference to non-globally scoped controller that has been registerd with your app's module. 

**Solution:** Use the `$controller` service to get a reference.

	it('should give me a controller', inject(function($controller) {
	
		var scope = {},
		var ctrl = $controller('AwesomeController', {$scope:scope});
	}));

**Note** the use of the `inject` function to inject the needed $controller service. Then we ask for the controller by name passing it a scope object. It will also be necessary to load the appropriate module before the test. 

	beforeEach(module('baconApp'));

