#Angularjs Recipes

* Redirecting to an error page
* Show data only when a value is present

</br>
## Redirecting to an Error Page


**Problem:** You want to redirect to an error page. 

**Solution:** Define an $exceptionHandler service. Avoid a cycliomatic dependency error `$location <- $exceptionHandler <- $rootScope` by injecting `$location` directly. 

~~~java
.factory('$exceptionHandler', function($injector) {
 	var $location;
 	return function(exception, cause) {
 		$location = $location || $injector.get('$location');
 		$location.path('/error');
 	};
});

~~~


</br>
## Show Element Only When Data Is Present

**Problem:** You want to show an render an html element only when there is a value defined in the backing model. 

**Solution:** Use `ng-show` directive

~~~html
<input ng-model='user.name'>
<p ng-show='user.name'>Hi {{user.name}}</p>
~~~
	
	
	
	
	
	
	