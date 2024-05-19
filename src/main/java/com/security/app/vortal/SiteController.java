package com.security.app.vortal;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class SiteController {

    @PostMapping(value = "/app")
    public String login(){
        return "App from register users endpoint -Welcome";
    }
}
