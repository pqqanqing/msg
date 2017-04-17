package com.wjs.msg.domain.contact;

import com.wjs.common.base.base.BaseEntity;
import com.wjs.msg.domain.request.Request;
import lombok.Getter;
import lombok.Setter;

import static com.wjs.msg.api.dto.ContactDTO.PROTOCOL_SPLIT;

/**
 * Created by panqingqing on 16/7/6.
 */
@Setter
@Getter
public class Contact extends BaseEntity {
    private Request request;
    private String contact;
    private String protocol;
    private String contactStr;

    public Contact() {
    }

    public Contact(Request request, String contact) {
        this.request = request;
        this.contact = contact;
        parseContact();
    }

    private void parseContact() {
        int position = contact.indexOf(PROTOCOL_SPLIT);
        if (position < 0) throw new RuntimeException("[" + contact + "]格式不合法!");
        this.protocol = contact.substring(0, position);
        this.contactStr = contact.substring(position + PROTOCOL_SPLIT.length());
    }

}
