import java.util.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    private static final RecipeManager recipeManager = new RecipeManager();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Main menu:");
            System.out.println("1. Create Recipe");
            System.out.println("2. Search Recipes");
            System.out.println("3. Rate Recipe");
            System.out.println("4. Modify Recipe");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    createRecipe();
                    break;
                case 2:
                    searchRecipes();
                    break;
                case 3:
                    rateRecipe();
                    break;
                case 4:
                    modifyRecipe();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private static void createRecipe() {
        try {
            System.out.println("Creating a new recipe...");

            // Recipe name
            String name = "";
            while (name.isEmpty()) {
                System.out.print("Enter recipe name: ");
                name = scanner.nextLine().trim();
                if (name.isEmpty()) {
                    System.out.println("Invalid input. Recipe name cannot be empty.");
                }
            }

            // Serving size
            int servingSize = 0;
            while (servingSize <= 0) {
                System.out.print("Enter serving size: ");
                try {
                    servingSize = Integer.parseInt(scanner.nextLine());
                    if (servingSize <= 0) {
                        System.out.println("Invalid input. Serving size must be a positive integer.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Serving size must be a numeric value.");
                }
            }

            // Ingredients
            List<String> ingredients = new ArrayList<>();
            System.out.print("Enter ingredients (comma separated list): ");
            String ingredientsInput = scanner.nextLine();
            if (!ingredientsInput.isEmpty()) {
                ingredients = Arrays.asList(ingredientsInput.split(","));
            }

            // Cooking instructions
            List<String> cookingInstructions = new ArrayList<>();
            System.out.print("Enter cooking instructions (comma separated list): ");
            String cookingInstructionsInput = scanner.nextLine();
            if (!cookingInstructionsInput.isEmpty()) {
                cookingInstructions = Arrays.asList(cookingInstructionsInput.split(","));
            }

            // Category
            System.out.println("Choose a category:");
            System.out.println("1. " + Category.APPETIZER.name());
            System.out.println("2. " + Category.MAIN_DISH.name());
            System.out.println("3. " + Category.DESSERT.name());
            int categoryChoice = scanner.nextInt();
            scanner.nextLine();

            Category category = switch (categoryChoice) {
                case 1 -> Category.APPETIZER;
                case 2 -> Category.MAIN_DISH;
                case 3 -> Category.DESSERT;
                default -> {
                    System.out.println("Invalid choice, defaulting to appetizers.");
                    yield Category.APPETIZER;
                }
            };
            //Tag
            System.out.println("Choose a tag:");
            System.out.println("1. " + Tag.GLUTENFREE.name());
            System.out.println("2. " + Tag.SPICY.name());
            System.out.println("3. " + Tag.VEGATARIAN.name());
            int tagChoice = scanner.nextInt();
            scanner.nextLine();

            Tag tag = switch (tagChoice) {
                case 1 -> Tag.GLUTENFREE;
                case 2 -> Tag.SPICY;
                case 3 -> Tag.VEGATARIAN;
                default -> {
                    System.out.println("Invalid choice, defaulting to vegatarian.");
                    yield Tag.VEGATARIAN;
                }
            };

            while(true){

                System.out.print("Save the recipe? (y/n): ");
                String saveOption = scanner.nextLine();

                if (saveOption.equalsIgnoreCase("y")) {
                    Recipe recipe = recipeManager.createRecipe(name, ingredients, cookingInstructions, servingSize, category, tag);
                    System.out.println("Recipe saved successfully: " + recipe);
                    return;
                } else if (saveOption.equalsIgnoreCase("n")){
                    System.out.println("Recipe creation cancelled.");
                    return;
                }
                else {
                    System.out.println("Please click correct options");
                }
            }


        } catch (Exception exception) {
            System.out.println("There is a problem: " + exception.getMessage());
        }
    }

    private static void searchRecipes() {
        List<Recipe> allRecipes = recipeManager.getAllRecipes();
        try {
            System.out.println("Searching for recipes...");
            System.out.print("Enter a keyword: ");
            String keyword = scanner.nextLine();
            List<Recipe> searchResults = recipeManager.searchRecipes(keyword);
            if (searchResults.isEmpty()) {
                System.out.println("No recipes found for keyword: " + keyword);
                for (int i = 0; i < allRecipes.size(); i++) {
                    System.out.println((i + 1) + ". " + allRecipes.get(i).getName());
                }
            } else {
                System.out.println("Search results:");
                for (int i = 0; i < searchResults.size(); i++) {
                    System.out.println((i + 1) + ". " + searchResults.get(i));
                }

                System.out.print("Enter the number of the recipe to view details: ");
                int recipeIndex = scanner.nextInt();
                scanner.nextLine();
                if (recipeIndex < 1 || recipeIndex > searchResults.size()) {
                    System.out.println("Invalid recipe index, please try again.");
                } else {
                    Recipe selectedRecipe = searchResults.get(recipeIndex - 1);

                    // Display the details of the selected recipe
                    System.out.println("Recipe details:");
                    System.out.println("Name:" + selectedRecipe.getName());
                    System.out.println("Categories:" + selectedRecipe.getCategory());
                    System.out.println("Tags:" + selectedRecipe.getTag());
                    System.out.println("Cooking Instructions:" + selectedRecipe.getCookingInstructions());
                    System.out.println("Ingredients:" + selectedRecipe.getIngredients());
                    System.out.println("Serving Size:" + selectedRecipe.getServingSize());

                    System.out.println("Number of Ratings:" + selectedRecipe.getNumberOfRatings());
                    System.out.println("Avarage Rating:" + selectedRecipe.getAverageRating());
                    System.out.println("Impact: " + selectedRecipe.getImpact());
                    StringBuilder stars = new StringBuilder();
                    for (int i = 0; i < selectedRecipe.getImpact(); i++) {
                        stars.append("* ");
                    }
                    System.out.println("Rating: " + stars);
                }
            }
        } catch (Exception exception) {
            System.out.println("There is an exception: " + exception.getMessage());
        }
    }

    public static void rateRecipe() {
        try {
            List<Recipe> allRecipes = recipeManager.getAllRecipes();
            if (allRecipes.isEmpty()) {
                System.out.println("No recipes found.");
            } else {
                System.out.println("All Recipes:");
                for (int i = 0; i < allRecipes.size(); i++) {
                    System.out.println((i + 1) + ". " + allRecipes.get(i).getName());
                }
                System.out.print("Enter the index of the recipe you want to rate: ");
                int index = scanner.nextInt();
                scanner.nextLine();
                if (index < 1 || index > allRecipes.size()) {
                    System.out.println("Invalid index, please try again.");
                } else {
                    Recipe recipe = allRecipes.get(index - 1);
                    System.out.print("Enter a rating (1-5 stars) for the recipe: ");
                    int rating = scanner.nextInt();
                    scanner.nextLine();
                    recipeManager.rateRecipe(recipe, rating);
                    System.out.println("Rating added successfully.");
                }
            }
        } catch (Exception exception) {
            System.out.println("There is an exception: " + exception.getMessage());
        }
    }
    public static void modifyRecipe() {

        try {

            List<Recipe> allRecipes = recipeManager.getAllRecipes();
            if (allRecipes.isEmpty()) {
                System.out.println("No recipes found.");
            } else {
                System.out.println("All Recipes:");
                for (int i = 0; i < allRecipes.size(); i++) {
                    System.out.println((i + 1) + ". " + allRecipes.get(i).getName());
                }
                int index;
                while(true) {
                    System.out.print("Enter the index of the recipe you want to modify: ");
                    String a = scanner.nextLine();
                    try {
                        index = Integer.parseInt(a);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("please enter a integer value");
                    }
                }
                if (index < 1 || index > allRecipes.size()) {
                    System.out.println("Invalid index, please try again.");
                } else {
                    Recipe recipe = allRecipes.get(index - 1);

                    System.out.println("Modifying recipe: " + recipe.getName());
                    System.out.print("Enter new recipe name (or leave blank to keep the current name): ");
                    String newName = scanner.nextLine();
                    if (!newName.isEmpty()) {
                        recipe.setName(newName);
                    }

                    System.out.print("Enter serving size: ");
                    int servingSize = scanner.nextInt();
                    recipe.setServingSize(servingSize);
                    scanner.nextLine();

                    System.out.print("Enter new ingredients (comma separated list): ");
                    List<String> ingredients = Arrays.asList(scanner.nextLine().split(","));
                    recipe.setIngredients(ingredients);

                    System.out.print("Enter new cooking instructions (comma separated list): ");
                    List<String> cookingInstructions = Arrays.asList(scanner.nextLine().split(","));
                    recipe.setCookingInstructions(cookingInstructions);

                    // Category
                    System.out.println("Choose new category:");
                    System.out.println("1. " + Category.APPETIZER.name());
                    System.out.println("2. " + Category.MAIN_DISH.name());
                    System.out.println("3. " + Category.DESSERT.name());
                    int categoryChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (categoryChoice) {
                        case 1:
                            recipe.setCategory(Category.APPETIZER);
                            break;
                        case 2:
                            recipe.setCategory(Category.MAIN_DISH);
                            break;
                        case 3:
                            recipe.setCategory(Category.DESSERT);
                            break;
                        default:
                            System.out.println("Invalid choice, defaulting to appetizers.");
                            recipe.setCategory(Category.APPETIZER);
                            break;
                    }
                    //Tag
                    System.out.println("Choose a tag:");
                    System.out.println("1. " + Tag.GLUTENFREE.name());
                    System.out.println("2. " + Tag.SPICY.name());
                    System.out.println("3. " + Tag.VEGATARIAN.name());
                    int tagChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (tagChoice) {
                        case 1:
                            recipe.setTag(Tag.GLUTENFREE);
                            break;
                        case 2:
                            recipe.setTag(Tag.SPICY);
                            break;
                        case 3:
                            recipe.setTag(Tag.VEGATARIAN);
                            break;
                        default:
                            System.out.println("Invalid choice, defaulting to vegatarian.");
                            recipe.setTag(Tag.VEGATARIAN);
                            break;
                    }
                }
            }

        } catch (Exception exception) {
            System.out.println("There is an exception: " + exception.getMessage());
        }
    }


}