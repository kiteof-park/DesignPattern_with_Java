package CreationalPattern.FactoryMethod.productExample;

public class Clothing implements Product {
    @Override
    public void create() {
        System.out.println("Clothing product created.");
    }
}
