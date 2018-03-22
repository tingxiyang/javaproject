package com.zhl.designPattern;

/**
 * Created by zhl on 18/3/21 上午11:37.
 */

//二、工厂方法模式（以汽车制造为列）

//汽车接口
interface ICar{
    public void run();
}

//奔驰车
class BenzCar implements ICar {
    public void run(){
        System.out.println("Benz car run");
    }
}
//宝马车
class BMWCar implements ICar {
    @Override
    public void run() {
        System.out.println("BMW car run");
    }
}

//抽象汽车工厂
abstract class CarFactory{
    public abstract ICar createCar();
}

//奔驰车工厂
class BenzCarFactory extends CarFactory {
    @Override
    public ICar createCar() {
        return new BenzCar();
    }
}
//宝马车工厂
class BMWCarFactory extends CarFactory {
    @Override
    public ICar createCar() {
        return new BMWCar();
    }
}



public class FactoryMethodDemo {
    public static void main(String[] args) {
        CarFactory factory = new BenzCarFactory();
        ICar car = factory.createCar();
        car.run();
        factory = new BMWCarFactory();
        car = factory.createCar();
        car.run();
    }
}
