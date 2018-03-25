var module = angular.module("controllers", []);
module.constant("restApiContextPath", "/triangle");

module.controller("mainController", function($scope, $http, restApiContextPath){

    var evaluateTypeUrl = "/type/evaluate?";
    var queryParamSeparator = "&";

    $scope.evaluateTriangle = function(side_a, side_b, side_c) {
        var resourceUrl = evaluateTypeUrl
            + "a=" + side_a + queryParamSeparator
            + "b=" + side_b + queryParamSeparator
            + "c=" + side_c;

        // $http.get(restApiContextPath + resourceUrl).success(function(response){
        //     })
        //     .error(function(response){
        //
        //     });
        $http.get(restApiContextPath + resourceUrl).then(
            function successCallback(response){
                $scope.outcomeClass = response.triangle ? "alert-success" : "alert-danger";
                $scope.triangleType = response.description;
            },
            function errorCallback(response){

            }
            );

        $scope.outcomeClass = side_a > side_b ? "alert-success" : "alert-danger";
    };
});