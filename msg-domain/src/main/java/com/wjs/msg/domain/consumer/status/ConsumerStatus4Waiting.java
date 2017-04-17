package com.wjs.msg.domain.consumer.status;

import com.wjs.common.base.annotation.StatusAndClassNum;
import com.wjs.msg.api.dto.ConsumerDTO;
import com.wjs.msg.domain.consumer.Consumer;


/**
 * Created by panqingqing on 16/7/13.
 */
@StatusAndClassNum(superClass = ConsumerStatus.class, number = ConsumerDTO.STATUS_WAITING, describe = "待消费", parasitClass = Consumer.class)
public class ConsumerStatus4Waiting extends ConsumerStatus {

    private static ConsumerStatus instance = new ConsumerStatus4Waiting();

    private ConsumerStatus4Waiting() {
    }

    public static ConsumerStatus getInstance() {
        return instance;
    }

    @Override
    public ConsumerStatus succ() {
        return ConsumerStatus4Succ.getInstance();
    }

    @Override
    public ConsumerStatus fail() {
        return ConsumerStatus4Fail.getInstance();
    }

    @Override
    public boolean isWait() {
        return true;
    }
}


