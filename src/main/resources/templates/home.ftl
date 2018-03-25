<!doctype html>
<html lang="en" ng-app="triangleApp">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/lib/bootstrap.min.css">

    <title>Triangle</title>
</head>
<body ng-controller="mainController">
    <div id="main_container" class="container-fluid">

        <div class="jumbotron">
            <h1 class="display-4">${title}</h1>
            <p class="lead">${infoMessage}</p>
            <hr class="my-4">
            <p>${promptMessage}</p>

            <#--Input Section-->
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="input-group-text-1">side a</span>
                </div>
                <input type="text" class="form-control" id="side_1" aria-describedby="input-group-text-1" ng-model="triangleSides.side_a">

                <div class="input-group-prepend">
                    <span class="input-group-text" id="input-group-text-2">side b</span>
                </div>
                <input type="text" class="form-control" id="side_2" aria-describedby="input-group-text-2" ng-model="triangleSides.side_b">

                <div class="input-group-prepend">
                    <span class="input-group-text" id="input-group-text-3">side c</span>
                </div>
                <input type="text" class="form-control" id="side_3" aria-describedby="input-group-text-3" ng-model="triangleSides.side_c">
            </div>

            <#--Button Section-->
            <p class="lead">
                <button type="button" class="btn btn-primary btn-lg" ng-click="evaluateTriangle(triangleSides)">${btnEvaluateMessage}</button>
                <button type="button" class="btn btn-danger btn-lg" ng-click="clear()">${btnClearMessage}</button>
            </p>
            <p class="lead">
            </p>

            <#--Outcome Section-->
            <div class="alert" role="alert" ng-class="outcomeClass" ng-show="showOutcome">
                {{outcomeMessage}}
            </div>

        </div>

    </div>

<#--Import JS files-->
<script src="js/lib/angular.min.js"></script>
<script src="js/app/app.js"></script>
</body>
</html>