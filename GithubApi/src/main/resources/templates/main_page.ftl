<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <title>Main Page</title>
</head>
<body>
<#if model.user??>
<div>

    ${model.user.login}
    <a href="/profile">Личный кабинет</a>

    <a href="/logout">Выйти</a>
</div>
<#else>
<div>
    <a href="/login">Войти</a>/<a href="/registration">Зарегистрироваться через GitHub</a>

</div>
</#if>
</body>
</html>
