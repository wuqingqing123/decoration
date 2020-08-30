package com.zx.decoration.util.billcodeutil;




import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class RequestUtils {
    private static PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(60,
            TimeUnit.SECONDS);

    private static int timeout = 60000;

    static {
        // Increase max total connection to 200
        cm.setMaxTotal(Integer.parseInt("200"));
        // Increase default max connection per route to 20
        cm.setDefaultMaxPerRoute(Integer.parseInt("20"));
    }

    private static Logger log = LogManager.getLogger(RequestUtils.class);

    // 获取页面传入JSON
    public static String getJSON(HttpServletRequest request) {
        try {
            StringBuffer sb = new StringBuffer();
            BufferedReader br = new BufferedReader(
                    new InputStreamReader((ServletInputStream) request.getInputStream(), "utf-8"));
            String temp;
            while ((temp = br.readLine()) != null) {
                sb.append(temp);
            }
            br.close();
            return sb.toString();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    public static JSONObject remove(JSONObject json) {
        JSONArray jarr = json.names();
        for (int i = 0; i < jarr.size(); i++) {
            String jv = json.getString(jarr.get(i) + "");
            jv = jv.replace("[", "");
            jv = jv.replace("\"", "");
            jv = jv.replace("\"", "");
            jv = jv.replace("]", "");
            json.put(jarr.get(i), jv);
        }
        return json;
    }

    // 发送JSON
    public static JSONObject postJSON(JSONObject json, String url, String api_key, String authorization) {
        HttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
        HttpPost method = new HttpPost(url);
        StringEntity entity = null;
        JSONObject ret = new JSONObject();
        try {
            RequestConfig requestConfig =
                    RequestConfig.custom().setSocketTimeout(timeout).setConnectTimeout(timeout).build();// 设置请求和传输超时时间
            method.setConfig(requestConfig);
            entity = new StringEntity(json == null ? "" : json.toString(), "utf-8");
            entity.setContentType("application/json");
            method.setHeader("cm-api-key", api_key);
            method.setHeader("Accept", "application/json");
            method.setHeader("Authorization", "Bearer " + authorization);
            method.setEntity(entity);
            HttpResponse result = httpClient.execute(method);
            String resData = EntityUtils.toString(result.getEntity());
            ret.put("code", result.getStatusLine().getStatusCode());
            ret.put("message", resData);
            log.info(resData);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            ret.put("code", 500);
            ret.put("message", "查询失败");
        }
        return ret;
    }

    // 发送JSON
    public static JSONObject putJSON(JSONObject json, String url, String api_key) {
        HttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
        HttpPut method = new HttpPut(url);
        StringEntity entity = null;
        JSONObject ret = new JSONObject();
        try {
            RequestConfig requestConfig =
                    RequestConfig.custom().setSocketTimeout(timeout).setConnectTimeout(timeout).build();// 设置请求和传输超时时间
            method.setConfig(requestConfig);
            entity = new StringEntity(json.toString(), "utf-8");
            entity.setContentType("application/json");
            method.setHeader("cm-api-key", api_key);
            // method.setHeader("Authorization", "Bearer " + authorization);
            method.setEntity(entity);
            log.info(url);
            HttpResponse result = httpClient.execute(method);
            String resData = EntityUtils.toString(result.getEntity());
            ret.put("code", result.getStatusLine().getStatusCode());
            ret.put("message", resData);
            log.info(resData);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            ret.put("code", 500);
            ret.put("message", "查询失败");
        }
        return ret;
    }

    public static JSONObject getJSONFromUrl(String url) {
        return getJSON(url, null, null);
    }

    /**
     * 发送json
     * @param url
     * @param api_key
     * @param authorization
     * @return
     */
    public static JSONObject getJSON(String url, String api_key, String authorization) {
        HttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
        JSONObject ret = new JSONObject();
        log.info(url);
        HttpGet method = new HttpGet(url);
        try {
            RequestConfig requestConfig =
                    RequestConfig.custom().setSocketTimeout(timeout).setConnectTimeout(timeout).build();// 设置请求和传输超时时间
            method.setConfig(requestConfig);
            method.setHeader("cm-api-key", api_key);
            method.setHeader("Authorization", "Bearer " + authorization);
            HttpResponse result = httpClient.execute(method);
            StatusLine status = result.getStatusLine();

            String resData = EntityUtils.toString(result.getEntity());
            log.info(status.getStatusCode() + url);
            ret.put("code", result.getStatusLine().getStatusCode());
            ret.put("message", resData);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            ret.put("code", 500);
            ret.put("message", "查询失败");
        }
        return ret;
    }

    /**
     * 发送json
     * @param json
     * @param url
     * @return
     */
    public static String sendJSONForPut(JSONObject json, String url) {
        HttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();

        HttpPut method = new HttpPut(url);
        StringEntity entity = null;
        try {
            RequestConfig requestConfig =
                    RequestConfig.custom().setSocketTimeout(timeout).setConnectTimeout(timeout).build();// 设置请求和传输超时时间
            method.setConfig(requestConfig);
            if (json != null) {
                entity = new StringEntity(json.toString(), "utf-8");
                entity.setContentType("application/json");
            }
            method.setEntity(entity);
            HttpResponse result = httpClient.execute(method);
            String resData = EntityUtils.toString(result.getEntity());
            return resData;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            return null;
        }
    }

    // 发送JSON
    public static String sendJSON(JSONArray json, String url) {
        HttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();

        HttpPost method = new HttpPost(url);
        StringEntity entity = null;
        try {
            RequestConfig requestConfig =
                    RequestConfig.custom().setSocketTimeout(timeout).setConnectTimeout(timeout).build();// 设置请求和传输超时时间
            method.setConfig(requestConfig);
            entity = new StringEntity(json.toString(), "utf-8");
            entity.setContentType("application/json");
            method.setEntity(entity);
            HttpResponse result = httpClient.execute(method);
            String resData = EntityUtils.toString(result.getEntity());
            return resData;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            return null;
        }
    }

    // 发送JSON
    public static String sendJSON(JSONObject json, String url) {
        HttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();

        HttpPost method = new HttpPost(url);
        StringEntity entity = null;
        try {
            RequestConfig requestConfig =
                    RequestConfig.custom().setSocketTimeout(timeout).setConnectTimeout(timeout).build();// 设置请求和传输超时时间
            method.setConfig(requestConfig);
            entity = new StringEntity(json.toString(), "utf-8");
            entity.setContentType("application/json");
            method.setEntity(entity);
            HttpResponse result = httpClient.execute(method);
            String resData = EntityUtils.toString(result.getEntity());
            return resData;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            return null;
        }
    }

    /**
     * 有头信息的请求，待考虑
     *
     * @param url
     * @param header
     * @return
     * @author AMS-ZXH
     */
    public static JSONObject getWithHeader(String url, Map<String, String> header) {
        HttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
        JSONObject ret = new JSONObject();
        log.info(url);
        HttpGet method = new HttpGet(url);
        try {
            for (Map.Entry<String, String> entry : header.entrySet()) {
                method.setHeader(entry.getKey(), entry.getValue());
            }
            RequestConfig requestConfig =
                    RequestConfig.custom().setSocketTimeout(timeout).setConnectTimeout(timeout).build();// 设置请求和传输超时时间
            method.setConfig(requestConfig);
            HttpResponse result = httpClient.execute(method);
            StatusLine status = result.getStatusLine();
            String resData = EntityUtils.toString(result.getEntity());
            log.info(status.getStatusCode() + url);
            ret = JSONObject.fromObject(resData);
        } catch (Exception ex) {
            ex.printStackTrace();
            ret.put("code", 500);
            ret.put("message", "查询失败");
        }
        return ret;
    }

    /**
     * 带header头信息，返回String类型
     *
     * @param url
     * @param header
     * @return
     */
    public static JSONObject getWithHeaderRetString(String url, Map<String, String> header) {
        HttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
        JSONObject ret = new JSONObject();
        HttpGet method = new HttpGet(url);
        try {
            for (Map.Entry<String, String> entry : header.entrySet()) {
                method.setHeader(entry.getKey(), entry.getValue());
            }
            RequestConfig requestConfig =
                    RequestConfig.custom().setSocketTimeout(timeout).setConnectTimeout(timeout).build();// 设置请求和传输超时时间
            method.setConfig(requestConfig);
            HttpResponse result = httpClient.execute(method);
            StatusLine status = result.getStatusLine();
            String resData = EntityUtils.toString(result.getEntity());
            log.info(status.getStatusCode() + url);
            ret.put("code", status.getStatusCode());
            ret.put("message", resData);
        } catch (Exception ex) {
            ex.printStackTrace();
            ret.put("code", 500);
            ret.put("message", "查询失败");
        }
        return ret;
    }

    /**
     * 有头消息的post请求
     *
     * @param url
     * @param header
     * @return
     */
    public static JSONObject postWithHeader(String url, Map<String, String> header, String body) {
        System.out.println(url);
        HttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
        HttpPost method = new HttpPost(url);
        StringEntity entity = null;
        JSONObject ret = new JSONObject();
        try {
            // 放置post请求header信息
            for (Map.Entry<String, String> entry : header.entrySet()) {
                method.setHeader(entry.getKey(), entry.getValue());
            }
            entity = new StringEntity(body == null ? "" : body, "utf-8");
            entity.setContentType("application/json");
            method.setEntity(entity);
            HttpResponse result = httpClient.execute(method);
            String resData = EntityUtils.toString(result.getEntity());
            log.info(resData);
            ret.put("code", result.getStatusLine().getStatusCode());
            ret.put("message", resData);
        } catch (Exception ex) {
            ex.printStackTrace();
            ret.put("code", 500);
            ret.put("message", "post请求失败");
        }
        return ret;
    }

    // 获取用户IP
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
            log.info("获取用户IP,Proxy-Client-IP", ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
            log.info("获取用户IP,WL-Proxy-Client-IP", ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            log.info("获取用户IP,unknown", ip);
        }
        log.info("获取用户IP", ip);
        return ip;
    }

    /**
     * delete
     *
     * @param json
     * @param url
     */
    public static void deleteJSON(String url) {
        HttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
        HttpDelete method = new HttpDelete(url);
        //StringEntity entity = null;
        JSONObject ret = new JSONObject();
        try {
            RequestConfig requestConfig =
                    RequestConfig.custom().setSocketTimeout(timeout).setConnectTimeout(timeout).build();// 设置请求和传输超时时间
            method.setConfig(requestConfig);
            //method.setEntity(entity);
            HttpResponse result = httpClient.execute(method);
            String resData = EntityUtils.toString(result.getEntity());
            log.info(resData);
        } catch (Exception e) {
            e.printStackTrace();
            ret.put("code", 500);
            ret.put("message", "删除失败");
        }
    }

}

