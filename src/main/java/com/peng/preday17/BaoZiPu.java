package com.peng.preday17;

public class BaoZiPu {

    private int count;
    private boolean flag;

    public BaoZiPu(int count, boolean flag) {
        this.count = count;
        this.flag = flag;
    }


    public void getCount() {
        System.out.println("消费了第......"+count+"个包子");
    }

    /**
     *改造set方法,给生产者用
     */
    public void setCount() {
        count++;
        System.out.println("生产了第..."+count+"个包子");
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public static void main(String[] args) {
        BaoZiPu baoZiPu = new BaoZiPu(0, false);

        Product product = new Product(baoZiPu);
        Consumer consumer = new Consumer(baoZiPu);

        new Thread( product ).start();
        new Thread(consumer).start();

    }

}
