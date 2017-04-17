package com.wjs.msg.rpt.router;

import com.wjs.common.base.rpt.BaseRptImpl;
import com.wjs.msg.domain.router.Router;
import com.wjs.msg.domain.router.RouterRpt;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by panqingqing on 16/7/6.
 */
@Repository
public class RouterRptImpl extends BaseRptImpl<Router, Serializable> implements RouterRpt {
}
