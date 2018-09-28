var controllersModule = angular.module("controllersModule", []);

controllersModule.constant("restApiContextPath", "/triangle");

controllersModule.controller("mainController", function ($scope, $http, restApiContextPath) {

    var EVALUATE_TYPE_URL = "/type/evaluate?";
    var QUERY_PARAM_SEPARATOR = "&";

    $scope.init = function () {
        $scope.triangleSides = {};
        $scope.initOutcome();
    };

    $scope.initOutcome = function() {
        $scope.successOutcome = false;
        $scope.errorOutcome = false;
    };

    $scope.evaluateTriangle = function (triangleSides) {

        $scope.initOutcome();

        var resourceUrl = EVALUATE_TYPE_URL
            + "a=" + triangleSides.a + QUERY_PARAM_SEPARATOR
            + "b=" + triangleSides.b + QUERY_PARAM_SEPARATOR
            + "c=" + triangleSides.c;

        $http.get(restApiContextPath + resourceUrl).then(
            function successCallback(response) {
                $scope.outcomeMessage = response.data.description;
                $scope.successOutcome = true;
            },
            function errorCallback() {
                $scope.errorOutcome = true;
            }
        );
    };

    $scope.clear = function () {
        $scope.init();
    };

    $scope.init();
});