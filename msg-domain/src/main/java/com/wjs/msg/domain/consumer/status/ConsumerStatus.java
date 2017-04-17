package com.wjs.msg.domain.consumer.status;

import com.wjs.common.base.base.BaseObject;

/**
 * Created by panqingqing on 16/7/13.
 */
public abstract class ConsumerStatus extends BaseObject {

    public ConsumerStatus waiting() {
        throw new RuntimeException("当前状态[" + this + "]不能转换为待消费状态!");
    }

    public ConsumerStatus succ() {
        throw new RuntimeException("当前状态[" + this + "]不能转换为成功状态!");
    }

    public ConsumerStatus fail() {
        throw new RuntimeException("当前状态[" + this + "]不能转换为失败状态!");
    }

    public boolean isWait() {
        return false;
    }

    public boolean isNeedRetry() {
        return false;
    }
}