package com.security.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource
{
    @GetMapping(path = "/")
    public String home()
    {
        return "<h1>Welcome<h1>";
    }
}
