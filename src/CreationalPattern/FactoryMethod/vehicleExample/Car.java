package CreationalPattern.FactoryMethod.vehicleExample;

// 인스턴스로 만들어져 사용될 것을 목적으로 하는 클래스
public class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving Car\uD83D\uDE97");
    }
}
