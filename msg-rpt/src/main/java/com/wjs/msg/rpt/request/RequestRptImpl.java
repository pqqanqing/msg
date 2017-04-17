package com.wjs.msg.rpt.request;

import com.wjs.common.base.rpt.BaseRptImpl;
import com.wjs.msg.domain.request.Request;
import com.wjs.msg.domain.request.RequestRpt;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by panqingqing on 16/7/6.
 */
@Repository
public class RequestRptImpl extends BaseRptImpl<Request, Serializable> implements RequestRpt {
}
