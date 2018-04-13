package com.zhl.springAnnotation;

/**
 * 测试导入组件import
 * Created by zhl on 18/3/25 下午5:43.
 */
public class Color {

    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Color{" +
                "car=" + car +
                '}';
    }
}
