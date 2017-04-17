package com.wjs.msg.service.msg;

import com.wjs.msg.api.dto.RequestDTO;

/**
 * Created by panqingqing on 16/7/6.
 */
public interface MsgService {

    void monitorActiveMQ(String message);

    RequestDTO makeRequest(String message);

    void sendMsg(Long id);
}
