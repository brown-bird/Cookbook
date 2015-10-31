# AngularJS Fundamentals in 60-ish minutes

#### Directives
Directives are used for data binding. `ng-<something>` denotes an angular directive.
  
    <html `ng-app`> 

Denotes that this page is an angular app. 

    Name: <input type="text" ng-model="name" /> {{name}}
    
Above `ng-model` defines a view model named **name**. The expression `{{name}}` 
is a data binding expression that binds the value of the input tag here with the 
value in the *name* view model. You can not put conditional logic into the expression. 

You can initialize some data with the `ng-init="<some javascript here>"` directive. Not often used in production apps.

    <body ng-init="names=['bob jones', 'jane doe', 'john smith']">
You can repeat html elements based on some criteria using `ng-repeat` directives.

    <li ng-repeat="name in names">{{name}}</li>

This will repeat an `li` tag for each name in the names collection that was defined previously.

#### Filters

Filters in AngularJS has filters which can be used with the `|` character followed by some filter keywords and criteria.

    <li ng-repeat="cust in customer | filter:name | orderBy: 'city'">{{cust.name}} - {{cust.city}}</li>
    
You can also apply filters inside of binding expressions.

    <li ng-repeat="cust in customer | filter:name | orderBy: 'city'">{{cust.name | uppercase}} - {{cust.city | lowercase}}</li>
    
### View, Controllers, and Scope

#### Controller

Controls what data goes where. i.e. data that needs to go the *view* or data that needs to go to a *service*. The `$scope` is the scope object ties the controller to the view. `$scope` is the "glue" (ViewModel) between a controller and a view. You can use `ng-controller="MyControllerName"` to bind a controller to a specific part of the page in which the `$scope` would be used as the model passed into the controller and would hold all of the data attributes, etc.

### Modules, Routes and Factories

#### Module

A *Module* is a container for all the things. *(see module diagrams)* A *Module* can contain a config function which can be used to define different *routes*. When you define a *Route* you can define a *View* and a *Controller*. *Controllers* would call out to *Factories, Services, Resources, or data...*. 

Modules can be used in `ng-app="moduleName"`. Modules can be created like:

~~~js
var demoApp = angular.module('demoApp', []);
~~~

The empty brackets `[]` are used for dependency injections when your module depends on other modules such as:

~~~js
var demoApp = angular.module('demoApp', ['helperModule']);
~~~

#### Creating a Controller in a module:

Preferred way to create a controller in Angularjs:

~~~js
// define a module
var demoApp = angular.module('demoApp', []);

// define a controller
demoApp.controller('SimpleController', function ($scope) {
    $scope.customers = [
        {name: 'Dave Jones', city: 'Phoenix'},
        {name: 'Jamie Riley', city: 'Atlanta'},
        {name: 'James Brown', city: 'Atlanta'}
    ];
});