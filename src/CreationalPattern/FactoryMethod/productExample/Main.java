package CreationalPattern.FactoryMethod.productExample;

public class Main {
    public static void main(String[] args) {
        ProductFactory factory = new ConcreteProductFactory();

        Product electronics = factory.orderProduct("electronics");
        Product clothing = factory.orderProduct("clothing");
        Product book = factory.orderProduct("book");
    }
}
