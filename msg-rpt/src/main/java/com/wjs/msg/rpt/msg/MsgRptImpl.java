package com.wjs.msg.rpt.msg;

import com.wjs.common.base.rpt.BaseRptImpl;
import com.wjs.msg.domain.msg.Msg;
import com.wjs.msg.domain.msg.MsgRpt;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by panqingqing on 16/7/6.
 */
@Repository
public class MsgRptImpl extends BaseRptImpl<Msg, Serializable> implements MsgRpt {
}
