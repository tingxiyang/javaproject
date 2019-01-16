package com.zhl.designModel.adapter;

/**
 * Created by zhl on 19/1/14 下午3:55.
 * 既可以画圆，又可以画方的适配器
 */
public class HybridShape implements ICircle, ISquare{

    private ICircle iCircle;
    private ISquare iSquare;

    public HybridShape(Circle circle) {
        this.iCircle = circle;
    }
    public HybridShape(Square square) {
        this.iSquare = square;
    }

    @Override
    public void drawCircle() {
        iCircle.drawCircle();
    }

    @Override
    public void drawSquare() {
        iSquare.drawSquare();
    }
}
