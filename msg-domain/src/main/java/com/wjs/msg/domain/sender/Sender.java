package com.wjs.msg.domain.sender;


import com.wjs.common.base.base.BaseEntity;
import com.wjs.common.base.util.ClassUtil;
import com.wjs.common.base.util.ScanClassUtil;
import com.wjs.msg.domain.consumer.Consumer;
import com.wjs.msg.domain.consumer.SimulateConsumer;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by panqingqing on 16/7/6.
 */
@Setter
@Getter
public class Sender extends BaseEntity {
    private String protocol;
    private boolean isSimulate;

    public Consumer getConsumer() {
        if (isSimulate) return new SimulateConsumer();
        // TODO: 2017/4/17 修改 
        return (Consumer) ClassUtil.newInstance(ScanClassUtil.getClassMap().get(Consumer.class + protocol).getClass());
    }
}
