public record Category(String name) {
    public static final Category DESSERT = new Category("Desserts");

    public static final Category MAIN_DISH = new Category("Main Dishes");
    public static final Category APPETIZER = new Category("Appetizers");

    @Override
    public String toString() {
        return name;
    }
}
