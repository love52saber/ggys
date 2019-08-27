package net.seocoo.ggys.core.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @Author xieheng
 * @Data 2018/5/24
 * @Email xieheng91@163.com
 * @Desc  统一的请求返回的封装对象
 */
public class ApiResult
{
    private ResultInfo rt;
    private Object data;

    public ApiResult()
    {
        this.rt = new ResultInfo();
    }

    public ApiResult(String data) throws Exception {
        this();

        JSONObject json = JSON.parseObject(data);

        if (!json.containsKey("rt")) {
            this.rt.setStatus(-1);
            throw new Exception("request rt is null;");
        }

        JSONObject rcjson = json.getJSONObject("rt");

        if (rcjson.containsKey("status")) {
            this.rt.setStatus(rcjson.getIntValue("status"));
        }
      /*  if (rcjson.containsKey("appId")) {
            this.rt.setAppId(rcjson.getString("appId"));
        }*/
        if (json.containsKey("data"))
            setData(json.getString("data"));
    }

    public ResultInfo getRt()
    {
        return this.rt;
    }

    public void setRt(ResultInfo rt) {
        this.rt = rt;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String toString()
    {
        return "status : " + this.rt.getStatus() + ";";
    }
}