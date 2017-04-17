package com.wjs.msg.rpt.sender;

import com.wjs.common.base.rpt.BaseRptImpl;
import com.wjs.msg.domain.sender.Sender;
import com.wjs.msg.domain.sender.SenderRpt;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by panqingqing on 16/7/6.
 */
@Repository
public class SenderRptImpl extends BaseRptImpl<Sender, Serializable> implements SenderRpt {
}
