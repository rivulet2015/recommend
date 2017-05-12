package com.alfago.weixin.service.persistence;

import java.util.List;

public interface ISelfTractionBaseService<Model, PK> {

    /**
     * 插入多个对象
     *
     * @return
     */
    void insertBatch(List<Model> models);    
}
