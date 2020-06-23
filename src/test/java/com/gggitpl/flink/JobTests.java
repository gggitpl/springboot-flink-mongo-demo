package com.gggitpl.flink;

import com.gggitpl.flink.model.Demo;
import com.gggitpl.flink.mongo.MongoSink;
import com.gggitpl.flink.mongo.MongoSource;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class JobTests {

    @Resource
    private MongoSource mongoSource;
    @Resource
    private MongoSink mongoSink;

    @Test
    void run() throws Exception {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        final DataStreamSource<Demo> dataStreamSource = env.addSource(mongoSource);
        //一系列的处理
        dataStreamSource.addSink(mongoSink);
        env.execute("test job");
    }

}
