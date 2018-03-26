<!doctype html>
<html lang="en" ng-app="triangleApp">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/lib/bootstrap.min.css">

    <title><@spring.message "title"/></title>
</head>
<body ng-controller="mainController">
    <div id="main_container" class="container-fluid">

        <div class="jumbotron">
            <h1 class="display-4"><@spring.message "welcomeMessage"/></h1>
            <p class="lead"><@spring.message "infoMessage"/></p>
            <hr class="my-4">
            <p><@spring.message "promptMessage"/></p>

            <#--Input Section-->
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="input-group-text-1"><@spring.message "sideAText"/></span>
                </div>
                <input type="text" class="form-control" id="side_1" aria-describedby="input-group-text-1" ng-model="triangleSides.side_a">

                <div class="input-group-prepend">
                    <span class="input-group-text" id="input-group-text-2"><@spring.message "sideBText"/></span>
                </div>
                <input type="text" class="form-control" id="side_2" aria-describedby="input-group-text-2" ng-model="triangleSides.side_b">

                <div class="input-group-prepend">
                    <span class="input-group-text" id="input-group-text-3"><@spring.message "sideCText"/></span>
                </div>
                <input type="text" class="form-control" id="side_3" aria-describedby="input-group-text-3" ng-model="triangleSides.side_c">
            </div>

            <#--Button Section-->
            <p class="lead">
                <button type="button" class="btn btn-primary btn-lg" ng-click="evaluateTriangle(triangleSides)"><@spring.message "btnEvaluateMessage"/></button>
                <button type="button" class="btn btn-danger btn-lg" ng-click="clear()"><@spring.message "btnClearMessage"/></button>
            </p>

            <#--Outcome Section-->
            <div class="alert alert-success" role="alert" ng-show="successOutcome">
                {{outcomeMessage}}
            </div>

        <#--Error Section-->
            <div class="alert alert-danger" role="alert" ng-show="errorOutcome">
                <@spring.message "positive.integers.message"/>
            </div>


        </div>

    </div>

    <#--Import JS files-->
    <script src="js/lib/angular.min.js"></script>
    <script src="js/app/modules/controllers.js"></script>
    <script src="js/app/app.js"></script>
</body>
</html>