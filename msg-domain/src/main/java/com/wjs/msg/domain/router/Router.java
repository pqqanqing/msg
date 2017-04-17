package com.wjs.msg.domain.router;

import com.wjs.common.base.base.BaseEntity;
import com.wjs.msg.domain.sender.Sender;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by panqingqing on 16/7/6.
 */
@Setter
@Getter
public class Router extends BaseEntity {
    private List<Sender> senders = new ArrayList<>();

    public List<Sender> chooseSender(String protocol) {
        List<Sender> chooseSenders = new ArrayList<>();
        senders.stream().forEach(sender -> {
            if (sender.getProtocol().equals(protocol)) chooseSenders.add(sender);
        });
        return chooseSenders;
    }
}
