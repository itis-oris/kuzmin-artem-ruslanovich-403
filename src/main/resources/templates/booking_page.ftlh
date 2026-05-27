<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Бронирование | WildLife Zoo</title>
    <link rel="stylesheet" href="/css/booking.css">
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

            <a href="/booking">Бронирование</a>

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

<section class="booking-section">

    <div class="container">

        <div class="page-header">

            <h1>
                Мои бронирования
            </h1>

        </div>

        <div class="booking-layout">

            <div class="bookings-list">

                <#if bookings?size == 0>

                    <div class="empty-bookings">
                        У вас пока нет бронирований
                    </div>

                <#else>

                    <#list bookings as booking>

                        <div class="booking-card">

                            <h3>
                                Посещение на ${booking.visitDate}
                            </h3>

                            <p>
                                <strong>Валюта:</strong>
                                ${booking.currency}
                            </p>

                            <p>
                                <strong>Количество билетов:</strong>
                                ${booking.tickets?size}
                            </p>

                            <p>
                                <strong>Общая стоимость:</strong>
                                ${booking.totalPrice}
                                ${booking.currency}
                            </p>

                        </div>

                    </#list>

                </#if>

            </div>

            <div class="create-booking-card">

                <h2>
                    Новое бронирование
                </h2>

                <form method="post" action="/booking" id="bookingForm">

                    <input type="hidden"
                           name="${_csrf.parameterName}"
                           value="${_csrf.token}">

                    <div class="form-group">

                        <label>Дата посещения</label>

                        <input type="date"
                               name="visitDate"
                               id="visitDate"
                               required>

                    </div>

                    <div class="form-group">

                        <label>Взрослые билеты</label>

                        <input type="number"
                               name="adultCount"
                               id="adultCount"
                               value="0"
                               min="0">

                    </div>

                    <div class="form-group">

                        <label>Студенческие билеты</label>

                        <input type="number"
                               name="studentCount"
                               id="studentCount"
                               value="0"
                               min="0">

                    </div>

                    <div class="form-group">

                        <label>Детские билеты</label>

                        <input type="number"
                               name="childCount"
                               id="childCount"
                               value="0"
                               min="0">

                    </div>

                    <div class="form-group">

                        <label>Валюта</label>

                        <select name="currency" id="currency">

                            <option value="RUB">RUB</option>
                            <option value="USD">USD</option>
                            <option value="EUR">EUR</option>

                        </select>

                    </div>

                    <div class="price-block">

                        Итоговая стоимость:

                        <span id="totalPrice">
                            0 RUB
                        </span>

                    </div>

                    <button type="submit" class="submit-btn">
                        Забронировать
                    </button>

                </form>

            </div>

        </div>
    </div>

</section>

<script src="/js/booking.js"></script>

</body>
</html>