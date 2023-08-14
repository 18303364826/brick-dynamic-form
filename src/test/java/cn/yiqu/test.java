package cn.yiqu;

import cn.ifloat.brick.chinses.py.PinYinKit;
import org.junit.Test;

public class test {

    @Test
    public void test1() {
        String acconymUpcase = PinYinKit.acconymUpcase("张恒通", "_");
        String acronym = PinYinKit.acronym("张恒通", "_");
        String full = PinYinKit.full("张恒通", "_");
        String fullWithTonl = PinYinKit.fullWithTonl("张恒通", "_");
        System.out.println("fullWithTonl = " + fullWithTonl);
        System.out.println("full = " + full);
        System.out.println("acronym = " + acronym);
        System.out.println("acconymUpcase = " + acconymUpcase);
    }
}
