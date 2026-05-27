const animalsContainer = document.getElementById('animalsContainer');
const speciesFilter = document.getElementById('speciesFilter');
const emptyMessage = document.getElementById('emptyMessage');

function loadAnimals(species = '') {
    let url = '/animals';
    if (species) {
        url += '?species=' + species;
    }

    fetch(url)
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP ${response.status}: ${response.statusText}`);
            }
            return response.json();
        })
        .then(animals => {
            animalsContainer.innerHTML = '';

            if (animals.length === 0) {
                emptyMessage.style.display = 'block';
                return;
            }

            emptyMessage.style.display = 'none';


            animals.forEach(animal => {
                const animalCard = document.createElement('div');
                animalCard.classList.add('animal-card');

                animalCard.innerHTML = `
                    <img src="/uploads/${animal.imagePath}" alt="${animal.nickname}">
                    <div class="animal-info">
                        <h3>${animal.nickname}</h3>
                        <p><strong>Вид:</strong> ${animal.speciesDisplay}</p>
                        <p><strong>Вольер:</strong> ${animal.enclosureName}</p>
                    </div>
                `;

                animalsContainer.appendChild(animalCard);
            });
        })
        .catch(error => {
            animalsContainer.innerHTML = '<div class="error">Ошибка загрузки животных</div>';
            emptyMessage.style.display = 'none';
        });
}

speciesFilter.addEventListener('change', () => {
    loadAnimals(speciesFilter.value);
});

loadAnimals();