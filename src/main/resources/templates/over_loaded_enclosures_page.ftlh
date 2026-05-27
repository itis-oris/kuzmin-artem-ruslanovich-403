<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Переполненные вольеры | WildLife Zoo</title>

    <link rel="stylesheet" href="/css/overloaded-enclosures.css">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
</head>
<body>

<header class="header">

    <div class="container header-container">

        <div class="logo">
            WildLife Zoo
        </div>

        <nav class="nav">

            <a href="/">Главная</a>

            <a href="/animals-page">
                Животные
            </a>

            <a href="/admin">
                Админ панель
            </a>

            <form action="/logout"
                  method="post">

                <input type="hidden"
                       name="${_csrf.parameterName}"
                       value="${_csrf.token}">

                <button type="submit"
                        class="logout-btn">

                    Выйти

                </button>

            </form>

        </nav>

    </div>

</header>

<section class="overloaded-section">

    <div class="container">

        <div class="page-header">

            <h1>
                Переполненные вольеры
            </h1>

            <p>
                Вольеры, содержащие более 10 животных
                и минимум 2 смотрителей
            </p>

        </div>

        <div class="back-block">

            <a href="/admin/enclosures"
               class="back-btn">

                ← Вернуться к вольерам

            </a>

        </div>

        <div class="enclosures-grid">

            <#if overLoadedEnclosures?size == 0>

                <div class="empty-block">

                    Переполненные вольеры отсутствуют

                </div>

            <#else>

                <#list overLoadedEnclosures as enclosure>

                    <div class="enclosure-card">

                        <div class="card-top">

                            <h2>
                                ${enclosure.name}
                            </h2>

                            <span class="danger-badge">
                                OVERLOADED
                            </span>

                        </div>

                        <div class="info-block">

                            <p>

                                <strong>
                                    Тип:
                                </strong>

                                <#if enclosure.type.name() == "OPEN">
                                    Открытый
                                <#else>
                                    Закрытый
                                </#if>

                            </p>

                            <p>

                                <strong>
                                    Количество животных:
                                </strong>

                                ${enclosure.animals?size}

                            </p>

                            <p>

                                <strong>
                                    Количество смотрителей:
                                </strong>

                                ${enclosure.keepers?size}

                            </p>

                        </div>

                        <div class="keepers-block">

                            <strong>
                                Смотрители:
                            </strong>

                            <div class="keepers-list">

                                <#list enclosure.keepers as keeper>

                                    <span class="keeper-badge">
                                        ${keeper.fullName}
                                    </span>

                                </#list>

                            </div>

                        </div>

                    </div>

                </#list>

            </#if>

        </div>

    </div>

</section>

</body>
</html>