<!DOCTYPE html>
<head>
    <title>MODEL</title>
</head>
<body>

<h1>MODEL</h1>
<hr>
<h4>Список моделей</h4>
<#--<form action="/" method="get">-->
<#--    Поиск по названию модели: <input type="text" name="title"><br>-->
<#--    <input type="submit" value="Поиск"/>-->
<#--    </form>-->
<#list products as product>
    <div>
        <p><b>${product.title}</b> ${product.y} | ${product.x}| <a href="/testModel/${product.ID}">Подробнее...</a></p>
    </div>
    <#else>
    <h3>Моделей нет</h3>
</#list>
<hr>
<#--<h3>Создать новый график</h3>-->
<#--<form action="/product/create" method="post">-->
<#--    Название эпохи: <label>-->
<#--        <input type="text" name="title"/>-->
<#--    </label><br><br>-->
<#--    Значение y: <label>-->
<#--        <input type="number" name="y"/>-->
<#--    </label><br><br>-->
<#--    Значение x: <label>-->
<#--        <input type="number" name="x"/>-->
<#--    </label><br><br>-->
<#--    <input type="submit" value="Добавить в бд товар"/>-->
<#--</form>-->

</body>
