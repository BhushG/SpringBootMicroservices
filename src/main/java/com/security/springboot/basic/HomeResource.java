package com.security.springboot.basic;

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

    @GetMapping(path = "/admin")
    public String admin()
    {
        return "<h1>Welcome Admin<h1>";
    }

    @GetMapping(path = "/user")
    public String user()
    {
        return "<h1>Welcome User<h1>";
    }
}
