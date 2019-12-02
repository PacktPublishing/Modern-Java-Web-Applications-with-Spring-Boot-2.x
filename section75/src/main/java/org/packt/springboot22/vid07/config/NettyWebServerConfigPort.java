package org.packt.springboot22.vid07.config;

import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

@Component
public class NettyWebServerConfigPort 
  implements WebServerFactoryCustomizer<NettyReactiveWebServerFactory> {
 
    @Override
    public void customize(NettyReactiveWebServerFactory serverFactory) {
        serverFactory.setPort(8088);
    }
}
