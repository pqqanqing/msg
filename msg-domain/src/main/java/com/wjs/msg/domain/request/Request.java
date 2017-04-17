package com.wjs.msg.domain.request;

import com.alibaba.fastjson.JSONObject;
import com.wjs.common.base.base.BaseEntity;
import com.wjs.common.base.execption.BusinessExecption;
import com.wjs.common.base.spring.SpringBeanContext;
import com.wjs.msg.api.dto.RequestDTO;
import com.wjs.msg.domain.contact.Contact;
import com.wjs.msg.domain.group.Group;
import com.wjs.msg.domain.group.GroupRpt;
import com.wjs.msg.domain.msg.Msg;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.wjs.common.base.mq.MsgSend.*;
import static com.wjs.common.base.util.BeanPropertiesUtil.copyProperties;

/**
 * Created by panqingqing on 16/7/6.
 */
@Setter
@Getter
public class Request extends BaseEntity {
    private String message;
    private Group group;
    private List<Contact> contacts = new ArrayList<>();
    private List<Msg> msgs = new ArrayList<>();

    //上面message已经入库了,下面这些就不入库了
    private Long groupId;
    private List<String> contactList;
    private Map<String, Object> paramMap;

    public Request() {
    }

    public Request(String message) {
        this.message = message;
        checkMessage(message);
        parseMessage();
    }

    private void checkMessage(String message) {
        Map map = JSONObject.parseObject(message, Map.class);
        this.groupId = ((Integer) map.get(KEY_GROUP)).longValue();
        if (groupId == null) throw new BusinessExecption("msg2");
        this.contactList = (List<String>) map.get(KEY_CONTACTS);
        this.paramMap = (Map<String, Object>) map.get(KEY_PARAMS);
    }

    private void parseMessage() {
        parseGroup();
        parseContactList();
    }

    private void parseGroup() {
        GroupRpt groupRpt = SpringBeanContext.getBean(GroupRpt.class);
        this.group = groupRpt.getById(groupId);
    }

    private void parseContactList() {
        for (String contact : contactList) {
            Contact c = new Contact(this, contact);
            addContact(c);
        }
    }

    public void generateMsgs() {
        Map<String, List<String>> map = generateMap();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            Msg msg = new Msg(this, group.getTemplate(entry.getKey()), paramMap, entry.getValue());
            addMsg(msg);
        }
    }

    private Map<String, List<String>> generateMap() {
        Map<String, List<String>> map = new HashMap<>();
        for (Contact contact : contacts) {
            String protocol = contact.getProtocol();
            List<String> list = map.get(protocol);
            if (list == null) list = new ArrayList<>();
            list.add(contact.getContactStr());
            map.put(protocol, list);
        }
        return map;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void addMsg(Msg msg) {
        msgs.add(msg);
    }

    public void sendMsg() {
        for (Msg msg : msgs) {
            msg.send();
        }
    }

    public RequestDTO makeDTO() {
        return copyProperties(this, RequestDTO.class);
    }

}
