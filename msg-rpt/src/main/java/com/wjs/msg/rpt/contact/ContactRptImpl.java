package com.wjs.msg.rpt.contact;

import com.wjs.common.base.rpt.BaseRptImpl;
import com.wjs.msg.domain.contact.Contact;
import com.wjs.msg.domain.contact.ContactRpt;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by panqingqing on 16/7/6.
 */
@Repository
public class ContactRptImpl extends BaseRptImpl<Contact, Serializable> implements ContactRpt {

}
