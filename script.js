const API_BASE = "http://localhost:8080/recipes";

// 🔹 Add Recipe
document.getElementById("recipeForm").addEventListener("submit", async (e) => {
    e.preventDefault();

    const recipe = {
        title: document.getElementById("title").value,
        cuisine: document.getElementById("cuisine").value,
        rating: parseFloat(document.getElementById("rating").value),
        prepTime: parseInt(document.getElementById("prepTime").value),
        cookTime: parseInt(document.getElementById("cookTime").value),
        totalTime: parseInt(document.getElementById("totalTime").value),
        serves: document.getElementById("serves").value,
        description: document.getElementById("description").value,
        nutrients: document.getElementById("nutrients").value
    };

    try {
        const response = await fetch(API_BASE, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(recipe)
        });

        const data = await response.json();
        alert("Recipe added successfully!");
        console.log(data);
    } catch (error) {
        console.error("Error:", error);
    }
});

// 🔹 Load Top Recipes
async function loadTopRecipes() {
    try {
        const response = await fetch(`${API_BASE}/top?limit=5`);
        const result = await response.json();
        const recipes = result.data;

        const container = document.getElementById("recipesContainer");
        container.innerHTML = "";

        recipes.forEach(recipe => {
            const card = document.createElement("div");
            card.className = "recipe-card";

            card.innerHTML = `
                <h3>${recipe.title}</h3>
                <p><b>Cuisine:</b> ${recipe.cuisine}</p>
                <p><b>Rating:</b> ${recipe.rating}</p>
                <p><b>Total Time:</b> ${recipe.totalTime} mins</p>
                <p><b>Serves:</b> ${recipe.serves}</p>
                <p>${recipe.description}</p>
            `;

            container.appendChild(card);
        });

    } catch (error) {
        console.error("Error loading recipes:", error);
    }
}