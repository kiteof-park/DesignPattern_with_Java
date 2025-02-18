package CreationalPattern.FactoryMethod.productExample;

public class Book implements Product {
    @Override
    public void create() {
        System.out.println("Book product created.");
    }
}
