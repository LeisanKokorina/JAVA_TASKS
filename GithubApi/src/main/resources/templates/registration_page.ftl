<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>

<html>
<head>
    <title>Регистрация</title>
</head>
<body>

<form title="Registration via Github"
      name="RegistrationForm"
      method="post"
      action="/registration">
    <br>
    <input type="text" name="login" placeholder="login"/>
    <br>
    <input type="password" name="password" placeholder="password"/>
    <input type="checkbox" name="remember-me">Запомнить
    <br>
    <input type="submit">
</form>
</body>
</html>
