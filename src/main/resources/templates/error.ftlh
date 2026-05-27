<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Ошибка</title>

    <link rel="stylesheet" href="/css/error.css">
</head>
<body>

<div class="error-container">

    <div class="error-code">
        ${status}
    </div>

    <h1>Что-то пошло не так</h1>

    <p class="error-message">
        ${message}
    </p>

    <div class="buttons">

        <a href="/" class="btn">
            На главную
        </a>

        <button onclick="history.back()" class="btn secondary">
            Назад
        </button>

    </div>

</div>

</body>
</html>