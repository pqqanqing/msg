package com.wjs.msg.domain.consumer;


import com.wjs.common.base.rpt.BaseRpt;
import com.wjs.msg.domain.msg.Msg;
import com.wjs.msg.domain.sender.Sender;

import java.io.Serializable;

/**
 * Created by panqingqing on 16/7/6.
 */
public interface ConsumerRpt extends BaseRpt<Consumer, Serializable> {

    Consumer createConsumer(Msg msg, String contact, Sender sender);

    void sendMsg(Long id);
}