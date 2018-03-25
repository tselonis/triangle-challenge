var triangleApp = angular.module("triangleApp", []);

triangleApp.constant("restApiContextPath", "/triangle");

triangleApp.controller("mainController", function ($scope, $http, restApiContextPath) {

    var evaluateTypeUrl = "/type/evaluate?";
    var queryParamSeparator = "&";

    $scope.init = function () {
        $scope.triangleSides = {};
        $scope.showOutcome = false;
    };

    $scope.evaluateTriangle = function (triangleSides) {

        $scope.showOutcome = false;

        var resourceUrl = evaluateTypeUrl
            + "a=" + triangleSides.side_a + queryParamSeparator
            + "b=" + triangleSides.side_b + queryParamSeparator
            + "c=" + triangleSides.side_c;

        $http.get(restApiContextPath + resourceUrl).then(
            function successCallback(response) {
                $scope.showOutcome = true;
                $scope.outcomeClass = response.data.triangle ? "alert-success" : "alert-info";
                $scope.outcomeMessage = response.data.description;
            },
            function errorCallback(response) {
                $scope.showOutcome = true;
                $scope.outcomeClass = "alert-danger";
                if (response.status === 422) {
                    $scope.outcomeMessage = response.data.message;
                } else {
                    $scope.outcomeMessage = response.data.error + " - Provide positive integers for all the sides of the triangle.";
                }
            }
        );
    };

    $scope.clear = function () {
        $scope.init();
    };

    $scope.init();
});