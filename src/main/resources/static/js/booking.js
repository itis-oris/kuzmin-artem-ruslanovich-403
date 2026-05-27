const visitDateInput = document.getElementById('visitDate');

const today = new Date().toISOString().split('T')[0];
visitDateInput.min = today;

const adultCount = document.getElementById('adultCount');
const studentCount = document.getElementById('studentCount');
const childCount = document.getElementById('childCount');
const currency = document.getElementById('currency');

const totalPrice = document.getElementById('totalPrice');

function updatePrice() {
    const params = new URLSearchParams({
        adultCount: adultCount.value,
        studentCount: studentCount.value,
        childCount: childCount.value,
        currency: currency.value
    });

    fetch('/api/booking/calculate?' + params)
        .then(response => {
            if (!response.ok) {
                throw new Error('HTTP error ' + response.status);
            }
            return response.json();
        })
        .then(data => {
            totalPrice.textContent = data.totalPrice + ' ' + data.currency;
        })
        .catch(error => {
            console.error('Ошибка при расчёте стоимости:', error);
            totalPrice.textContent = 'Ошибка расчёта';
        });
}

adultCount.addEventListener('input', updatePrice);
studentCount.addEventListener('input', updatePrice);
childCount.addEventListener('input', updatePrice);
currency.addEventListener('change', updatePrice);

updatePrice();