#Angularjs Recipes

* Redirecting to an error page
* Show data only when a value is present
* Mocking Services
* Bootstrap an angular app
* Bind values to models
* Duplicate HTML Elements
* Chaining Operations in Data Binding Expressions
* Filter a list based on user input
* Bind a scope to a section of html

<br>
<br>
## Terms

* **$scope** - The *view model*. It is the glue between the controller and the view.

<br>
<br>
## Redirecting to an Error Page


**Problem:** You want to redirect to an error page. 

**Solution:** Define an `$exceptionHandler` service. Avoid a cycliomatic dependency error `$location <- $exceptionHandler <- $rootScope` by injecting `$location` directly. 

~~~js
.factory('$exceptionHandler', function($injector) {
 	var $location;
 	return function(exception, cause) {
 		$location = $location || $injector.get('$location');
 		$location.path('/error');
 	};
});

~~~

<br>
<br>
## Show Element Only When Data Is Present

**Problem:** You want to show an render an html element only when there is a value defined in the backing model. 

**Solution:** Use `ng-show` directive

~~~html
<input ng-model='user.name'>
<p ng-show='user.name'>Hi {{user.name}}</p>
~~~

<br>
<br>
## Bootstraping Your App
	
**Problem:** How to configure the main page of your angular app.

**Solution:**	 Add `ng-app='yourAppModule'` to the head tag of your app. e.g. `<html ng-app='AwesomeBaconApp'>`

<br>
<br>
## Bind Values to Models	

**Problem:** You want to bind an html element, like an input field or label, to a angularjs backed model.

**Solution:** Use the directive `ng-model="modelName"` as an attribute in the tag. Then use a **data binding expression** to grab the value from the model. 

~~~html
<div>
	Name: <input type='text' ng-model='name' /> {{ name }}
</div>
~~~

The data binding expression is denoted using double curly brackets `{{ expression }}`
	
	
	
<br>
<br>
## Duplicate HTML Elements

**Problem:** You want to duplicate html elements one per element in a collection. 

**Solution:** Use the directive `ng-repeat`. 

~~~html
<li ng-repeat='name in names'>{{ name }}</li>
~~~

<br>
<br>
## Chaining Operations in Data Binding Expressions

**Problem:** You want to chain operations together in a data binding expression.

**Solution:** Use the **pipe** operator `|`

~~~html
<ul>
	<li ng-repeat="cust in customers | orderBy:'name'">
		{{ cust.name | uppercase }}
	</li>
</ul>
~~~

**note:** `uppercase` is an angular filter

## Filter a list based on user input

**Problem:**	You want to filter a list based on user input.

**Solution:** First, bind the input field to a model 

	<input ng-model='name'/>

Then, apply a filter to the list based on the value defined in the model property created in step 1. 

	<ul>
		<li ng-repeat='cust in customers | filter:name'>{{cust.name }} - {{cust.city}} </li>	
<br>
<br>
## Bind a scope to a section of html

**Problem:** You want to bind a view and a controller with a scope. 

**Solution:** Define the controller to use in the html. Define the controller in js and declare the `$scope` as a dependency to be injected. 

~~~html
<html ngApp='myApp'>

<div ng-controller='SimpleController'>
	<h3> Adding a simple controller </h3>
	<ul>
		<li ng-repeat='car in paddock'>
			{{ car.driver.startEngine() }}
		</li>
	</ul>
</div>
~~~
With the controller defined as:

~~~js
var myApp = angular.module('myApp', []);

myApp.controller('SimpleController', SimpleController);

function SimpleController($scope) {
	$scope.paddock = getCarList();
}
~~~

<br>
<br>
## Define a module

**Problem:** How to define a module

**Solution:** Use `angular.module('modulename', ['array', 'of', 'dependenciesForModule']);` You can declare other modules as dependencies within the array of the second argument to `angular.module`/ This allows you to define multiple modules and compose them as dependencies. 
