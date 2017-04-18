package com.wjs.msg.domain.consumer;

import com.wjs.common.base.annotation.StatusAndClassNum;
import com.wjs.common.base.execption.BusinessExecption;
import com.wjs.common.base.util.CloseableUtil;
import com.wjs.msg.api.dto.ConsumerDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by panqingqing on 16/8/18.
 */
@StatusAndClassNum(superClass = Consumer.class, number = ConsumerDTO.TYPE_SMS, describe = "发消息", parasitClass = Consumer.class)
public class SMSConsumer extends Consumer {
    private static final String URL = "http://apis.baidu.com/sms_net/smsapi/smsapi";
    private static final String ERR_NUM = "errNum";
    private static final String ERR_MSG = "errMsg";
    private Logger logger = LoggerFactory.getLogger(SMSConsumer.class);

    public SMSConsumer() {
    }

    @Override
    protected boolean doSend() {
        String httpUrl = URL + "?content=" + msg.getContext() + "&mobile=" + contact;
        String jsonResult = doRequest(httpUrl);
        logger.debug("调用短信发送器接口的jsonResult:" + jsonResult);
        return jsonResult.startsWith("0") ? true : false;
    }

    private String doRequest(String httpUrl) {
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader = null;
        InputStream inputStream = null;
        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("apikey", "4e4bc3799fff5ffad856e48019411ad8");
            connection.connect();
            inputStream = connection.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            String read = null;
            while ((read = bufferedReader.readLine()) != null) {
                stringBuffer.append(read);
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            throw new BusinessExecption("msg1", contact);
        } finally {
            CloseableUtil.close(inputStream, bufferedReader);
        }
    }
}
