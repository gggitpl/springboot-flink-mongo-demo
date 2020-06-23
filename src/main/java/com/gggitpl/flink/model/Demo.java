package com.gggitpl.flink.model;

import lombok.Data;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
@FieldNameConstants
public class Demo {

    @Id
    private String id;

    private Date createTime;

}
