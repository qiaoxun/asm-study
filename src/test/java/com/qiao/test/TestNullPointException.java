package com.qiao.test;

public class TestNullPointException {
    public static void main(String[] args) {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            System.out.println("times: " + i + ", result = " + testExceptionTrunc());
        }
    }

    public static boolean testExceptionTrunc()  {
        try {
            // 人工构造异常抛出的场景
            ((Object)null).getClass();
        } catch (Exception e) {
            if (e.getStackTrace().length == 0) {
                try {
                    // 堆栈消失的时候当前线程休眠5秒，便于观察
                    Thread.sleep(5000);
                } catch (InterruptedException interruptedException) {
                    // do nothing
                }
                return true;
            } else {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        }
        return false;
    }
}
