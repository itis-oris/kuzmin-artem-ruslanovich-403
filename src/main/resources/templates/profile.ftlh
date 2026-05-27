<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Профиль | WildLife Zoo</title>

    <link rel="stylesheet" href="/css/profile.css">
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

<section class="profile-section">

    <div class="container">

        <div class="page-header">

            <h1>
                Мой профиль
            </h1>

            <p>
                Управление личным аккаунтом
            </p>

        </div>

        <div class="profile-card">

            <div class="profile-info">

                <div class="info-block">

                    <span class="info-label">
                        Имя пользователя
                    </span>

                    <h2>
                        ${user.username}
                    </h2>

                </div>

                <div class="info-block">

                    <span class="info-label">
                        Email
                    </span>

                    <p>
                        ${user.email}
                    </p>

                </div>


                <div class="info-block">

                    <span class="info-label">
                        Количество бронирований
                    </span>

                    <div class="bookings-count">

                        ${bookingsCount}

                    </div>

                </div>

            </div>

            <div class="profile-actions">

                <a href="/profile/edit" class="edit-btn">
                    Изменить профиль
                </a>

                <form method="post"
                      action="/profile/delete">

                    <input type="hidden"
                           name="${_csrf.parameterName}"
                           value="${_csrf.token}">

                    <button type="submit"
                            class="delete-btn">

                        Удалить профиль

                    </button>

                </form>

            </div>

        </div>

    </div>

</section>

</body>
</html>