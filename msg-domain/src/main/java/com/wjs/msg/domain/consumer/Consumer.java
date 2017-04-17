package com.wjs.msg.domain.consumer;

import com.wjs.common.base.base.BaseEntity;
import com.wjs.msg.domain.consumer.status.ConsumerStatus;
import com.wjs.msg.domain.consumer.status.ConsumerStatus4Waiting;
import com.wjs.msg.domain.msg.Msg;
import com.wjs.msg.domain.sender.Sender;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by panqingqing on 16/7/6.
 */
@Setter
@Getter
public abstract class Consumer extends BaseEntity<ConsumerStatus> {
    protected Msg msg;
    protected Sender sender;
    protected String contact;
    protected Date sendDate;

    public Consumer() {
        this.status = ConsumerStatus4Waiting.getInstance();
    }

    public void send() {
        if (!status.isWait()) return;
        this.sendDate = new Date();
        this.status = doSend() == true ? status.succ() : status.fail();
    }

    protected abstract boolean doSend();

    public boolean isNeedRetry() {
        return status.isNeedRetry();
    }
}