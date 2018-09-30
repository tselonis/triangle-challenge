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
            <h1 class="display-4"><@spring.message "welcome.message"/></h1>
            <p class="lead"><@spring.message "info.message"/></p>
            <hr class="my-4">
            <p><@spring.message "prompt.message"/></p>

            <#--Input Section-->
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="input-group-text-1"><@spring.message "side.a.text"/></span>
                </div>
                <input type="number" class="form-control" id="side_1" aria-describedby="input-group-text-1" ng-model="triangleSides.a">

                <div class="input-group-prepend">
                    <span class="input-group-text" id="input-group-text-2"><@spring.message "side.b.text"/></span>
                </div>
                <input type="number" class="form-control" id="side_2" aria-describedby="input-group-text-2" ng-model="triangleSides.b">

                <div class="input-group-prepend">
                    <span class="input-group-text" id="input-group-text-3"><@spring.message "side.c.text"/></span>
                </div>
                <input type="number" class="form-control" id="side_3" aria-describedby="input-group-text-3" ng-model="triangleSides.c">
            </div>

            <#--Button Section-->
            <p class="lead">
                <button type="button" class="btn btn-primary btn-lg" ng-click="evaluateTriangle(triangleSides)"><@spring.message "btn.evaluate"/></button>
                <button type="button" class="btn btn-danger btn-lg" ng-click="clear()"><@spring.message "btn.clear"/></button>
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