<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Редактирование профиля | WildLife Zoo</title>
    <link rel="stylesheet" href="/css/edit_profile.css">

</head>
<body>

<header class="header">

    <div class="container header-container">

        <div class="logo">
            WildLife Zoo
        </div>

        <nav class="nav">

            <a href="/">Главная</a>

            <a href="/animals-page">Животные</a>

            <a href="/booking">
                Бронирование
            </a>

            <a href="/profile" class="active-link">
                Профиль
            </a>

            <form action="/logout" method="post">

                <input type="hidden"
                       name="${_csrf.parameterName}"
                       value="${_csrf.token}">

                <button type="submit" class="logout-btn">
                    Выйти
                </button>

            </form>

        </nav>

    </div>

</header>

<section class="edit-section">

    <div class="container">

        <div class="page-header">

            <h1>
                Редактирование профиля
            </h1>

            <p>
                Измените информацию о вашем аккаунте
            </p>

        </div>

        <div class="edit-card">

            <form method="post"
                  action="/profile/edit">

                <input type="hidden"
                       name="${_csrf.parameterName}"
                       value="${_csrf.token}">

                <div class="form-group">

                    <label>
                        Имя пользователя
                    </label>

                    <input type="text"
                           name="username"
                           value="${form.username}"
                           required>

                </div>

                <div class="buttons-block">

                    <button type="submit"
                            class="save-btn">

                        Сохранить изменения

                    </button>

                    <a href="/profile"
                       class="cancel-btn">

                        Отменить изменения

                    </a>

                </div>

            </form>

        </div>

    </div>

</section>

</body>
</html>