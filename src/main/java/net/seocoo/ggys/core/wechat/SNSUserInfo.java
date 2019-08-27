package net.seocoo.ggys.core.wechat;
import java.util.List;
/**
 * @author wangpan
 * @date 2018/6/3 22:43
 */
public class SNSUserInfo {
    private String openId;
    private String nickname;
    private int sex;
    private String province;
    private String city;
    private String country;
    private String headImgUrl;
    private List<String> privilegelist;
    private String unionid;

    public String getOpenId()
    {
        return openId;
    }

    public void setOpenId(String openId)
    {
        this.openId = openId;
    }

    public String getNickname()
    {
        return nickname;
    }

    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

    public int getSex()
    {
        return sex;
    }

    public void setSex(int sex)
    {
        this.sex = sex;
    }

    public String getProvince()
    {
        return province;
    }

    public void setProvince(String province)
    {
        this.province = province;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getHeadImgUrl()
    {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl)
    {
        this.headImgUrl = headImgUrl;
    }

    public List<String> getPrivilegelist()
    {
        return privilegelist;
    }

    public void setPrivilegelist(List<String> privilegelist)
    {
        this.privilegelist = privilegelist;
    }

    public String getUnionid()
    {
        return unionid;
    }

    public void setUnionid(String unionid)
    {
        this.unionid = unionid;
    }
}
