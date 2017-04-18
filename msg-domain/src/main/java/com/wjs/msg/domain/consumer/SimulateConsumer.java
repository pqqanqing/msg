package com.wjs.msg.domain.consumer;

import com.wjs.common.base.annotation.StatusAndClassNum;

import static com.wjs.msg.api.dto.ConsumerDTO.TYPE_SIMULATE;

/**
 * Created by panqingqing on 16/7/8.
 */
@StatusAndClassNum(superClass = Consumer.class, number = TYPE_SIMULATE, describe = "模拟", parasitClass = Consumer.class)
public class SimulateConsumer extends Consumer {

    public SimulateConsumer() {
    }

    @Override
    public boolean doSend() {
        return true;
    }

}