package com.gggitpl.flink.mongo;

import com.gggitpl.flink.model.Demo;
import com.gggitpl.flink.util.ApplicationContextUtil;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class MongoSink extends RichSinkFunction<Demo> {

    private MongoTemplate mongoTemplate;

    @Override
    public void open(Configuration parameters) throws Exception {
        super.open(parameters);
        mongoTemplate = ApplicationContextUtil.getBean(MongoTemplate.class);
    }

    @Override
    public void invoke(Demo value, Context context) {
        mongoTemplate.save(value);
    }
}
