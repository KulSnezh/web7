  const data = pricingData[serviceType];

  let price = data.basePrice;

  // Добавляем цену опции, если есть
  if (data.options && optionSelect.value) {
    const selectedOption = data.options.find(opt => opt.value === optionSelect.value);
    if (selectedOption) price += selectedOption.priceModifier;
  }

  // Добавляем цену свойства, если есть и отмечено
  if (data.property && propertyCheckbox.checked) {
    price += data.property.priceModifier;
  }

  const totalPrice = price * quantity;

  priceDisplay.textContent = Итоговая цена: ${totalPrice.toLocaleString('ru-RU')} руб.;
}

// Инициализация формы при загрузке
function init() {
  const checkedRadio = form.querySelector('input[name="serviceType"]:checked');
  updateFormControls(checkedRadio.value);
  calculatePrice();
}

// Слушатели событий
form.addEventListener('change', e => {
  if (e.target.name === 'serviceType') {
    updateFormControls(e.target.value);
  }
  calculatePrice();
});

quantityInput.addEventListener('input', () => {
  calculatePrice();
});

optionSelect.addEventListener('change', () => {
  calculatePrice();
});

propertyCheckbox.addEventListener('change', () => {
  calculatePrice();
});

// Запуск
init();

</script>

</body>
</html>
