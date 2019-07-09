package com.github.bingoohuang.springboottrial.controller;

import com.github.bingoohuang.springboottrial.util.MimeTypes;
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
import java.security.SecureRandom;


@RestController
public class DlController {
    @GetMapping("/dl") @SneakyThrows
    public ResponseEntity<byte[]> downloadByDocumentId(@Param("filename") String filename, @Param("utf8") boolean utf8) {
        HttpHeaders headers = new HttpHeaders();
        byte[] bytes = new byte[20];
        val cpr = new ClassPathResource(filename);
        if (cpr.exists()) {
            bytes = Files.readAllBytes(cpr.getFile().toPath());
        } else {
            SecureRandom.getInstanceStrong().nextBytes(bytes);
        }

        headers.add("Content-Type", MimeTypes.getFileMimeType(filename) + (utf8 ? ";charset=UTF-8" : ""));
        val f = utf8 ? URLEncoder.encode(filename, "UTF-8") : filename;
        headers.add("Content-Disposition", "attachment;filename=" + f + ";filename*=UTF-8''" + f);
        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
    }
}
