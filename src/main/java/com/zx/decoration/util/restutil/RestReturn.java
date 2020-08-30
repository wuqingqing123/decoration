package com.zx.decoration.util.restutil;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.nio.file.AccessDeniedException;
import java.sql.SQLException;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * 接口返回统一数据结构
 */
@Data
public class RestReturn  {
    //http返回码
    private HttpStatus code;
    //前端进行页面展示的信息
    private Object message;
    //返回时间戳
    private Long currentTime;
    /**
     *构造函数（无参数）
     */
    public RestReturn() {
        //毫秒
        this.currentTime = Instant.now().toEpochMilli();
    }
    /**
     *构造函数（有参数）
     */
//    public RestReturn(boolean success, Integer code, Object data, Object message) {
//        this.success = success;
//        this.code = code;
//        this.data = data;
//        this.message = message;
//        //毫秒
//        this.currentTime = Instant.now().toEpochMilli();
//    }

//    @Override
//    public String toString() {
//        return "RestReturn{" +
//                "success=" + success +
//                ",code='" + code + '\'' +
//                ",data=" + data +
//                ",message=" + message +
//                ",currentTime=" + currentTime +
//                '}';
//    }

    /**
     * 请求成功
     * @param data 请求数据
     * @param message 请求信息
     * @return
     */
    public ResponseEntity success(Object data, Object messages) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success",true);
        map.put("message",messages);
        map.put("code",HttpStatus.OK.value());
        map.put("data",data);
        map.put("currentTime",Instant.now().toEpochMilli());
        return  new ResponseEntity(map,HttpStatus.OK);
    }

    /**
     * 请求失败
     * @param e
     * @param
     * @param messages
     * @return
     */
    public ResponseEntity error(Exception e,  Object messages) {
        HttpStatus code = getException(e);

        Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", false);
            map.put("message", messages);
            map.put("code", code.value());
            map.put("data", "");
            map.put("currentTime", Instant.now().toEpochMilli());
            return new ResponseEntity(map, code);

    }

    /**
     * 请求失败
     * @param e
     * @param
     * @return
     */
    public ResponseEntity error(Exception e) {
        HttpStatus code = getException(e);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", false);
        map.put("message", message);
        map.put("code", code.value());
        map.put("data", "");
        map.put("currentTime", Instant.now().toEpochMilli());
        return new ResponseEntity(map, code);

    }

    public HttpStatus getException(Exception e){
        // 空指针异常
        if (e instanceof NullPointerException) {
            code = HttpStatus.INTERNAL_SERVER_ERROR;
            message="系统处理出错，请联系服务商处理！";
        }
        // 下标越界异常
        else if (e instanceof IndexOutOfBoundsException) {
            code = HttpStatus.INTERNAL_SERVER_ERROR;
            message="系统处理出错，请联系服务商处理！";
        }
        // 安全权限异常
        else if (e instanceof IllegalAccessException) {
            code = HttpStatus.INTERNAL_SERVER_ERROR;
            message="系统处理出错，请联系服务商处理！";
        }
        // 角标异常
        else if (e instanceof ArrayIndexOutOfBoundsException) {
            code = HttpStatus.INTERNAL_SERVER_ERROR;
            message="系统处理出错，请联系服务商处理！";
        }
        // 无法找到指定的类异常
        else if (e instanceof ClassNotFoundException) {
            code = HttpStatus.INTERNAL_SERVER_ERROR;
            message="系统处理出错，请联系服务商处理！";
        }
        // 禁止访问异常
        else if (e instanceof AccessDeniedException) {
            code = HttpStatus.FORBIDDEN;
            message="系统处理出错，请联系服务商处理！";
        }
        // SQL异常
        else if (e instanceof SQLException) {
            code = HttpStatus.INTERNAL_SERVER_ERROR;
            message="系统处理出错，请联系服务商处理！";
        }
        // 运行时异常异常
        else if (e instanceof RuntimeException) {
            code = HttpStatus.BAD_REQUEST;
            message="系统处理出错，请联系服务商处理！";
        }
        else{
            code=HttpStatus.INTERNAL_SERVER_ERROR;
//            message="系统处理出错，请联系服务商处理！";
            message=e.getMessage();
        }
        return code;
    }


    public boolean isRestReturnJson(String data) {
        //临时实现先判定下字符串的格式和字段
        try {
            /**
             * ObjectMapper支持从byte[]、File、InputStream、字符串等数据的JSON反序列化。
             */
            ObjectMapper mapper = new ObjectMapper();
            ResponseEntity dataRestReturn = mapper.readValue(data, ResponseEntity.class);
            //比较两个类的字段,如果一致返回为真，不一致返回为假
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
