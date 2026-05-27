<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Админ панель | WildLife Zoo</title>

    <link rel="stylesheet" href="/css/admin.css">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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

            <a href="/admin" class="active-link">
                Админ панель
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

<section class="admin-section">

    <div class="container">

        <div class="admin-header">

            <span class="admin-label">
                ADMIN PANEL
            </span>

            <h1>
                Панель администратора
            </h1>

            <p>
                Управляйте животными, вольерами и сотрудниками зоопарка
            </p>

        </div>

        <div class="admin-grid">

            <div class="admin-card">

                <div class="card-content">

                    <h2>
                        Вольеры
                    </h2>

                    <p>
                        Просмотр и управление всеми
                        вольерами зоопарка
                    </p>

                </div>

                <a href="/admin/enclosures" class="card-btn">
                    Перейти
                </a>

            </div>

            <div class="admin-card">

                <div class="card-content">

                    <h2>
                        Добавить животное
                    </h2>

                    <p>
                        Добавление новых животных
                    </p>

                </div>

                <a href="/admin/animals/add" class="card-btn">
                    Перейти
                </a>

            </div>

            <div class="admin-card">

                <div class="card-content">

                    <h2>
                        Работники
                    </h2>

                    <p>
                        Управление сотрудниками
                        и смотрителями зоопарка
                    </p>

                </div>

                <a href="/admin/keepers" class="card-btn">
                    Перейти
                </a>

            </div>

        </div>

    </div>

</section>

</body>
</html>