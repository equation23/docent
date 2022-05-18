package com.docent.sp1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Controller
public class ChatBotController {

    @RequestMapping(value = "/bot", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody

    String webhook(HttpServletRequest request, @RequestBody Map<String, Object> map) {
        System.out.println(map);

        String jsonObject ="";
        return jsonObject;
    }


}