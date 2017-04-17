package com.wjs.msg.domain.consumer.status;

import com.wjs.common.base.annotation.StatusAndClassNum;
import com.wjs.msg.api.dto.ConsumerDTO;
import com.wjs.msg.domain.consumer.Consumer;

/**
 * Created by panqingqing on 16/7/13.
 */
@StatusAndClassNum(superClass = ConsumerStatus.class, number = ConsumerDTO.STATUS_FAIL, describe = "消费失败", parasitClass = Consumer.class)
public class ConsumerStatus4Fail extends ConsumerStatus {

    private static ConsumerStatus instance = new ConsumerStatus4Fail();

    private ConsumerStatus4Fail() {
    }

    public static ConsumerStatus getInstance() {
        return instance;
    }

    @Override
    public boolean isNeedRetry() {
        return true;
    }
}


