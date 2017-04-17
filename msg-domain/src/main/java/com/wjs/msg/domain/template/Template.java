package com.wjs.msg.domain.template;

import com.wjs.common.base.base.BaseEntity;
import com.wjs.msg.domain.group.Group;
import com.wjs.msg.domain.router.Router;
import com.wjs.msg.domain.sender.Sender;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

import static com.wjs.common.base.util.FreemarkerUtil.parseString4Map;


/**
 * Created by panqingqing on 16/7/6.
 */
@Setter
@Getter
public class Template extends BaseEntity {
    private Group group;
    private String context;
    private Router router;
    private String protocol;

    public Template() {
    }

    public List<Sender> chooseSender() {
        return router.chooseSender(protocol);
    }

    public String parseContext(Map<String, Object> paramMap) {
        return parseString4Map(context, paramMap);
    }
}
