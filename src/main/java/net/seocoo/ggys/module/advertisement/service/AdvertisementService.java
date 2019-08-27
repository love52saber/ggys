package net.seocoo.ggys.module.advertisement.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import io.swagger.models.auth.In;
import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.module.advertisement.dto.AdvertisementDTO;
import net.seocoo.ggys.module.advertisement.entity.AdvertisementDO;
import net.seocoo.ggys.module.advertisement.form.AdvertisementForm;
import net.seocoo.ggys.module.advertisement.query.AdvertisementQuery;

import java.util.List;

/**
 * @Author xieheng
 * @Data 2018/6/13 0013 16:19
 * @Email xieheng91@163.com
 * @Desc 广告管理
 */
public interface AdvertisementService {

    AdvertisementDO get(Integer id);

    /**
     * 新增
     * @param advertisementDO 实体类
     * @return dao操作结果
     */
    Boolean save(AdvertisementDO advertisementDO);

    /**
     * 删除
     * @param id 主键
     * @return dao操作结果
     */
    Boolean delete(Integer id);

    /**
     * 更新
     * @param advertisementDO 实体类
     * @return doa操作结果
     */
    Boolean update(AdvertisementDO advertisementDO);

    /**
     * 按条件查询返回list结果
     * @param query
     * @return 查询结果list
     */
    List<AdvertisementDO> listQuery(AdvertisementQuery query);

    /**
     * 按条件分页查询
     * @param query
     * @return
     */
    PageBean<AdvertisementDO> pageQuery(AdvertisementQuery query);


    Boolean saveByForm(AdvertisementForm form);

    Boolean updateByFrom(AdvertisementForm form);
}
