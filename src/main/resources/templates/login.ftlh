<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Вход | WildLife Zoo</title>

    <link rel="stylesheet" href="/css/auth.css">
</head>
<body>

<div class="auth-page">

    <div class="auth-card">

        <h1>
            Вход в аккаунт
        </h1>

        <p class="auth-subtitle">
            Добро пожаловать обратно в WildLife Zoo
        </p>

        <#if errorMessage??>
            <div class="error-message">
                ${errorMessage}
            </div>
        </#if>

        <form method="post" action="/login">

            <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}">


            <div class="form-group">

                <label>Email</label>

                <input type="email"
                       name="email"
                       placeholder="Введите email"
                       required>

            </div>

            <div class="form-group">

                <label>Пароль</label>

                <input type="password"
                       name="password"
                       placeholder="Введите пароль"
                       required>

            </div>

            <button type="submit" class="submit-btn">
                Войти
            </button>

        </form>


        <div class="auth-switch">
            Нет аккаунта?
            <a href="/register">Зарегистрироваться</a>
        </div>

    </div>

</div>

</body>
</html>