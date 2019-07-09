package com.github.bingoohuang.springboottrial.controller;

import com.github.bingoohuang.springboottrial.util.MimeTypes;
import com.google.common.base.Charsets;
import lombok.SneakyThrows;
import lombok.val;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;
import java.nio.file.Files;


@RestController
public class DlController {
    @GetMapping("/dl")
    @SneakyThrows
    public ResponseEntity<byte[]> downloadByDocumentId(@Param("filename") String filename, @Param("utf8") boolean utf8) {
        val cpr = new ClassPathResource(filename);
        byte[] bytes = cpr.exists() ? Files.readAllBytes(cpr.getFile().toPath()) : "我是黄进兵".getBytes(Charsets.UTF_8);

        val headers = new HttpHeaders();
        String f = filename;
        if (utf8) {
            headers.add("Content-Type", MimeTypes.getFileMimeType(filename) + "; charset=UTF-8");
            f = URLEncoder.encode(filename, "UTF-8");
        } else {
            headers.add("Content-Type", MimeTypes.getFileMimeType(filename));
        }

        headers.add("Content-Disposition", "attachment;filename=" + f + ";filename*=UTF-8''" + f);
        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
    }
}