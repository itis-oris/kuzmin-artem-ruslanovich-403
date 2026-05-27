<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Работники | WildLife Zoo</title>

    <link rel="stylesheet" href="/css/keepers.css">

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

            <a href="/admin">
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

<section class="keepers-section">

    <div class="container">

        <div class="page-header">

            <h1>
                Работники зоопарка
            </h1>

            <p>
                Управление сотрудниками и смотрителями
            </p>

        </div>

        <div class="keepers-layout">

            <div class="keepers-list">

                <#if keepers?size == 0>

                    <div class="empty-block">
                        Работники пока отсутствуют
                    </div>

                <#else>

                    <#list keepers as keeper>

                        <div class="keeper-card">

                            <h3>
                                ${keeper.fullName}
                            </h3>

                            <p>
                                <strong>Должность:</strong>
                                ${keeper.position}
                            </p>

                            <p>
                                <strong>Телефон:</strong>
                                ${keeper.phone}
                            </p>

                        </div>

                    </#list>

                </#if>

            </div>

            <div class="create-card">

                <h2>
                    Добавить работника
                </h2>

                <form method="post" action="/admin/keepers">

                    <input type="hidden"
                           name="${_csrf.parameterName}"
                           value="${_csrf.token}">

                    <div class="form-group">

                        <label>ФИО</label>

                        <input type="text"
                               name="fullName"
                               required>

                    </div>

                    <div class="form-group">

                        <label>Должность</label>

                        <input type="text"
                               name="position"
                               required>

                    </div>

                    <div class="form-group">

                        <label>Телефон</label>

                        <input type="text"
                               name="phone"
                               required>

                    </div>

                    <button type="submit" class="submit-btn">
                        Добавить
                    </button>

                </form>

            </div>

        </div>

    </div>

</section>

</body>
</html>