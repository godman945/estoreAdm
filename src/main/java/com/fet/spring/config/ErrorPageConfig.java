//package com.fet.spring.config;
//
//import org.springframework.boot.web.server.ErrorPage;
//import org.springframework.boot.web.server.ErrorPageRegistrar;
//import org.springframework.boot.web.server.ErrorPageRegistry;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpStatus;
//
//@Configuration
//public class ErrorPageConfig implements ErrorPageRegistrar {
//
//    @Override
//    public void registerErrorPages(ErrorPageRegistry registry) {
//    	System.out.println("錯誤頁測試");
//    	
//        ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
//        registry.addErrorPages(error404Page);
//    }
//}