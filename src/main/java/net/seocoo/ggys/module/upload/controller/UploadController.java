package net.seocoo.ggys.module.upload.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.seocoo.ggys.core.api.ApiResult;
import net.seocoo.ggys.core.api.RequestCode;
import net.seocoo.ggys.core.base.BaseController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;

/**
 * @author wangpan
 * @date 2018/6/6 15:51
 */
//@CrossOrigin
@RestController
@RequestMapping(value = "/upload")
@Api(value = "图片上传" ,description = "图片上传接口")
public class UploadController extends BaseController {

  /**支持图片的类型**/
  private String [] types={".jpg",".bmp",".jpeg",".png"};

  @Value("${save.path}")
  private String savePath ;

  @Value("${visit.path}")
  private String visitPath ;

  /**
   * 上传文件
   * @param file
   * @return
   * @throws Exception
   */
  @PostMapping(value = "/image")
  @ApiOperation(value = "上传图片")
  public ApiResult upload(@RequestParam(value = "file",required = false) MultipartFile file) throws Exception {
    String fileName = "";
    if (file!=null && !file.isEmpty()) {
      fileName = file.getOriginalFilename();
      String type = fileName.substring(fileName.lastIndexOf("."));
      if (Arrays.asList(types).contains(type)){
        BufferedOutputStream out = null;
        File fileSourcePath = new File(savePath);
        if (!fileSourcePath.exists()) {
          //目录不存在的情况下创建目录
          fileSourcePath.mkdirs();
        }
        fileName = ((int)(Math.random()*9000)+1000)+"_"+file.getOriginalFilename();
        File fileSavePath = new File(fileSourcePath, fileName);
        logger.info("上传的文件名为：" + fileName);
        out = new BufferedOutputStream(new FileOutputStream(fileSavePath));
        out.write(file.getBytes());
        out.flush();
        //将文件设置为可读
        fileSavePath.setReadable(true,false);
        System.out.println(fileName.toString());
        return success(visitPath+"/"+fileName);
      }
      return error(RequestCode.forbid_error, "图片格式不匹配");
    }
    return error(RequestCode.forbid_error, "请输入文件");
  }
}
