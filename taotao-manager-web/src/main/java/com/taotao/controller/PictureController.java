package com.taotao.controller;

import com.taotao.common.utlis.JsonUtils;
import com.taotao.utils.FastDFSClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 990014
 * @Date: 2018/4/24 14:51
 * @Description:图片上传
 */
@Controller
@Slf4j
public class PictureController {

    @Value("${IMAGE_SERVER_URL}")
    private String IMAGE_SERVER_URL;
    @RequestMapping("/pic/upload")
    @ResponseBody//由于火狐浏览器不在支持返回json对象 所以返回字符串
    public String picUpload(MultipartFile uploadFile){
        try {
        //接收上传的文件
        //取扩展名
        String filename = uploadFile.getOriginalFilename();
        String extName = filename.substring(filename.lastIndexOf(".") + 1);
        //上传到图片服务器
        FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
        String url = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
        url = IMAGE_SERVER_URL+url;
        //响应上传图片的url
            Map resutlMap = new HashMap();
            resutlMap.put("error",0);
            resutlMap.put("url",url);
            return JsonUtils.objectToJson(resutlMap);
        } catch (Exception e) {
            log.warn("uploadFile error!",e);
            Map resutlMap = new HashMap();
            resutlMap.put("error",1);
            resutlMap.put("message","图片上传失败");
            return JsonUtils.objectToJson(resutlMap);
        }

    }
}
