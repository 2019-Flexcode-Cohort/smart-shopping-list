const newIngContainer = document.querySelector(".addNewIng");
addNewIngredient(newIngContainer);

function addNewIngredient(element) {
    element.appendChild(createNewIngredientInput());
}


function createNewIngredientInput() {
<<<<<<< HEAD
    const ingredientInput = document.createElement("li");
    ingredientInput.classList.add("ingredientInput");
=======
    const ingredientInput = document.createElement("div");
>>>>>>> dev
    ingredientInput.appendChild(createNameBox());
    ingredientInput.appendChild(createNumberBox());
    const button = createAddItemButton();
    const removeButton = createRemoveItemButton();
    ingredientInput.appendChild(button);
    ingredientInput.appendChild(removeButton);
    button.addEventListener('click', (event) => {
        event.preventDefault();
        console.log(event.target);
        addNewIngredient(event.target.parentNode.parentNode);
        event.target.remove();
    })
    removeButton.addEventListener('click', (event) => {
        console.log(event.target);
        event.target.parentNode.remove();
    })
    return ingredientInput;
}

function createNameBox() {
    const nameBox = document.createElement("input");
    nameBox.setAttribute("type", "text");
    nameBox.classList.add("ingredientName");
    return nameBox;
}
function createNumberBox() {
    const numberBox = document.createElement("input");
    numberBox.classList.add("ingredientQty");
    numberBox.setAttribute("type", "number");
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
function readIngredientInput() {
    const mealIngredients = []
    const mealIngredient = {
        "ingredient": {
            "name": "SampleIngredient"
        },
        "quantity": 23
    }
    const mealIngInputs = document.querySelectorAll(".ingredientInput");
    for (let i = 0; i < mealIngInputs.length; i++) {
        mealIngredient.ingredient.name = mealIngInputs[i].querySelector(".ingredientName").value;
        mealIngredient.quantity = mealIngInputs[i].querySelector(".ingredientQty").value;
        mealIngredients.push(mealIngredient);

    }
    return mealIngredients;

}


const mealToAdd = {
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
    mealToAdd.name = addMealName.value;

    mealToAdd.mealIngredients = readIngredientInput();

    sendMealToAPI(mealToAdd)
});

async function sendMealToAPI(obj) {
    const response = await fetch('http://localhost:8080/api/meals/add-meal', {
        method: 'POST',
        body: JSON.stringify(obj),
        headers: {
            'Content-Type': 'application/json'
        }

    });
    const myJson = await response.json();
    console.log('Success', JSON.stringify(myJson));
}
