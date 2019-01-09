package com.zlg.esclient;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class Controller {
    @Autowired
    TransportClient esClient;
    @RequestMapping("/es")
    public String test() {
        GetResponse response = esClient.prepareGet("item", "it_item_shelf", "1176341658442251723").setRouting("1176341658270285271").get();
        String sourceAsString = response.getSourceAsString();
        return sourceAsString;
    }
    @RequestMapping("/myes")
    public String test1() {
        GetResponse response = esClient.prepareGet("qq", "doc", "1").get();

        return response.getSourceAsString();
    }
}
