<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Животные | WildLife Zoo</title>
    <link rel="stylesheet" href="/css/animals.css">


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

            <#if currentUser??>

                <#if currentUser.role.name() == "ROLE_ADMIN">

                    <a href="/admin">
                        Админ панель
                    </a>

                <#else>

                    <a href="/profile">
                        Профиль
                    </a>

                    <a href="/booking">
                        Бронирование
                    </a>

                </#if>

                <form action="/logout" method="post">

                    <input type="hidden"
                           name="${_csrf.parameterName}"
                           value="${_csrf.token}">

                    <button type="submit" class="logout-btn">
                        Выйти
                    </button>

                </form>

            <#else>

                <a href="/login" class="login-btn">
                    Войти
                </a>

            </#if>

        </nav>

    </div>

</header>

<section class="animals-section">

    <div class="container">

        <div class="page-header">
            <h1>
                Наши животные
            </h1>
            <p>
                Познакомьтесь с удивительными обитателями нашего зоопарка
            </p>
        </div>

        <div class="filter-block">
            <select id="speciesFilter">
                <option value="">
                    Все животные
                </option>
                <option value="MAMMAL">
                    Млекопитающие
                </option>
                <option value="BIRD">
                    Птицы
                </option>
                <option value="REPTILE">
                    Рептилии
                </option>
                <option value="AMPHIBIAN">
                    Земноводные
                </option>
                <option value="FISH">
                    Рыбы
                </option>
            </select>
        </div>

        <div class="animals-grid" id="animalsContainer">

        </div>

        <div class="empty-message" id="emptyMessage">
            Животные не найдены
        </div>

    </div>

</section>

<script src="/js/animals.js"></script>
</body>
</html>