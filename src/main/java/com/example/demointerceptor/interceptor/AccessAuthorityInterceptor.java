package com.example.demointerceptor.interceptor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demointerceptor.service.AccessCheckService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class AccessAuthorityInterceptor extends HandlerInterceptorAdapter {
    private final AccessCheckService accessCheckService;
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        log.info("=== call preHandler =====");
        
        // get token 
        String orgId = request.getParameter("org_id");

        boolean checkResult = accessCheckService.isAllow(orgId);
        if (checkResult) return true;

        sendResponse(response);

        return false;        
    }

    private void sendResponse(HttpServletResponse response) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE.toString());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.getWriter().write(getMessage());
        response.getWriter().flush();
    }

    private String getMessage() {
        Map<String, Object> data = new HashMap<>();
        data.put("code", "111");
        data.put("err_msg", "error");
        try {
            String json = mapper.writeValueAsString(data);
            return json;
        } catch (Exception e) {
            log.warn("interceptor message build error");
            return "";
        }
    }
}
