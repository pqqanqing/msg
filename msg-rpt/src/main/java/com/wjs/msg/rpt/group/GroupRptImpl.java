package com.wjs.msg.rpt.group;

import com.wjs.common.base.rpt.BaseRptImpl;
import com.wjs.msg.domain.group.Group;
import com.wjs.msg.domain.group.GroupRpt;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by panqingqing on 16/7/6.
 */
@Repository
public class GroupRptImpl extends BaseRptImpl<Group, Serializable> implements GroupRpt {
}
