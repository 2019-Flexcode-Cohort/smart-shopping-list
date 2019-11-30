const increaseButton = document.querySelector(".increaseButton");
incrementMealCount(increaseButton);

function incrementMealCount() {
    const mealIds = document.querySelectorAll(".incrementMealId");
    for (let i = 0; i < mealIds.length; i++){
        mealIds[i].parentElement.addEventListener("click", () => {
            fetch('http://localhost:8080/api/mealPlan/increaseCount/' + mealIds[i].value, {
                method: 'GET'
            })
        })
    }
}
const decreaseButton = document.querySelector(".decreaseButton");
decrementMealCount(decreaseButton);

function decrementMealCount() {
    const mealIds = document.querySelectorAll(".decrementMealId");
    for (let i = 0; i < mealIds.length; i++){
        mealIds[i].parentElement.addEventListener("click", () => {
            fetch('http://localhost:8080/api/mealPlan/decreaseCount/' + mealIds[i].value, {
                method: 'GET'
            })
        })
    }
}

const currentMealCount = document.querySelector(".currentMealCount");
updateCurrentMealCount(currentMealCount);

async function updateCurrentMealCount() {
    const mealCounts = document.querySelectorAll(".currentMealCount");
    for (let i = 0; i < mealCounts.length; i++) {
        mealCounts[i].innerText = await fetch('http://localhost:8080/api/mealPlan/mealCount/' + mealCounts[i].querySelector(".countMealId").value).body
    }
}
