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
<body>
<div id="main_container" class="container-fluid">

    <div class="jumbotron">
        <h1 class="display-4">${title}</h1>
        <p class="lead">${infoMessage}</p>
        <hr class="my-4">
        <p>${promptMessage}</p>

    <#-- Input side lengths-->
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="input-group-text-1">side a</span>
            </div>
            <input type="text" class="form-control" id="side_1" aria-describedby="input-group-text-1">
        </div>

        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="input-group-text-2">side b</span>
            </div>
            <input type="text" class="form-control" id="side_2" aria-describedby="input-group-text-2">
        </div>

        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="input-group-text-3">side c</span>
            </div>
            <input type="text" class="form-control" id="side_3" aria-describedby="input-group-text-3">
        </div>

    <#--Evaluate btn-->
        <p class="lead">
            <div class="btn btn-primary btn-lg">${btnMessage}</div>
        </p>
    </div>

</div>

<script src="js/lib/angular.min.js"></script>
<script src="js/app/app.js"></script>
</body>
</html>