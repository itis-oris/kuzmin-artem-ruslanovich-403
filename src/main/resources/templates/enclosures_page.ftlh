<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Вольеры | WildLife Zoo</title>

    <link rel="stylesheet" href="/css/enclosures.css">

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

<section class="enclosures-section">

    <div class="container">

        <div class="page-header">

            <h1>
                Вольеры зоопарка
            </h1>

            <p>
                Управление вольерами и смотрителями
            </p>

        </div>

        <div class="top-actions">

            <a href="/admin/enclosures/over-loaded"
               class="overloaded-btn">

                Показать переполненные вольеры

            </a>

        </div>

        <div class="enclosures-layout">

            <div class="enclosures-list">

                <#if enclosures?size == 0>

                    <div class="empty-block">
                        Вольеры пока отсутствуют
                    </div>

                <#else>

                    <#list enclosures as enclosure>

                        <div class="enclosure-card">

                            <h3>
                                ${enclosure.name}
                            </h3>

                            <p>
                                <strong>Тип:</strong>

                                <#if enclosure.type.name() == "OPEN">
                                    Открытый
                                <#else>
                                    Закрытый
                                </#if>
                            </p>

                            <div class="keepers-block">

                                <strong>Смотрители:</strong>

                                <#if enclosure.keepers?size == 0>

                                    <span class="empty-keepers">
                                        Не назначены
                                    </span>

                                <#else>

                                    <div class="keepers-list">

                                        <#list enclosure.keepers as keeper>

                                            <span class="keeper-badge">
                                                ${keeper.fullName}
                                            </span>

                                        </#list>

                                    </div>

                                </#if>

                            </div>

                        </div>

                    </#list>

                </#if>

            </div>

            <div class="create-card">

                <h2>
                    Добавить вольер
                </h2>

                <form method="post" action="/admin/enclosures">

                    <input type="hidden"
                           name="${_csrf.parameterName}"
                           value="${_csrf.token}">


                    <div class="form-group">

                        <label>Название</label>

                        <input type="text"
                               name="name"
                               required>

                    </div>

                    <div class="form-group">

                        <label>Тип вольера</label>

                        <select name="type">

                            <#list types as type>

                                <option value="${type}">

                                    <#if type.name() == "OPEN">
                                        Открытый
                                    <#else>
                                        Закрытый
                                    </#if>

                                </option>

                            </#list>

                        </select>

                    </div>

                    <div class="form-group">

                        <label>Смотрители</label>

                        <select name="keeperIds"
                                multiple
                                class="multi-select">

                            <#list keepers as keeper>

                                <option value="${keeper.id}">
                                    ${keeper.fullName}
                                </option>

                            </#list>

                        </select>

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