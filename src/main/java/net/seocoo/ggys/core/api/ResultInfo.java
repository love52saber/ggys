package net.seocoo.ggys.core.api;

/**
 * @Author xieheng
 * @Data 2018/5/24
 * @Email xieheng91@163.com
 * @Desc  ApiResult的属性，暂时只有status，表示状态码
 */
public class ResultInfo {
    private int status;
   /* @Deprecated
    private String appId;
    @Deprecated
    private List<String> debug;
*/
    public int getStatus()
    {
        return this.status;
    }

    public void setStatus(int code)
    {
        this.status = code;
    }
/*
    public List<String> getDebug()
    {
        return this.debug;
    }

    public void setDebug(List<String> debug)
    {
        this.debug = debug;
    }

    public String getAppId()
    {
        return this.appId;
    }

    public void setAppId(String appId)
    {
        this.appId = appId;
    }*/
}