public record Tag(String name) {
    public static final Tag SPICY = new Tag("SPICY");
    public static final Tag GLUTENFREE = new Tag("GLUTEN-FREE");
    public static final Tag VEGATARIAN = new Tag("VEGATERIAN");

    @Override
    public String toString() {
        return name;
    }
}
