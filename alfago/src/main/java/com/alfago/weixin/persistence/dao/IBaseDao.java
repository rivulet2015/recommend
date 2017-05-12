package com.alfago.weixin.persistence.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 所有自定义Dao的顶级接口, 封装常用的增删查改操作,
 * 可以通过Mybatis Generator Maven 插件自动生成Dao,
 * 也可以手动编码,然后继承GenericDao 即可.
 * <p/>
 * Model : 代表数据库中的表 映射的Java对象类型
 * PK :代表对象的主键类型
 *
 */
public interface IBaseDao<Model, PK> {

    /**
     * 插入对象
     *
     * @param model 对象
     */
    int insertSelective(Model model);

    /**
     * 更新对象
     *
     * @param model 对象
     */
    int updateByPrimaryKeySelective(Model model);

    /**
     * 通过主键, 删除对象
     *
     * @param id 主键
     */
    int deleteByPrimaryKey(PK id);

    /**
     * 通过主键, 查询对象
     *
     * @param id 主键
     * @return
     */
    Model selectByPrimaryKey(PK id);

    
    /**
     * 通过条件, 查询一个对象
     *
     * @param model 条件
     * @return
     */
    Model selectOneByModel(Model model); 
    
    /**
     * 通过条件, 查询所有对象
     *
     * @param model 条件
     * @return
     */
    List<Model> selectAllByModel(Model model);     

    /**
     * 查询所有
     *
     * @param 
     * @return
     */
    List<Model> selectAll();     
    
    /**
     * 查询所有符合条件的对象，分页查询
     *
     * @param model 条件 
     * @return
     */
    List<Model> selectModelByPage(@Param("model") Model model, @Param("start") int start, @Param("size") int size);  
    
    /**
     * 查询所有符合条件的对象的条数
     *
     * @param model 条件
     * @return
     */
    Integer countSelectModel(Model model);      
}


