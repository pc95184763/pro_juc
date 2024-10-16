package com.peng.preday17;

public class Consumer implements Runnable {

    private BaoZiPu baoZiPu;

    public Consumer(BaoZiPu baoZiPu) {
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
                //如果flag为false,证明没有包子,消费线程等待
                if (baoZiPu.isFlag()==false){
                    try {
                        baoZiPu.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                //如果出了if证明有包子,就要消费包子
                baoZiPu.getCount();

                //改变flag状态,改为false,证明没有包子了
                baoZiPu.setFlag(false);

                //唤醒生产线程
                baoZiPu.notify();
            }
        }
    }
}




