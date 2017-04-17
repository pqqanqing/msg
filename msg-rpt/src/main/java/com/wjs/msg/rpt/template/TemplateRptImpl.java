package com.wjs.msg.rpt.template;

import com.wjs.common.base.rpt.BaseRptImpl;
import com.wjs.msg.domain.template.Template;
import com.wjs.msg.domain.template.TemplateRpt;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by panqingqing on 16/7/6.
 */
@Repository("templateRpt")
public class TemplateRptImpl extends BaseRptImpl<Template, Serializable> implements TemplateRpt {
}
