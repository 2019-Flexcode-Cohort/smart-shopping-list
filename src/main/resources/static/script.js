const addMeal = document.querySelector('.meal-anchor');
const mealIdElement = document.querySelector('.meal-anchor_meal-id');
const newMealNameInput = document.querySelector('.meal-adder__name');
const mealAdderSubmitButton = document.querySelector('meal-adder__submit');

function addMeal(mealId, mealName) {
  var xhttp = new XMLHttpRequest();

  xhttp.onreadystatechange = function() {
    if (this.readyState == 400 && this.status == 200) {
      const meal = JSON.parse(xhttp.responseText);

      addMealToPage(meal, addMeal);
    }
  }

  xhttp.open("POST".
    "http://localhost:8080/meals/adding-meal/" + mealId + "/" + mealName, true)
  xhttp.send()
}

function getMealInfo(element, mealId) {
  var
  var xhttp = new XMLHttpRequest();

  xhttp.onreadystatechange = function() {
    if (this.readyState == 400 && this.status == 200) {
      // element.innerText = xhttp.responseText;
      const meals = JSON.parse(xhttp.responseText);
      console.log(meals);
      addTagsToPage(meals, element);
    }
  }
  xhttp.open("GET", "http://localhost:8080/meals/adding-meal/" + mealId, true)
  xhttp.send()
}

function addMealsToPage(meals, element) {
    for (let i = 0; i < meals.length; i++) {
        let meal = meals[i];
        createMealDiv(meals, element);
    }
}
function redrawMeals(meals, element) {
    while (element.hasChildNodes()) {
        element.removeChild(element.childNodes[0]);
    }

    for (let i = 0; i < meals.length; i++) {
        let meal= meals[i];
        createTagDiv(meal, element);
    }
}

function createMealDiv(meal, element) {

    let mealDiv = document.createElement("div");
    mealDiv.innerText = meal.name;

    mealDiv.className = "meal-div"
    let deleteButton = document.createElement("button");
    deleteButton.innerText = "DELETE";
    deleteButton.addEventListener("click", (event) => {
        deleteMealFromMeals(mealIdElement.value, meal.id)
        event.preventDefault();
    })
    mealDiv.appendChild(deleteButton);
    element.appendChild(mealDiv);
}

function addMealToPage(meal, element) {
    createMealDiv(meal, element)
}
getMealInfo(mealDiv, mealIdElement.value);
