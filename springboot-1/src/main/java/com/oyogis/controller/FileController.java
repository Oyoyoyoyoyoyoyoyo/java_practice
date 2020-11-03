package com.oyogis.controller;

import com.oyogis.common.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * 文件上传下载控制类
 */
@Api(tags = "文件上传下载")
@RestController
@RequestMapping("/file")
public class FileController {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileController.class);

    @ApiOperation(value = "文件上传")
    @PostMapping("/upload")
    public CommonResult upload(@RequestParam("test") MultipartFile file) {
        if (file.isEmpty()) {
            return CommonResult.failed("文件为空");
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        LOGGER.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        LOGGER.info("上传的后缀名为：" + suffixName);
        // 文件上传后的路径
        String outFilePath = new File("").getAbsolutePath();
        outFilePath = outFilePath.replace("\\", "//");
        // 解决中文问题，linux下中文路径，图片显示问题
        // fileName = UUID.randomUUID() + suffixName;
        File dest = new File(outFilePath + "//static//" + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            return CommonResult.success("上传成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CommonResult.failed("上传失败");
    }

    @ApiOperation(value = "文件下载", notes = "文件下载后存入下载文件夹")
    @GetMapping("/download")
    public CommonResult downloadFile(HttpServletRequest request, HttpServletResponse response) {
        //文件名称
        String fileName = "test.txt";
        if (fileName != null) {
            // 下载文件路径
            String filePath = new File("").getAbsolutePath();
            filePath = filePath.replace("\\", "//") + "//static//";
            System.out.println("realPath = " + filePath);
            File file = new File(filePath, fileName);
            if (file.exists()) {
                response.setContentType("application/force-download");
                // 设置强制下载不打开
                response.addHeader("Content-Disposition",
                        "attachment;fileName=" + fileName);
                // 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }

                    CommonResult.success("下载成功");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return CommonResult.failed("下载失败");
    }

    @ApiOperation(value = "多文件上传")
    @PostMapping("/mUpload")
    public CommonResult handleFileUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        // 文件上传后的路径
        String outFilePath = new File("").getAbsolutePath();
        outFilePath = outFilePath.replace("\\", "//");
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    String fileName = new File(file.getOriginalFilename()).getName();
                    String filePath = outFilePath + "//static//" + fileName;
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(filePath));
                    stream.write(bytes);
                    stream.close();

                } catch (Exception e) {
                    stream = null;
                    e.getMessage();
                    return CommonResult.failed("上传失败");
                }
            } else {
                return CommonResult.failed("上传失败");
            }
        }
        return CommonResult.success("上传成功");
    }
}
