## Facade 패턴
- `Facade`패턴은 드라이브 스루와 같다 !
  - 손님들은 내부 구조를 알 필요없이 창구를 통해 모든 서비스를 제공받는다. 
- 여러 요소들로 복잡하게 구성된 시스템을 하나의 창구를 통해 간단하게 사용할 수 있도록 해주는 패턴

### Facade 패턴의 구성요소
- ✅ 다수의 클래스로 구성된 서브 시스템
- ✅ 이들을 **하나의 창구**로 묶어주는 `Facade` 역할의 클래스
- ✅ `Facade`를 통해 기능들을 사용하는 클라이언트

## Facade 패턴 예제
- 온도 조절기, 조명, 커피머신이 있는 집주인은 매일 아침: 
  - 온도를 조절하고
  - 불을 켜고
  - 커피를 내린다.
- 그러기 위해서는 이 기기들을 하나하나 직접 조작해야 한다.
```java
// 온도 조절기
public class Thermostat{
    public void setTemperature(int temperature){
        System.out.println("Setting thermostat to " + temperature);
    }
}

// 조명
public class Lights{
    public void on(){
        System.out.println("Lights are on");
    }

    public void off(){
        System.out.println("Lights are off");
    }
}

// 커피 머신
public class CoffeeMaker{
    public void brewCoffee(){
        System.out.println("Brewing coffee");
    }
}
```
### Facade 
- 버튼 하나만 누르면 여러 기기가 한번에 작동할 수는 없을까?
- 각 기기별로 만든 클래스의 객체들을 Facade 클래스의 필드로 가지도록 함
```java
public class SmartHomeFacade {
    // 📌 각 클래스를 필드로 가지는 Facade 클래스(Facade 역할)
    private Thermostat thermostat;
    private Lights lights;
    private CoffeeMaker coffeeMaker;

    public SmartHomeFacade(Thermostat thermostat, 
                           Lights lights, 
                           CoffeeMaker coffeeMaker){
        this.thermostat = thermostat;
        this.lights = lights;
        this.coffeeMaker = coffeeMaker;
    }

    // 📌 버튼 하나로 모든 클래스들을 조작할 수 있음
    public void wakeUp(){
        System.out.println("Waking up,,");
        thermostat.setTemperature(25);
        lights.on();
        coffeeMaker.brewCoffee();
    }

    public void leaveHome(){
        System.out.println("Leaving home,,");
        thermostat.setTemperature(20);
        lights.off();
    }
}
```
### Facade Client
- 클라이언트는 Facade(`smartHome`)를 통해서만 명령을 내림
- 클라이언트는 서브 시스템 클래스들 각각 내부 구현에 대해 자세히 알 필요가 없음
  - 서브 시스템 클래스 : 🌡️Thermostat, 💡Lights, ☕CoffeeMaker
- **클라이언트는 Facade의 통합되고 단순한 인터페이스를 통해 필요한 기능들을 모두 수행**
- 서브 시스템이 변경되더라도 클라이언트 코드는 변경❌(Facade만 변경) *- 변경 최소화, 설계 유연성*
```java
// 📌 Facade를 이용하는 클라이언트 코드
public class SmartHomeClient {
    public static void main(String[] args) {
        Thermostat thermostat = new Thermostat();
        Lights lights = new Lights();
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        
        SmartHomeFacade smartHome = new SmartHomeFacade(thermostat, lights, coffeeMaker);

        smartHome.wakeUp();
        smartHome.leaveHome();
    }
}
```