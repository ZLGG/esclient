package com.zlg.esclient;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.elasticsearch.xpack.client.PreBuiltXPackTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;

@Configuration
public class EsClientConfig {
    @Bean("esClient")
    public TransportClient transportClient() throws Exception{
        Settings.Builder builder = Settings.builder().put("cluster.name", "elasticsearch");
        builder.put("xpack.security.user", null + ":" + null);
        builder.put("client.transport.sniff", false);
        Settings settings = builder.build();
        TransportClient client = new PreBuiltXPackTransportClient(Settings.EMPTY)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 8151));

        /*TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 8151));*/
        return client;
    }
}
