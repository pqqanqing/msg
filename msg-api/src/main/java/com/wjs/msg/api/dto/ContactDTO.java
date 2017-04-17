package com.wjs.msg.api.dto;

import com.wjs.common.base.base.BaseDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by panqingqing on 16/7/8.
 */
@Setter
@Getter
public class ContactDTO extends BaseDTO {

    public static final String PROTOCOL_SPLIT = "://";
    public static final String PROTOCOL_EMAIL = "email" + PROTOCOL_SPLIT;
    public static final String PROTOCOL_SMS = "sms" + PROTOCOL_SPLIT;

    private RequestDTO request;//请求
    private String protocol;//协议
    private String contact;//联系
    private String contactStr;//联系人信息

    public ContactDTO() {
    }
}
