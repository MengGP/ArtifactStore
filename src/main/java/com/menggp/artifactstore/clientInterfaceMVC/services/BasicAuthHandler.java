package com.menggp.artifactstore.clientInterfaceMVC.services;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

// Класс для basic authentication в REST-запросах
@Service
public class BasicAuthHandler {

    //  Метод формирует HTTP-headers для использования Basic-Authentication в REST запросах
    public static HttpHeaders getHeaders(){
        String plainCredentials="user:user";
        String base64Credentials = new String(Base64.encodeBase64(plainCredentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        // headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return headers;
    } // end_class

} // end_class
