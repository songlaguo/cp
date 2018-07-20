package org.bc.saas.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONObject;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class SendTools
{
  public static void sendMsg(String title, String content, String remark)
    throws Exception
  {
    CloseableHttpClient client = HttpClients.createDefault();
    
    HttpPost post = new HttpPost("http://u.ifeige.cn/api/send_message");
    
    List<NameValuePair> formList = new ArrayList();
    
    formList.add(new BasicNameValuePair("secret", "786610f7a0f035eee6bae707a9c3bd6c"));
    formList.add(new BasicNameValuePair("token", "8b225612ef8aa7e5e839aab06094e572"));
    formList.add(new BasicNameValuePair("key", "notice"));
    formList.add(new BasicNameValuePair("uid", "493"));
    formList.add(new BasicNameValuePair("title", title));
    formList.add(new BasicNameValuePair("content", content));
    formList.add(new BasicNameValuePair("remark", remark));
    formList.add(new BasicNameValuePair("time", "time()"));
    
    StringEntity entity = new UrlEncodedFormEntity(formList, "utf-8");
    
    post.setEntity(entity);
    
    CloseableHttpResponse response = client.execute(post);
    
    int statusCode = response.getStatusLine().getStatusCode();
    if (statusCode == 200)
    {
      String resStr = EntityUtils.toString(response.getEntity());
      
      System.out.println(resStr);
    }
    else
    {
      System.out.println(statusCode);
    }
  }
  
  public static String get(String urlAll, String charset)
  {
    BufferedReader reader = null;
    String result = null;
    StringBuffer sbf = new StringBuffer();
    String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";
    try
    {
      URL url = new URL(urlAll);
      HttpURLConnection connection = (HttpURLConnection)url.openConnection();
      connection.setRequestMethod("GET");
      connection.setReadTimeout(30000);
      connection.setConnectTimeout(30000);
      connection.setRequestProperty("User-agent", userAgent);
      connection.connect();
      InputStream is = connection.getInputStream();
      reader = new BufferedReader(new InputStreamReader(is, charset));
      String strRead = null;
      while ((strRead = reader.readLine()) != null)
      {
        sbf.append(strRead);
        sbf.append("\r\n");
      }
      reader.close();
      result = sbf.toString();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return result;
  }
  
  public static Map<String, String> examplePk10()
  {
    Map<String, String> mm = new HashMap();
    mm.put("01", "01");
    mm.put("02", "02");
    mm.put("03", "03");
    mm.put("04", "04");
    mm.put("05", "05");
    mm.put("06", "06");
    mm.put("07", "07");
    mm.put("08", "08");
    mm.put("09", "09");
    mm.put("10", "10");
    return mm;
  }
  
  public static JSONObject getCpData(String name, String uid, String token, int num)
  {
    String url = "http://api.caipiaokong.com/lottery/";
    url = url + "?name=" + name;
    url = url + "&format=json";
    url = url + "&uid=" + uid;
    url = url + "&token=" + token;
    url = url + "&num=" + num;
    String urlAll = url;
    String charset = "UTF-8";
    String jsonResult = get(urlAll, charset);
    JSONObject object = JSONObject.fromObject(jsonResult);
    return object;
  }
}
