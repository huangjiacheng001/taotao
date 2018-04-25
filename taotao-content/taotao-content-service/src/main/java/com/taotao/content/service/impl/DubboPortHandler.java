package com.taotao.content.service.impl;

import com.alibaba.dubbo.common.utils.NetUtils;
import com.alibaba.dubbo.config.ProtocolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @author: 990014
 * @Date: 2018/4/24 18:59
 * @Description:* 这是一个进程启动多个dubbo服务的DubboPortHandler另一种写法。以前的方案见DubboNamespaceHandlerEx
 * 利用spring修改受spring管理bean的属性信息
 */
@Component
public class DubboPortHandler {
    @Autowired
    private ApplicationContext applicationContext;

    private int port = 20080;

    @PostConstruct
    public void init() {
        Map<String, ProtocolConfig> beansOfType = applicationContext.getBeansOfType(ProtocolConfig.class);
        for (Map.Entry<String, ProtocolConfig> item : beansOfType.entrySet()) {
            port = NetUtils.getAvailablePort();
            item.getValue().setPort(port);
        }
    }

    public int getPort() {
        return port;
    }
}
