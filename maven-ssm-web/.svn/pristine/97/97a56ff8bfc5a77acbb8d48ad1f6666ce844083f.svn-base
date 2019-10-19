package com.zero.httpClient;

import com.alibaba.fastjson.JSON;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
 
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author Zero-me
 *
 */
public class httpClient {

	
	public static void main(String[] args) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		HashMap<String, String> header = new HashMap<String, String>();
		header.put("Referer", "http://localhost:8080/sckl/getsckl");
		header.put("ddd", "hddd");

		header.put("tassIP", "hsqqwqwq");

		String url2 = "http://localhost:8080/sckl/getsckl";
//		String response = sendHttp(HttpRequestMethedEnum.HttpPost, url, params, header);
		String resp = HttpPost(url2, params, header);
		System.out.println(resp);
//		JSONObject obj = JSONObject.parseObject(response);
//		for (Object item:obj.entrySet()) {
//			System.out.println(item);
//		}
	}

    private static RequestConfig requestConfig = RequestConfig.custom()
            //从连接池中获取连接的超时时间
            // 要用连接时尝试从连接池中获取，若是在等待了一定的时间后还没有获取到可用连接（比如连接池中没有空闲连接了）则会抛出获取连接超时异常。
            .setConnectionRequestTimeout(15000)
            //与服务器连接超时时间：httpclient会创建一个异步线程用以创建socket连接，此处设置该socket的连接超时时间
            //连接目标url的连接超时时间，即客服端发送请求到与目标url建立起连接的最大时间。超时时间3000ms过后，系统报出异常
            .setConnectTimeout(15000)
            //socket读数据超时时间：从服务器获取响应数据的超时时间
            //连接上一个url后，获取response的返回等待时间 ，即在与目标url建立连接后，等待放回response的最大时间，在规定时间内没有返回响应的话就抛出SocketTimeout。
            .setSocketTimeout(15000)
            .build();
    
    /**
     * Post请求方式
     * @param url
     * @param params
     * @param header
     * @return
     */
    public static String HttpPost(String url, Map<String, Object> params, Map<String, String> header) {
    	return sendHttp(HttpRequestMethedEnum.HttpPost, url,params, header);
    }
    
    /**
     * Get 请求方式
     * @param url
     * @param params
     * @param header
     * @return
     */
    public static String HttpGet(String url, Map<String, Object> params, Map<String, String> header) {
    	return sendHttp(HttpRequestMethedEnum.HttpGet, url,params, header);
    }
    /**
     * Delete请求方式
     * @param url
     * @param params
     * @param header
     * @return
     */
    public static String HttpDelete(String url, Map<String, Object> params, Map<String, String> header) {
    	return sendHttp(HttpRequestMethedEnum.HttpDelete, url,params, header);
    }
    /**
     * Put请求方式
     * @param url
     * @param params
     * @param header
     * @return
     */
    public static String HttpPut(String url, Map<String, Object> params, Map<String, String> header) {
    	return sendHttp(HttpRequestMethedEnum.HttpPut, url,params, header);
    }
    
 
    /**
     	* 发送http请求
     *
     * @param requestMethod 请求方式（HttpGet、HttpPost、HttpPut、HttpDelete）
     * @param url 请求路径
     * @param params post请求参数
     * @param header 请求头
     * @return 响应文本
     */
    public static String sendHttp(HttpRequestMethedEnum requestMethod, String url, Map<String, Object> params, Map<String, String> header) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse httpResponse = null;
        String responseContent = null;
        HttpRequestBase request = requestMethod.createRequest(url);
        request.setConfig(requestConfig);
        if (header != null) {
            for (Map.Entry<String, String> entry : header.entrySet()) {
                request.setHeader(entry.getKey(), entry.getValue());
            }
        }
        try {
            if (params != null) {
                ((HttpEntityEnclosingRequest) request).setEntity(
                        new StringEntity(JSON.toJSONString(params),
                                ContentType.create("application/json", "UTF-8")));
            }
            httpResponse = httpClient.execute(request);
            HttpEntity httpEntity = httpResponse.getEntity();
            if (httpEntity != null) {
                responseContent = EntityUtils.toString(httpEntity, "UTF-8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (httpResponse != null) {
                    httpResponse.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseContent;
    }
    
}

enum HttpRequestMethedEnum {
	// HttpGet请求
    HttpGet {
        @Override
        public HttpRequestBase createRequest(String url) { return new HttpGet(url); }
    },
    // HttpPost 请求
    HttpPost {
        @Override
        public HttpRequestBase createRequest(String url) { return new HttpPost(url); }
    },
    // HttpPut 请求
    HttpPut {
        @Override
        public HttpRequestBase createRequest(String url) { return new HttpPut(url); }
    },
    // HttpDelete 请求
    HttpDelete {
        @Override
        public HttpRequestBase createRequest(String url) { return new HttpDelete(url); }
    };
 
    public HttpRequestBase createRequest(String url) { return null; }
}

