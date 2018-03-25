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

        <#-- Input side lengths-->
            <#--<div class="input-group mb-3">-->
                <#--<div class="input-group-prepend">-->
                    <#--<span class="input-group-text" id="input-group-text-1">side a</span>-->
                <#--</div>-->
                <#--<input type="text" class="form-control" id="side_1" aria-describedby="input-group-text-1" ng-model="side_a">-->
            <#--</div>-->

            <#--<div class="input-group mb-3">-->
                <#--<div class="input-group-prepend">-->
                    <#--<span class="input-group-text" id="input-group-text-2">side b</span>-->
                <#--</div>-->
                <#--<input type="text" class="form-control" id="side_2" aria-describedby="input-group-text-2" ng-model="side_b">-->
            <#--</div>-->

            <#--<div class="input-group mb-3">-->
                <#--<div class="input-group-prepend">-->
                    <#--<span class="input-group-text" id="input-group-text-3">side c</span>-->
                <#--</div>-->
                <#--<input type="text" class="form-control" id="side_3" aria-describedby="input-group-text-3" ng-model="side_c">-->
            <#--</div>-->
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

        <#--Evaluate btn-->
            <p class="lead">
                <button type="button" class="btn btn-primary btn-lg" ng-click="evaluateTriangle(triangleSides)">${btnEvaluateMessage}</button>
                <button type="button" class="btn btn-danger btn-lg" ng-click="clear()">${btnClearMessage}</button>
            </p>
            <p class="lead">
            </p>
    <#--TO BE REMOVED -->

            <div class="alert" role="alert" ng-class="outcomeClass" ng-show="showOutcome">
                {{outcomeMessage}}
            </div>

            {{side_a}}
            {{side_b}}
            {{side_c}}

        </div>

    </div>

<#--Import JS files-->
<script src="js/lib/angular.min.js"></script>
<script src="js/app/app.js"></script>
<#--<script src="js/app/controllers/controllers.js"></script>-->
</body>
</html>