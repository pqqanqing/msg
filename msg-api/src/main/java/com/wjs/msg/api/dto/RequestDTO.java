package com.wjs.msg.api.dto;

import com.wjs.common.base.base.BaseDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by panqingqing on 16/7/8.
 */
@Setter
@Getter
public class RequestDTO extends BaseDTO {
    private String message;
    private GroupDTO group;
    private ContactDTO[] contacts;
    private MsgDTO[] msgs;

    public RequestDTO() {
    }
}