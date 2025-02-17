package StructuralPattern.FacadePattern;

public class SmartHomeFacade {
    // 📌 각 클래스를 필드로 가지는 Facade 클래스(Facade 역할)
    private Thermostat thermostat;
    private Lights lights;
    private CoffeeMaker coffeeMaker;

    public SmartHomeFacade(Thermostat thermostat, Lights lights, CoffeeMaker coffeeMaker){
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
