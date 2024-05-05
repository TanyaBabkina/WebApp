<!DOCTYPE html>
<head>
    <title>Test MODEL</title>
</head>
<body>
<h1>MODEL ${name}</h1>
<hr>
    <div>
        <#list products as product>
            <div>
                <p><b>${product.epoch}</b>  ${product.train_loss}
                    ${product.val_loss} ${product.mae_train} ${product.mae_eval}
                </p>
            </div>
        <#else>
            <h3>Моделей нет</h3>
        </#list>

    </div>
<p ALIGN=RIGHT>Отправка данных для теста модели</p>

<form action="/api/sendData" method="post" ALIGN=RIGHT>
    Название модели: <label>
        <input type="text" name="model_name" value="${name}"/>
    </label><br><br>
    Дата: <label>
        <input type="date" name="date" value = "01.01.2024"/>
    </label><br><br>
    Температура воздуха: <label>
        <input type="number" name="t_air" value="-20"/>
    </label><br><br>
    Атмосферное давление: <label>
        <input type="number" name="atm_dav" value="178"/>
    </label><br><br>
    Скорость ветра: <label>
        <input type="number" name="wind" value="8"/>
    </label><br><br>
    Толщина снежного покрова: <label>
        <input type="number" name="snow_level" value="20"/>
    </label><br><br>
    Количество осадков: <label>
        <input type="number" name="rain" value="20"/>
    </label><br><br>
    <input type="submit" value="Отправить" />

</form>
</body>