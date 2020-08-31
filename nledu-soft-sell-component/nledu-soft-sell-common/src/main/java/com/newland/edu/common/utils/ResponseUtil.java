package com.newland.edu.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.newland.edu.common.model.Result;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/***
 * Response响应处理工具类
 * @author majun
 * @date 2020/8/31
 */
public class ResponseUtil {
    private ResponseUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static void responseUnAuthorized(ObjectMapper objectMapper, HttpServletResponse response, String msg) throws IOException {
        Result result = Result.failed(msg);
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        //response.setStatus(HttpStatus.UNAUTHORIZED.value());
        try (
                Writer writer = response.getWriter()
        ) {
            writer.write(objectMapper.writeValueAsString(result));
            writer.flush();
        }
    }

    public static void responseUnAccessed(ObjectMapper objectMapper, HttpServletResponse response, String msg) throws IOException {
        Result result = Result.failed(msg);
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        //response.setStatus(HttpStatus.FORBIDDEN.value());
        try (
                Writer writer = response.getWriter()
        ) {
            writer.write(objectMapper.writeValueAsString(result));
            writer.flush();
        }
    }
}
