package com.wjs.msg.api.dto;

import com.wjs.common.base.base.BaseDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by panqingqing on 16/7/8.
 */
@Setter
@Getter
public class ConsumerDTO extends BaseDTO {

    public static final String STATUS_WAITING = "0";//待消费
    public static final String STATUS_SUCC = "1";//消费成功
    public static final String STATUS_FAIL = "2";//消费失败

    public static final String TYPE_SIMULATE = "simulate";
    public static final String TYPE_EMAIL = "email";
    public static final String TYPE_SMS = "sms";

    public ConsumerDTO() {
    }
}
