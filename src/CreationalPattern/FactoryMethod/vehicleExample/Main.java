package CreationalPattern.FactoryMethod.vehicleExample;


// 클라이언트 코드
public class Main {
    public static void main(String[] args) {
        // Car, Motorcycle은 클라이언트 코드에서 직접 사용❌
            // Car, Motorcycle의 Factory만 생성됨
            // 오버라이드한 deliverVehicle()을 실행하면, Car와 Motocycle의  drive() 실행
        VehicleFactory carFactory = new CarFactory();
        carFactory.deliverVehicle();

        VehicleFactory motorcycleFactory = new MotorcycleFactory();
        motorcycleFactory.deliverVehicle();
    }
}
