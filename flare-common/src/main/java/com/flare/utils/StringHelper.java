package com.flare.utils;

import java.util.Iterator;
import java.util.Map;

public class StringHelper {
    /**
     * 将map中的数据格式化成服务端所需的表单String(www.baidu.com/login?userName=lambdroid&password=123456的“？”以及之后的数据)
     *
     * @param head
     *            url头部字串，一般为“？”，在表单方式中分隔URL和请求参数map
     * @param map
     *            请求参数map
     * @return 格式化完成后的表单数据
     */
    public static <K, V> String urlParamter(String head, Map<K, V> map)
    {
        if (map == null || map.isEmpty())
        {
            return "";
        }

        int capacity = map.size() * 30;       //设置表单长度30字节*N个请求参数

        //参数不为空，在URL后面添加head（“？”）
        StringBuilder buffer = new StringBuilder(capacity);
        if (!map.isEmpty())
        {
            buffer.append(head);
        }

        //取出Map里面的请求参数，添加到表单String中。每个参数之间键值对之间用“=”连接，参数与参数之间用“&”连接
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry<K, V> entry = it.next();
            Object key = entry.getKey();
            buffer.append(key);
            buffer.append('=');
            Object value = entry.getValue();
            buffer.append(value);
            if (it.hasNext())
            {
                buffer.append("&");
            }
        }
        return buffer.toString();
    }
}
