<!DOCTYPE html>
<head>
    <title>MODEL</title>
</head>
<body>

<h1>MODEL</h1>
<hr>
<h4>Список моделей</h4>

<#list products as product>
    <div>
        <p><b>${product}</b> <a href="/testModel/${product}">Подробнее...</a></p>
    </div>
    <#else>
    <h3>Моделей нет</h3>
</#list>
<hr>


</body>
