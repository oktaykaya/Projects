import java.util.List;

public class Recipe {
    private String name;
    private List<String> ingredients;
    private List<String> cookingInstructions;
    private int servingSize;
    private Category category;
    private Tag tag;
    private double impact;
    private int numberOfRatings;
    private double averageRating;

    public Recipe(String name, List<String> ingredients, List<String> cookingInstructions, int servingSize, Category category, Tag tag) {
        this.name = name;
        this.ingredients = ingredients;
        this.cookingInstructions = cookingInstructions;
        this.servingSize = servingSize;
        this.category = category;
        this.tag = tag;
        this.impact = 0;
        this.numberOfRatings = 0;
        this.averageRating = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getCookingInstructions() {
        return cookingInstructions;
    }

    public void setCookingInstructions(List<String> cookingInstructions) {
        this.cookingInstructions = cookingInstructions;
    }

    public int getServingSize() {
        return servingSize;
    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public double getImpact() {
        return impact;
    }

    public int getNumberOfRatings() {
        return numberOfRatings;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void addRating(int rating) {
        this.numberOfRatings += 1;
        double total = this.averageRating * (this.numberOfRatings - 1);
        this.averageRating = (total + rating) / this.numberOfRatings;

        impact = averageRating;
    }

    @Override
    public String toString() {
        return name;
    }
}
