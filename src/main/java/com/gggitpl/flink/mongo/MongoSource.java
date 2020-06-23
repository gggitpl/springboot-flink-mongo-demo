package com.gggitpl.flink.mongo;

import com.gggitpl.flink.model.Demo;
import com.gggitpl.flink.util.ApplicationContextUtil;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.source.RichSourceFunction;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import static com.gggitpl.flink.model.Demo.Fields.createTime;

@Component
public class MongoSource extends RichSourceFunction<Demo> {

    private MongoTemplate mongoTemplate;

    @Override
    public void open(Configuration parameters) throws Exception {
        super.open(parameters);
        mongoTemplate = ApplicationContextUtil.getBean(MongoTemplate.class);
    }

    @Override
    public void run(SourceContext<Demo> sourceContext) {
        final Criteria criteria = new Criteria();
        final Query query = Query.query(criteria)
                .with(PageRequest.of(1, 15, Sort.by(Sort.Direction.DESC, createTime)));
        final Demo demo = mongoTemplate.findOne(query, Demo.class);
        sourceContext.collect(demo);
    }

    @Override
    public void cancel() {

    }
}
