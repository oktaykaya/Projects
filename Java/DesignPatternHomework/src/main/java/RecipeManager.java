import java.util.ArrayList;
import java.util.List;



public class RecipeManager {
    private final List<Recipe> recipes;
    public RecipeManager() {
        recipes = new ArrayList<>();
    }
    public Recipe createRecipe(String name, List<String> ingredients, List<String> cookingInstructions, int servingSize, Category category, Tag tag) {
        Recipe recipe = new Recipe(name, ingredients, cookingInstructions, servingSize, category, tag);
        addRecipe(recipe);
        return recipe;
    }
    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }
    public List<Recipe> searchRecipes(String keyword) {
        if (keyword.isEmpty()) {
            return recipes;
        }
        String searchKeyword = keyword.toLowerCase();
        List<Recipe> result = new ArrayList<>();
        for (Recipe recipe : recipes) {
            if (recipe.getName().toLowerCase().contains(searchKeyword) || recipe.getIngredients().contains(searchKeyword) || recipe.getCategory().name().toLowerCase().contains(searchKeyword) || recipe.getTag().name().toLowerCase().contains(searchKeyword)) {
                result.add(recipe);
            }
        }
        return result;
    }
    public void rateRecipe(Recipe recipe, int rating) {
        recipe.addRating(rating);
    }
    public List<Recipe> getAllRecipes() {
        return recipes;
    }
}

