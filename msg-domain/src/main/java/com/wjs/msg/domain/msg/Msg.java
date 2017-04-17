package com.wjs.msg.domain.msg;

import com.wjs.common.base.base.BaseEntity;
import com.wjs.common.base.spring.SpringBeanContext;
import com.wjs.common.base.thread.ThreadPool;
import com.wjs.msg.domain.consumer.Consumer;
import com.wjs.msg.domain.consumer.ConsumerRpt;
import com.wjs.msg.domain.request.Request;
import com.wjs.msg.domain.sender.Sender;
import com.wjs.msg.domain.template.Template;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by panqingqing on 16/7/6.
 */
@Setter
@Getter
public class Msg extends BaseEntity {
    private static ThreadPool threadPool = new ThreadPool(5, 20, 10000);
    private Request request;
    private Template template;
    private String context;
    private List<String> contactList = new ArrayList<>();

    public Msg() {

    }

    public Msg(Request request, Template template, Map<String, Object> paramMap, List<String> contactList) {
        this.request = request;
        this.template = template;
        this.context = template.parseContext(paramMap);
        this.contactList = contactList;
    }

    public void send() {
        List<Sender> senders = template.chooseSender();
        contactList.stream().forEach(contact -> {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    ConsumerRpt consumerRpt = SpringBeanContext.getBean(ConsumerRpt.class);
                    for (Sender sender : senders) {
                        Consumer consumer = consumerRpt.createConsumer(Msg.this, contact, sender);
                        consumerRpt.sendMsg(consumer.getId());
                        if (consumer.isNeedRetry()) break;
                    }
                }
            });
        });
    }
}
