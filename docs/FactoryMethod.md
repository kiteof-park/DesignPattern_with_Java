## Factory Method 패턴
- 클래스와 클라이언트 간 직접 연결❌ _- 클라이언트에서 클래스의 생성자를 직접 실행❌_
- Factory Method 패턴은 클래스와 클라이언트 사이에 Factory라는 중간자를 둠
- 클라이언트는 클래스가 아닌 Factory와 연결
- 클래스의 인스턴스를 생성하고, 필요시 특정 방식으로 처리하는 일을 Factory에 위임

## Factory Method 예제
📂 `Vehicle.java`
```java
public interface Vehicle {
    void drive();
}
```
📂 `Car.java` **_- 인스턴스로 만들어져 사용될 것을 목적으로 하는 클래스_**
```java
public class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving Car🚗");
    }
}
```
📂 `Motorcycle.java` **_- 인스턴스로 만들어져 사용될 것을 목적으로 하는 클래스_**
```java
public class Motorcycle implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Riding Motorcycle🏍️");
    }
}
```

### ✨ Factory Method 패턴 적용
- 일반적으로 클라이언트에서 클래스들의 생성자가 직접 호출되어 인스턴스 생성
- Factory Method 패턴에서는 `Vehicle`, `Car`, `Motorcycle` 각각의 Factory 클래스를 생성

📂 `VehicleFactory.java` - **_인터페이스 Vehicle 객체를 생성하는 추상 클래스_**
- `Vehicle`의 인스턴스를 필드로 가짐으로써 Vehicle과 직접 연결
- `deliverVehicle()`에서 자식 클래스들이 구현한대로   
  `Car` 또는 `Motorcycle`의 인스턴스가 생성되어 저장
```java
public abstract class VehicleFactory {
    
    public abstract Vehicle createVehicle();

    public void deliverVehicle(){
        Vehicle vehicle = createVehicle();
        System.out.println("Delivering vehicle: ");
        vehicle.drive();
    }
}
```

📂 `CarFactory.java`
```java
public class CarFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }
}
```


📂 `MotorcycleFactory.java`
```java
public class MotorcycleFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Motorcycle();
    }
}
```

### Factory Method 핵심
- **어느 클래스의 객체가 만들어져 사용될지를 전적으로 팩토리에 위임**해  
클라이언트 코드는 변화에 영향을 받지 않는 독립된 요소로 분리