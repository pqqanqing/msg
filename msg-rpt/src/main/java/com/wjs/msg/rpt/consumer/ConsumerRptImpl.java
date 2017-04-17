package com.wjs.msg.rpt.consumer;

import com.wjs.common.base.rpt.BaseRptImpl;
import com.wjs.msg.domain.consumer.Consumer;
import com.wjs.msg.domain.consumer.ConsumerRpt;
import com.wjs.msg.domain.msg.Msg;
import com.wjs.msg.domain.sender.Sender;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * Created by panqingqing on 16/7/6.
 */
@Repository
public class ConsumerRptImpl extends BaseRptImpl<Consumer, Serializable> implements ConsumerRpt {

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Consumer createConsumer(Msg msg, String contact, Sender sender) {
        Consumer consumer = sender.getConsumer();
        consumer.setMsg(msg);
        consumer.setContact(contact);
        consumer.setSender(sender);
        save(consumer);
        return consumer;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void sendMsg(Long id) {
        Consumer Consumer = getById(id);
        Consumer.send();
    }
}
