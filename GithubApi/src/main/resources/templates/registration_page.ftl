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
    <br>
    <h3 align="center">Registration</h3>
    <br>

    <form class="form-horizontal"
          title="Registration"
          name="RegistrationForm"
          method="post"
          action="/registration">
        <div class="form-group">
            <label class="control-label col-sm-2" for="text">GitHub Login:</label>
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
                <button type="submit" class="btn btn-default">Sign in</button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Already have an account?

                 <a href="/login">
                     <button class="btn btn-default" type="button">Login</button>
                </a>
            </div>
        </div>
    </form>
</div>

</body>
</html>

