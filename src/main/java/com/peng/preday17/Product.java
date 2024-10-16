package com.peng.preday17;

public class Product implements Runnable{
    private BaoZiPu baoZiPu;

    public Product(BaoZiPu baoZiPu) {
        this.baoZiPu = baoZiPu;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (baoZiPu){
                //如果flag为true,证明有包子,生产线程等待
                if (baoZiPu.isFlag()==true) {
                    try {
                        baoZiPu.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                //如果出了if证明没有包子,就要生产包子
                baoZiPu.setCount();

                //改变flag状态,改为true,证明有包子了
                baoZiPu.setFlag(true);

                //唤醒消费线程
                baoZiPu.notify();
            }
        }
    }

}







