package com.wjs.msg.domain.consumer.status;


import com.wjs.common.base.annotation.StatusAndClassNum;
import com.wjs.msg.api.dto.ConsumerDTO;
import com.wjs.msg.domain.consumer.Consumer;

/**
 * Created by panqingqing on 16/7/13.
 */
@StatusAndClassNum(superClass = ConsumerStatus.class, number = ConsumerDTO.STATUS_SUCC, describe = "消费成功", parasitClass = Consumer.class)
public class ConsumerStatus4Succ extends ConsumerStatus {

    private static ConsumerStatus instance = new ConsumerStatus4Succ();

    private ConsumerStatus4Succ() {
    }

    public static ConsumerStatus getInstance() {
        return instance;
    }
}


