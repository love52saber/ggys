package net.seocoo.ggys.core.base;

import net.seocoo.ggys.core.api.RequestCode;
import net.seocoo.ggys.core.constants.YesNoEnum;
import net.seocoo.ggys.core.exception.AppException;
import net.seocoo.ggys.core.exception.DaoSetDefaultValueException;
import net.seocoo.ggys.core.util.StringEx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Date;

/**
 * @Author xieheng
 * @Data 2018/5/24
 * @Email xieheng91@163.com
 * @Desc service层基类
 */
public class BaseService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 验证参数非空和位数
     *
     * @param obj
     * @return
     * @throws AppException
     */
    public int validateParams(Object... obj) throws AppException {
        for (int i = 0; i < obj.length; i++) {
            if (obj[i] instanceof String) {
                if (StringEx.stringIsNullOrEmpty((String) obj[i])) {
                    return RequestCode.missingParameter_error;
                }
            } else {
                if (null == obj[i]) {
                    return RequestCode.missingParameter_error;
                }
            }
        }
        return RequestCode.success;
    }

    /**
     * 新增记录时,设置通用的字段值:创建时间,默认删除状态否,uuid
     *
     * @param obj
     * @param <T>
     */
    public <T> void insertSetDefaultValue(T obj) {

        Field[] fields = obj.getClass().getDeclaredFields();
        try {
            for (Field field : fields) {
                String name = field.getName();
                if (!"class".equals(name) && !Modifier.isStatic(field.getModifiers())) {
                    field.setAccessible(true);
                    if ("createDate".equals(name)) {
                        field.set(obj, new Date());
                    }
                    if ("uuid".equals(name)) {
                        field.set(obj, StringEx.newUUID());
                    }
                    if ("canDeleted".equals(name)) {
                        field.set(obj, YesNoEnum.N);
                    }
                }
            }
        } catch (Exception e) {
            throw new DaoSetDefaultValueException("设置默认值错误:"+e.toString(), RequestCode.server_error);
        }
    }

    /**
     * 更新记录时,设置通用的更新字段:更新时间
     *
     * @param obj
     * @param <T>
     */
    public <T> void updateSetDefaultValue(T obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        try {
            for (Field field : fields) {
                String name = field.getName();
                if (!"class".equals(name) && !Modifier.isStatic(field.getModifiers())) {
                    field.setAccessible(true);
                    if ("updateDate".equals(name)) {
                        field.set(obj, new Date());
                    }
                }
            }
        } catch (Exception e) {
            throw new DaoSetDefaultValueException("设置默认值错误:"+e.toString(), RequestCode.server_error);
        }
    }

}
