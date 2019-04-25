package com.cloud.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.net.URLEncoder;

/**
 * <p>
 *
 * </p>
 *
 * @Title BaseController.java
 * @Package com.cloud.swaggerconfig
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/4/25 12:09
 */
@Slf4j
public class BaseController {
    /**
     * <p>
     * method: 'post',
     * responseType: 'arraybuffer'
     *
     * </p>
     *
     * @params: [filename]
     * @return: org.springframework.http.ResponseEntity<org.springframework.core.io.InputStreamResource>
     * @Author: au .T
     * @Date: 2019/4/24 14:42
     */
    @PostMapping("/template/download/{filename}")
    public ResponseEntity<InputStreamResource> downloadExcel(@PathVariable String filename) {
        try {
            Resource resource = new ClassPathResource("template/excel/" + filename);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
            headers.add("Content-Disposition", String.format("attachment; filename=%s", URLEncoder.encode(filename, "UTF-8")));
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");
            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .contentLength(resource.contentLength())
                    .contentType(MediaType.parseMediaType("application/octet-stream"))
                    .body(new InputStreamResource(resource.getInputStream()));
        } catch (IOException e) {
            log.error("下载文件出错", e);
            return ResponseEntity.ok().contentLength(0).contentType(MediaType.parseMediaType("application/octet-stream")).body(null);
        }
    }
}
