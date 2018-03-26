<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>

<div class="container">
    <ul class="pager">
        <li class="previous"><a href="/">Back</a></li>

    </ul>
</div>
<div class="container">
    <br>
<#if model.error == true>
<div class="alert alert-warning">
    <strong>Warning!</strong> Неверно введен login или пароль!
</div>

</#if>

    <form class="form-horizontal"
          title="Вход"
          name="RegistrationForm"
          method="post"
          action="/login">
        <div class="form-group">
            <label class="control-label col-sm-2" for="text">Login:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="login" placeholder="Enter login" name="login">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="pwd">Password:</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <div class="checkbox">
                    <label><input type="checkbox" name="remember-me"> Remember me</label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Submit</button>
                <a href="/registration">
                    <button class="btn btn-default" type="button">Sign via GitHub</button>
                </a>
            </div>
        </div>
    </form>
</div>

</body>
</html>

