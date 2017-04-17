package com.wjs.msg.domain.group;

import com.wjs.common.base.base.BaseEntity;
import com.wjs.msg.domain.template.Template;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by panqingqing on 16/7/6.
 */
@Setter
@Getter
public class Group extends BaseEntity {
    private Map<String, Template> templates = new HashMap<>();

    public Group() {
    }

    public Template getTemplate(String protocol) {
        return templates.get(protocol);
    }
}
