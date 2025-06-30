package lambda;

public class TestChef {
    public static void main(String[] args) {
        Recipe chefRecipe = new Chef();

        Recipe instantRecipe = new Recipe() {
            public void cook() {
                System.out.println("Instant Recipe");
            }
        };

        Recipe lambdaRecipe = () -> System.out.println("Instant Recipe");
    }
}
