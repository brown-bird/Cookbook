var helloWorld = angular.module('helloWorld', []);
helloWorld.controller('HelloController', ['$scope',
    function($scope){
    $scope.greeting = {text: 'Hello'};
}]);
