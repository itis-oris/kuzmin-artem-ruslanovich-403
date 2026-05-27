<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Добавить животное | WildLife Zoo</title>

    <link rel="stylesheet" href="/css/add-animal.css">

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

<section class="animal-section">

    <div class="container">

        <div class="page-header">

            <h1>
                Добавление животного
            </h1>

            <p>
                Создайте нового обитателя зоопарка
            </p>

        </div>

        <div class="form-card">

            <form method="post"
                  action="/admin/animals/add"
                  enctype="multipart/form-data">

                <input type="hidden"
                       name="${_csrf.parameterName}"
                       value="${_csrf.token}">

                <div class="form-group">

                    <label>Кличка</label>

                    <input type="text"
                           name="nickname"
                           required>

                </div>

                <div class="form-group">

                    <label>Вид животного</label>

                    <select name="species">

                        <#list species as animalSpecies>

                            <option value="${animalSpecies}">

                                ${animalSpecies.displayValue}

                            </option>

                        </#list>

                    </select>

                </div>

                <div class="form-group">

                    <label>Вольер</label>

                    <select name="enclosureId">

                        <#list enclosures as enclosure>

                            <option value="${enclosure.id}">
                                ${enclosure.name}
                            </option>

                        </#list>

                    </select>

                </div>

                <div class="form-group">

                    <label>Фотография</label>

                    <input type="file"
                           name="image"
                           accept="image/*"
                           required>

                </div>

                <button type="submit" class="submit-btn">
                    Добавить животное
                </button>

            </form>

        </div>

    </div>

</section>

</body>
</html>