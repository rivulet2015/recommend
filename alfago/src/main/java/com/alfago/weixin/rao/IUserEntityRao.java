package com.alfago.weixin.rao;

import java.util.List;  

import com.alfago.weixin.common.beans.UserEntity;
  
/**  
 * @author http://blog.csdn.net/java2000_wl  
 * @version <b>1.0</b>  
 */   
public interface IUserEntityRao {  
      
    /** 
     * 新增 
     * <br>------------------------------<br> 
     * @param user 
     * @return 
     */  
    boolean add(UserEntity user);  
      
    /** 
     * 批量新增 使用pipeline方式 
     * <br>------------------------------<br> 
     * @param list 
     * @return 
     */  
    boolean add(List<UserEntity> list);  
      
    /** 
     * 删除 
     * <br>------------------------------<br> 
     * @param key 
     */  
    void delete(String key);  
      
    /** 
     * 删除多个 
     * <br>------------------------------<br> 
     * @param keys 
     */  
    void delete(List<String> keys);  
      
    /** 
     * 修改 
     * <br>------------------------------<br> 
     * @param user 
     * @return  
     */  
    boolean update(UserEntity user);  
  
    /** 
     * 通过key获取 
     * <br>------------------------------<br> 
     * @param keyId 
     * @return  
     */  
    UserEntity get(String keyId);  
}  