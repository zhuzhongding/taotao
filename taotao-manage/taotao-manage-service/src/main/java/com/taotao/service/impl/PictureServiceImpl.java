package com.taotao.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.utils.FtpUtil;
import com.taotao.common.utils.IDUtils;
import com.taotao.service.PictureService;

@Service
public class PictureServiceImpl implements PictureService {

    @Value("${FTP_ADDRESS}")
    private String FTP_ADDRESS;
    @Value("${FTP_PORT}")
    private Integer FTP_PORT;
    @Value("${FTP_USER_NAME}")
    private String FTP_USER_NAME;
    @Value("${FTP_PASSWORD}")
    private String FTP_PASSWORD;
    @Value("${FTP_BASE_PATH}")
    private String FTP_BASE_PATH;
    @Value("${IMAGE_BASE_URL}")
    private String IMAGE_BASE_URL;

    
    @Override
    public Map uploadPicture(MultipartFile uploadFile) {
        Map resultMap = new HashMap<>();
        try {
            //取文件扩展名
            String originalFilename = uploadFile.getOriginalFilename();
            String oldName = originalFilename.substring(originalFilename.lastIndexOf("."));
            //生成新文件名
            //可以使用uuid生成新文件名。
            //UUID.randomUUID()
            //可以是时间+随机数生成文件名
            String imagePath = new DateTime().toString("/yyyy/MM/dd");
            String imageName = IDUtils.genImageName();
            imageName= imageName + oldName.substring(oldName.lastIndexOf("."));
            boolean result = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USER_NAME, FTP_PASSWORD, IMAGE_BASE_URL, imagePath, imageName, uploadFile.getInputStream());
            //返回结果
            if(!result) {
                resultMap.put("error", 1);
                resultMap.put("message", "文件上传失败");
                return resultMap;
            }
            resultMap.put("error", 0);
            resultMap.put("url", IMAGE_BASE_URL+ imagePath +"/" +imageName);
            return resultMap;
            
        }catch(Exception e) {
            resultMap.put("error", 1);
            resultMap.put("message", "上传发生异常");
            return resultMap;
        }
    }

}
