<!DOCTYPE html>
<head>
    <title>Test MODEL</title>
</head>
<body>
<h1>MODEL</h1>
<hr>

    <div>
        <p><b>Эпоха: ${products.title}</b> Метрики: ${products.y} | ${products.x}| </p>
    </div>
<p ALIGN=RIGHT>Отправка данных для теста модели</p>

<form action="/send" method="post" ALIGN=RIGHT>
    Температура: <label>
        <input type="text" name="title"/>
    </label><br><br>
    Дата: <label>
        <input type="number" name="y"/>
    </label><br><br>
    Уровень снежного покрова: <label>
        <input type="number" name="x"/>
    </label><br><br>
    <input type="submit" value="Отправить"/>
</form>
</body>