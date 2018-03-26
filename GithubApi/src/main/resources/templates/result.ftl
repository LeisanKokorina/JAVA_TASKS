<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Success</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>


<div class="container">
    <br>

    <div class="container">
        <ul class="pager">
            <li class="previous"><a href="/">Main Page</a></li>

        </ul>
    </div>
    <#if model.username??>

        <h3 align="center">Congratulations! <br>
            ${model.username}, you have been registered successfully via GitHub account.<br>
            Please, <a href="/login">log in</a>
        </h3>
    <#else>

    <h3 align="center" >Warning! <br>
        GitHub account not found.

        Please, <a href="/registration">try again</a>
    </h3>
    </#if>


</div>

</body>
</html>

