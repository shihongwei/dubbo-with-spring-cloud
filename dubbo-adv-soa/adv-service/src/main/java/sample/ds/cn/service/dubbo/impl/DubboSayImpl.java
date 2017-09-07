package sample.ds.cn.service.dubbo.impl;

import sample.ds.cn.service.DubboSay;

/**
 * Created by wu on 17/9/6.
 */
public class DubboSayImpl implements DubboSay {
    @Override
    public String dubboSayHello(String word) {
        return "hello dubbo. " + "hello " + word;
    }
}
