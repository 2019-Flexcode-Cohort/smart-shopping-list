const appContainer = document.querySelector(".app");
renderIngredientInput(appContainer);

function renderIngredientInput(element) {
  element.appendChild(createIngredientInput());
}

function createIngredientInput() {
  const ingredientInput = document.createElement("li");
  ingredientInput.appendChild(createNameBox());
  ingredientInput.appendChild(createNumberBox());
  const button = createAddItemButton();
  const removeButton = createRemoveItemButton();
  ingredientInput.appendChild(button);
  ingredientInput.appendChild(removeButton);
  button.addEventListener('click', (event) => {
    event.preventDefault();
    console.log(event.target);
    renderIngredientInput(event.target.parentNode.parentNode);
    event.target.remove();
  })
  removeButton.addEventListener('click', (event) => {
    console.log(event.target);
    event.target.parentNode.remove()
  })
  return ingredientInput;
}

function createNameBox() {
  const nameBox = document.createElement("input");
  nameBox.setAttribute("type", "text");
  nameBox.setAttribute("placeholder", "Ingredient Name");
  return nameBox;
}
function createNumberBox() {
  const numberBox = document.createElement("input");
  numberBox.setAttribute("type", "number");
  numberBox.setAttribute("placeholder", "Qty");
  return numberBox;
}
function createAddItemButton() {
  const button = document.createElement('button');
  button.innerText = '+';
  button.classList.add('add-ingredient-button');
  return button;
}
function createRemoveItemButton() {
  const removeButton = document.createElement('button');
  removeButton.innerText = 'x';
  removeButton.classList.add('remove-ingredient-button');
  return removeButton;
}

const actionObject = {
  "name": "AwesomeName",
  "servingCount": 1,
  "mealIngredients": [
    {
      "ingredient": {
        "name": "TestIngredient"
      },
      "quantity": 1
    }
  ]
}

document.querySelector(".submit").addEventListener("click", event => {
  event.preventDefault();
  sendMealToAPI(actionObject)
});

function sendMealToAPI(obj) {
  const response = await fetch('http://localhost:8080/add-meal');
  const myJson = await response.json();
  console.log(JSON.stringify(myJson))

}




