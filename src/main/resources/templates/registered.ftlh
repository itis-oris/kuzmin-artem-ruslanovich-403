<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Регистрация | WildLife Zoo</title>

    <link rel="stylesheet" href="/css/auth.css">
</head>
<body>

<div class="auth-page">

    <div class="auth-card">

        <h1>
            Создание аккаунта
        </h1>

        <p class="auth-subtitle">
            Присоединяйтесь к WildLife Zoo
        </p>

        <form method="post" action="/register">

            <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}">


            <div class="form-group">

                <label>Имя</label>

                <input type="text"
                       name="username"
                       placeholder="Введите имя"
                required>

            </div>

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
                       placeholder="Минимум 8 символов"
                required>

            </div>

            <button type="submit" class="submit-btn">
                Зарегистрироваться
            </button>

        </form>

        <div class="auth-switch">
            Уже есть аккаунт?
            <a href="/login">Войти</a>
        </div>

    </div>

</div>

</body>
</html>