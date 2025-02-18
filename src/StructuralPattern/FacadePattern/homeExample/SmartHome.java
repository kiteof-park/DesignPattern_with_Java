package StructuralPattern.FacadePattern.homeExample;

public class SmartHome {
    public void hello(){
        System.out.println("hello");
    }
}

// 온도 조절기
class Thermostat{
    public void setTemperature(int temperature){
        System.out.println("Setting thermostat to " + temperature);
    }
}

// 조명
class Lights{
    public void on(){
        System.out.println("Lights are on");
    }

    public void off(){
        System.out.println("Lights are off");
    }
}

// 커피 머신
class CoffeeMaker{
    public void brewCoffee(){
        System.out.println("Brewing coffee");
    }
}