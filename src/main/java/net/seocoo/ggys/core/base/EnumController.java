package net.seocoo.ggys.core.base;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.seocoo.ggys.core.api.ApiResult;
import net.seocoo.ggys.core.api.RequestCode;
import net.seocoo.ggys.core.constants.CacheKeyPrefix;
import net.seocoo.ggys.core.exception.AppException;
import net.seocoo.ggys.core.util.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 根据枚举名获得枚举项列表
 *
 * @author ZengXiaoLiang
 * @date 2018/6/4 20:51
 **/
@RestController
public class EnumController extends BaseController {

  @Autowired
  private RedisUtil redisUtil;

  @ApiOperation(value = "根据枚举名查询枚举项集合")
  @CrossOrigin
  @GetMapping("/common/getEnumsByName/{enumName}")
  private ApiResult getListByEnumName(@ApiParam(value = "枚举名", defaultValue = "YesNoEnum", required = true)
                                      @PathVariable String enumName) throws Exception {

    List<EnumDTO> retList = (List<EnumDTO>) redisUtil.get(CacheKeyPrefix.SYS_ENUM_NAME + enumName);
    if (retList == null) {
      Reflections reflections = new Reflections("net.seocoo.ggys");
      Set<Class<? extends Enum>> allEnums = reflections.getSubTypesOf(Enum.class);
      if (allEnums != null && allEnums.size() > 0) {
        Class<? extends Enum> enumClass = null;
        //循环查询所有枚举类型class
        for (Class<? extends Enum> clazz : allEnums) {
          if (StringUtils.equals(clazz.getSimpleName(), enumName)) {
            enumClass = clazz;
            break;
          }
        }
        if (enumClass == null) {
          throw new AppException(enumName + "未查到枚举类型", RequestCode.server_error);
        }

        Enum[] enumConstants = enumClass.getEnumConstants();
        if (enumConstants != null && enumConstants.length > 0) {
          retList = new ArrayList<EnumDTO>();
          for (int i = 0; i < enumConstants.length; i++) {
            EnumDTO enumDTO = new EnumDTO();
            Class<?> sub = enumConstants[i].getClass();
            Method descMethod = sub.getDeclaredMethod("getDesc");
            Method codeMethod = sub.getDeclaredMethod("getCode");
            String desc = (String) descMethod.invoke(enumConstants[i]);
            Integer code = (Integer) codeMethod.invoke(enumConstants[i]);
            enumDTO.setCode(code);
            enumDTO.setDesc(desc);
            enumDTO.setName(enumConstants[i].name());
            retList.add(enumDTO);
          }
          if (retList != null && retList.size() > 0) {
            redisUtil.set(CacheKeyPrefix.SYS_ENUM_NAME + enumName, retList, 7L, TimeUnit.DAYS);
          }
        }
      }
    }
    return success(retList);
  }

  private class EnumDTO {
    private Integer code;
    private String desc;
    private String name;

    public EnumDTO(Integer code, String desc, String name) {
      this.code = code;
      this.desc = desc;
      this.name = name;
    }

    public EnumDTO() {
    }

    @Override
    public String toString() {
      return ToStringBuilder.reflectionToString(this);
    }

    public Integer getCode() {
      return code;
    }

    public void setCode(Integer code) {
      this.code = code;
    }

    public String getDesc() {
      return desc;
    }

    public void setDesc(String desc) {
      this.desc = desc;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }
}

