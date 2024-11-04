package com.klu.jfsd.jar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;



@RestController
public class HomeController {

    @GetMapping("/")
    public String home(HttpServletRequest request, 
                       @RequestHeader(value = "User-Agent") String userAgent) {
        
    	String clientIp=request.getRemoteAddr();
    	
        String ipAddress = getClientIp(request);
        String method = request.getMethod();
        String requestedURI = request.getRequestURI();

        // Construct a response (you can log this instead)
        StringBuilder response = new StringBuilder();
        response.append("Welcome to the Spring Boot Application!<br/>")
                .append("Your IP Address: ").append(ipAddress).append("<br/>")
                .append("Your User-Agent: ").append(userAgent).append("<br/>")
                .append("HTTP Method: ").append(method).append("<br/>")
                .append("Requested URI: ").append(requestedURI).append("<br/>")
                .append("Other Data: ").append(clientIp).append("<br/>").append("Hello").append(request.getServerPort());
        

        

        return response.toString();
    }

    private String getClientIp(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-Forwarded-For");
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
        }
        // If multiple IPs are present (common in X-Forwarded-For), take the first one
        if (ipAddress != null && ipAddress.contains(",")) {
            ipAddress = ipAddress.split(",")[0];
        }
        return ipAddress;
    }

   
}
