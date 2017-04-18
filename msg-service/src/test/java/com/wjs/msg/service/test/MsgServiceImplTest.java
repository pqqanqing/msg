package com.wjs.msg.service.test;

import com.wjs.common.base.mq.MsgSend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml", "classpath*:applicationContext-activemq-test.xml"})
public class MsgServiceImplTest {

    @Autowired
    private MsgSend msgSend;

    @Test
    public void testSendMsg() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "潘清清");
        List<String> contacts = new ArrayList<>();
        contacts.add("email://pqqanqing");
        contacts.add("email://pqqkmust");
        contacts.add("email://pqq");
        contacts.add("simulate://15601870404");
        contacts.add("simulate://15601870405");
        msgSend.sendMsg(1L, map, contacts);
    }
}
