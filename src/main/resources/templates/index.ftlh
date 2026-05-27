<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>WildLife Zoo</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>

<header class="header">

    <div class="container header-container">
        <div class="logo">
            WildLife Zoo
        </div>
        <nav class="nav">

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

<section class="hero">
    <div class="container hero-content">
        <span class="hero-subtitle">
            Добро пожаловать в мир дикой природы
        </span>
        <h1>
            WildLife Zoo
        </h1>
        <p>
            Наши зверушки будут рады встрече с вами! <br>
            Познакомьтесь с удивительными животными,
            узнайте больше об их мире и проведите
            незабываемое время вместе с нами.
        </p>

        <div class="hero-buttons">
            <a href="/animals-page" class="primary-btn">
                Смотреть животных
            </a>

            <a href="/login" class="secondary-btn">
                Войти в профиль
            </a>

        </div>

    </div>

</section>

<section class="about">

    <div class="container">
        <h2 class="section-title">
            Почему стоит посетить наш зоопарк
        </h2>
        <div class="about-grid">
            <div class="about-card">
                <h3>Уникальные животные</h3>
                <p>
                    У нас представлены редкие виды животных
                    со всего мира, за которыми интересно наблюдать
                    как детям, так и взрослым.
                </p>
            </div>

            <div class="about-card">
                <h3>Современные условия</h3>

                <p>
                    Просторные вольеры и забота специалистов
                    помогают животным чувствовать себя комфортно
                    и безопасно.
                </p>
            </div>

            <div class="about-card">
                <h3>Удобное бронирование</h3>

                <p>
                    После регистрации вы сможете быстро
                    оформить посещение зоопарка прямо на сайте.
                </p>
            </div>

        </div>

    </div>

</section>

<section class="info">

    <div class="container info-container">

        <div class="info-text">
            <h2>
                Более 10 животных удивительных видов
            </h2>
            <p>
                WildLife Zoo — это современный зоопарк,
                объединяющий любовь к природе, комфорт посетителей
                и заботу о животных.
            </p>

            <a href="/animals-page" class="primary-btn">
                Перейти к животным
            </a>
        </div>
    </div>
</section>

<footer class="footer">

    <div class="container footer-container">
        <p>
            © 2026 WildLife Zoo
        </p>

    </div>

</footer>

</body>
</html>