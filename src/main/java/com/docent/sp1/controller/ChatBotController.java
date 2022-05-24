package com.docent.sp1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class ChatBotController {

    @RequestMapping(value = "/bot", method = {RequestMethod.GET, RequestMethod.POST},produces = "applicaion/json;charset=UTF-8")
    public @ResponseBody String webhook(HttpServletRequest request, @RequestBody Map<String, Object> map) {

        System.out.println(map);
        String value =((Map)map.get("queryResult")).get("queryText").toString();
        System.out.println("INPUT VALUE" + value);
        String str ="{\"fulfillmentMessages\": [{\"text\": { \"text\": [\""+ new String("문의 접수가 완료되었습니다.")+"\"]}}]}";

        return str;
    }


}