<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<#if model.user.role == "ADMIN">
<h3>Привет, ${model.user.login}</h3>
<a href="/logout">Выйти</a>

<#else>
<h1>Привет, ${model.user.login} </h1>

<a href="/logout">Выйти</a>



</#if>
</body>
</html>
