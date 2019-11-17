const appContainer = document.querySelector(".app");
renderIngredientInput(appContainer);

function renderIngredientInput(element) {
  element.appendChild(createIngredientInput());
}

function createIngredientInput() {
  const ingredientInput = document.createElement("section");
  ingredientInput.appendChild(createNameBox());
  ingredientInput.appendChild(createNumberBox());
  const button = createAddItemButton();
  ingredientInput.appendChild(button);
  button.addEventListener('click', (event) => {
    event.preventDefault();
    console.log(event.target);
    renderIngredientInput(event.target.parentNode);
    event.target.remove();
  })
  return ingredientInput;
}

function createNameBox() {
  const nameBox = document.createElement("input");
  nameBox.setAttribute("type", "text");
  return nameBox;
}
function createNumberBox() {
  const numberBox = document.createElement("input");
  numberBox.setAttribute("type", "number");
  return numberBox;
}
function createAddItemButton() {
  const button = document.createElement('button');
  button.innerText = '+';
  button.classList.add('add-ingredient-button');
  return button;
}
