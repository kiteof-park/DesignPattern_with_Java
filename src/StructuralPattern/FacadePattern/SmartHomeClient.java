package StructuralPattern.FacadePattern;

// 📌 Facade를 이용하는 클라이언트 코드
public class SmartHomeClient {
    public static void main(String[] args) {
        Thermostat thermostat = new Thermostat();
        Lights lights = new Lights();
        CoffeeMaker coffeeMaker = new CoffeeMaker();

        /*
        * 📌 'SmartHomeFacade'로 클라이언트는 모든 기기를 다룰 수 있음
        * 클라이언트는 각각 내부 클래스 내부 구현에 대해 알 필요가 없음
        * Facade의 통합되고 단순한 인터페이스를 통해 필요한 기능을 모두 수행
        * 서브 시스템이 변경되더라도 클라이언트 코드가 아닌 Facade만 변경하면 됨 -> 설계에 유연
        * */
        SmartHomeFacade smartHome = new SmartHomeFacade(thermostat, lights, coffeeMaker);

        smartHome.wakeUp();
        smartHome.leaveHome();
    }
}
