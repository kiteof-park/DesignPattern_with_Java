package CreationalPattern.FactoryMethod.vehicleExample;

public abstract class VehicleFactory {

    // Factory Method - 인터페이스 Vehicle을 생성하는 메서드
    public abstract Vehicle createVehicle();

    public void deliverVehicle(){
        Vehicle vehicle = createVehicle();
        System.out.println("Delivering vehicle: ");
        vehicle.drive();
    }
}
