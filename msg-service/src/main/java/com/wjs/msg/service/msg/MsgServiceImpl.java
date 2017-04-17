package com.wjs.msg.service.msg;

import com.wjs.common.base.thread.ThreadPool;
import com.wjs.msg.api.dto.RequestDTO;
import com.wjs.msg.domain.request.Request;
import com.wjs.msg.domain.request.RequestRpt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by panqingqing on 16/7/6.
 */
@Service("msgService")
public class MsgServiceImpl implements MsgService {

    private static ThreadPool threadPool = new ThreadPool(2, 10, 100);

    @Resource(name = "msgService")
    private MsgService msgService;
    @Autowired
    private RequestRpt requestRpt;

    @Override
    public void monitorActiveMQ(String message) {
        RequestDTO request = msgService.makeRequest(message);
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                msgService.sendMsg(request.getId());
            }
        });
    }

    @Override
    @Transactional
    public RequestDTO makeRequest(String message) {
        Request request = new Request(message);
        request.generateMsgs();
        requestRpt.save(request);
        return request.makeDTO();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void sendMsg(Long id) {
        Request request = requestRpt.getById(id);
        request.sendMsg();
    }

}