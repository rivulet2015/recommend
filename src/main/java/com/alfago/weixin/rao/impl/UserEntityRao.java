package com.alfago.weixin.rao.impl;

import java.util.ArrayList;  
import java.util.List;  

import org.springframework.dao.DataAccessException;  
import org.springframework.data.redis.connection.RedisConnection;  
import org.springframework.data.redis.core.RedisCallback;  
import org.springframework.data.redis.serializer.RedisSerializer;  
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;  

import redis.clients.jedis.ShardedJedis;

import com.alfago.weixin.common.beans.UserEntity;
import com.alfago.weixin.rao.AbstractBaseRedisDao;
import com.alfago.weixin.rao.IUserEntityRao;
  
/**  
 * Dao 
 * @author http://blog.csdn.net/java2000_wl  
 * @version <b>1.0</b>  
 */  
@Component
public class UserEntityRao extends AbstractBaseRedisDao<String, String> implements IUserEntityRao {  
  
    /**  
     * 新增 
     *<br>------------------------------<br> 
     * @param user 
     * @return 
     */  
    public boolean add(final UserEntity user) {  
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {  
            public Boolean doInRedis(RedisConnection connection)  
                    throws DataAccessException {  
                RedisSerializer<String> serializer = getRedisSerializer();  
                byte[] key  = serializer.serialize(user.getGroupId().toString());  
                byte[] name = serializer.serialize(user.getQq());  
                return connection.setNX(key, name);  
            }  
        });  
        return result;  
        
    }

	public boolean add(List<UserEntity> list) {
		// TODO Auto-generated method stub
		return false;
	}

	public void delete(String key) {
		// TODO Auto-generated method stub
		
	}

	public void delete(List<String> keys) {
		// TODO Auto-generated method stub
		
	}

	public boolean update(UserEntity user) {
		// TODO Auto-generated method stub
		return false;
	}

	public UserEntity get(String keyId) {
		// TODO Auto-generated method stub
		return null;
	}  
      
/*    */
	
	/** 
     * 批量新增 使用pipeline方式   
     *<br>------------------------------<br> 
     *@param list 
     *@return 
     *//*  
    public boolean add(final List<UserEntity> list) {  
        Assert.notEmpty(list);  
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {  
            public Boolean doInRedis(RedisConnection connection)  
                    throws DataAccessException {  
                RedisSerializer<String> serializer = getRedisSerializer();  
                for (User user : list) {  
                    byte[] key  = serializer.serialize(user.getId());  
                    byte[] name = serializer.serialize(user.getName());  
                    connection.setNX(key, name);  
                }  
                return true;  
            }  
        }, false, true);  
        return result;  
    }  
      
    *//**  
     * 删除 
     * <br>------------------------------<br> 
     * @param key 
     *//*  
    public void delete(String key) {  
        List<String> list = new ArrayList<String>();  
        list.add(key);  
        delete(list);  
    }  
  
    *//** 
     * 删除多个 
     * <br>------------------------------<br> 
     * @param keys 
     *//*  
    public void delete(List<String> keys) {  
        redisTemplate.delete(keys);  
    }  
  
    *//** 
     * 修改  
     * <br>------------------------------<br> 
     * @param user 
     * @return  
     *//*  
    public boolean update(final UserEntity user) {  
        String key = user.getId();  
        if (get(key) == null) {  
            throw new NullPointerException("数据行不存在, key = " + key);  
        }  
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {  
            public Boolean doInRedis(RedisConnection connection)  
                    throws DataAccessException {  
                RedisSerializer<String> serializer = getRedisSerializer();  
                byte[] key  = serializer.serialize(user.getId());  
                byte[] name = serializer.serialize(user.getName());  
                connection.set(key, name);  
                return true;  
            }  
        });  
        return result;  
    }  
  
    *//**  
     * 通过key获取 
     * <br>------------------------------<br> 
     * @param keyId 
     * @return 
     *//*  
    public User get(final String keyId) {  
        User result = redisTemplate.execute(new RedisCallback<User>() {  
            public User doInRedis(RedisConnection connection)  
                    throws DataAccessException {  
                RedisSerializer<String> serializer = getRedisSerializer();  
                byte[] key = serializer.serialize(keyId);  
                byte[] value = connection.get(key);  
                if (value == null) {  
                    return null;  
                }  
                String name = serializer.deserialize(value);  
                return new User(keyId, name, null);  
            }  
        });  
        return result;  
    }  */
}  