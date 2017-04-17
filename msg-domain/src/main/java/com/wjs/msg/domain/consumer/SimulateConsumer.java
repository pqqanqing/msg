package com.wjs.msg.domain.consumer;

import com.wjs.common.base.annotation.StatusAndClassNum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

import static com.wjs.msg.api.dto.ConsumerDTO.TYPE_SIMULATE;

/**
 * Created by panqingqing on 16/7/8.
 */
@StatusAndClassNum(superClass = Consumer.class, number = TYPE_SIMULATE, describe = "模拟", parasitClass = Consumer.class)
public class SimulateConsumer extends Consumer {
    private Logger logger = LoggerFactory.getLogger(SimulateConsumer.class);
    private Properties properties = new Properties();

    public SimulateConsumer() {
    }

    @Override
    public boolean doSend() {
        return true;
    }

}