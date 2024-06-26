document.addEventListener('DOMContentLoaded', function() {
    const buyButtons = document.querySelectorAll('.buttonBuy');

    buyButtons.forEach(button => {
        button.addEventListener('click', function(event) {
            event.preventDefault();

            const laptopId = this.closest('[data-laptop-id]').dataset.laptopId;
            const userId = document.getElementById('userId').value; // припускаємо, що ви зберігаєте userId в прихованому полі або в сесії

            fetch('/purchase/buy', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                body: new URLSearchParams({
                    'userId': userId,
                    'laptopId': laptopId
                })
            })
                .then(response => response.text())
                .then(data => {
                    if (data.includes('Покупка успішна!')) {
                        window.location.href = '/index';
                    } else {
                        alert('Помилка при покупці. Спробуйте знову.');
                    }
                })
                .catch(error => console.error('Error:', error));
        });
    });
});
