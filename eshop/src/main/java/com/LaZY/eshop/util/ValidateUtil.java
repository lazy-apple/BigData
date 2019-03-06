package com.LaZY.eshop.util;

import java.util.Collection;

/**验证工具类
 * @author LaZY(李志一)
 * @create 2019-03-06 16:37
 */
public class ValidateUtil {
    /***
     * 验证集合可用性
     * @param collection
     * @return t:可用
     */
    public static boolean isValid(Collection collection){
        if (collection == null || collection.isEmpty()){
            return false;
        }else {
            return true;
        }
    }
}
