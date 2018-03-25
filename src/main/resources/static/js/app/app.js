var triangleApp = angular.module("triangleApp", []);

triangleApp.constant("restApiContextPath", "/triangle");

triangleApp.controller("mainController", function ($scope, $http, restApiContextPath) {

    var EVALUATE_TYPE_URL = "/type/evaluate?";
    var QUERY_PARAM_SEPARATOR = "&";
    var CSS_CLASS_SUCCESS = "alert-success";
    var CSS_CLASS_INFO = "alert-info";
    var CSS_CLASS_DANGER = "alert-danger";

    $scope.init = function () {
        $scope.triangleSides = {};
        $scope.showOutcome = false;
    };

    $scope.evaluateTriangle = function (triangleSides) {

        $scope.showOutcome = false;

        var resourceUrl = EVALUATE_TYPE_URL
            + "a=" + triangleSides.side_a + QUERY_PARAM_SEPARATOR
            + "b=" + triangleSides.side_b + QUERY_PARAM_SEPARATOR
            + "c=" + triangleSides.side_c;

        $http.get(restApiContextPath + resourceUrl).then(
            function successCallback(response) {
                $scope.showOutcome = true;
                $scope.outcomeClass = response.data.triangle ? CSS_CLASS_SUCCESS : CSS_CLASS_INFO;
                $scope.outcomeMessage = response.data.description;
            },
            function errorCallback(response) {
                $scope.showOutcome = true;
                $scope.outcomeClass = CSS_CLASS_DANGER;
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