package net.seocoo.ggys.core.emchat;

import com.alibaba.fastjson.JSONObject;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.api.AuthenticationApi;
import io.swagger.client.api.UsersApi;
import io.swagger.client.model.RegisterUsers;
import io.swagger.client.model.Token;
import io.swagger.client.model.User;
import net.seocoo.ggys.core.api.RequestCode;
import net.seocoo.ggys.core.emchat.constans.EmchantConstans;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author xieheng
 * @Data 2018/6/14 0014 14:10
 * @Email xieheng91@163.com
 * @Desc 环信即时通讯服务端接口提供
 */
@Component
public class EmchantApi {

    Logger LOG = LoggerFactory.getLogger(EmchantApi.class);

    @Value("${OrgName}")
    private String orgName;

    @Value("${AppName}")
    private String appName;

    @Value("${clent_id}")
    private String clentId;

    @Value("${clent_secret}")
    private String clentSecret;

    @Value("${grant_type}")
    private String grantType;

    private String ACCESS_TOKEN;


    public String initToken() {
        if (ACCESS_TOKEN == null) {
            Token token = new Token();
            token.setClientId(clentId);
            token.setClientSecret(clentSecret);
            token.setGrantType(grantType);
            AuthenticationApi authenticationApi = new AuthenticationApi();
            ApiResponse<String> response = null;
            try {
                response = authenticationApi.orgNameAppNameTokenPostWithHttpInfo(orgName, appName, token);
            } catch (ApiException e) {
                LOG.error("获取环信token出现异常");
                LOG.error(e.getMessage(), e);
            }
            if (response.getStatusCode() == RequestCode.success) {
                Map<String, Object> map = JSONObject.parseObject(response.getData(), Map.class);
                ACCESS_TOKEN = (String) map.get(EmchantConstans.ACCESS_TOKEN);
            }
        }
        return ACCESS_TOKEN;
    }

    /**
     * @param userName 此处每个用户名使用用户的uuid
     * @param password
     * @return
     */
    public Boolean registerUserIMForSingle(String userName, String password) {
        initToken();
        RegisterUsers users = new RegisterUsers();
        User user = null;
        user = new User();
        user.setUsername(userName);
        user.setPassword(password);

        users.add(user);

        return register(users);
    }

    /**
     * 注册IM用户
     *
     * @param userMapList 用户名集合,此处每个用户名使用uuid
     * @return
     * @throws ApiException
     */
    public Boolean registerUserIM(List<Map<String, Object>> userMapList) {
        initToken();
        RegisterUsers users = new RegisterUsers();
        User user = null;

        for (Map<String, Object> userMap : userMapList) {
            user = new User();
            user.setUsername(userMap.get("userName").toString());
            user.setPassword(userMap.get("password").toString());
            users.add(user);
        }
        return register(users);
    }

    private Boolean register(RegisterUsers users) {
        UsersApi usersApi = new UsersApi();
        ApiResponse<String> response = null;
        try {
            response = usersApi.orgNameAppNameUsersPostWithHttpInfo(orgName, appName, users, ACCESS_TOKEN);
        } catch (ApiException e) {
            LOG.error("注册环信用户出现异常");
            LOG.error(e.getMessage(), e);
            return false;
        }
        if (response != null && response.getStatusCode() == RequestCode.success) {
            LOG.info("注册环信用户成功");
            return true;
        }
        return false;
    }


}
