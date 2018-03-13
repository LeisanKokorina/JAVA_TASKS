<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>

<html>
<head>
    <title>Вход</title>
</head>
<body>

<form title="Вход"
      name="RegistrationForm"
      method="post"
      action="/login">
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
