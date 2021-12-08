package com.firstsample.demoproject;

import com.google.gson.JsonObject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.joran.conditional.ElseAction;



@RestController
public class controller {
    
    @RequestMapping(method = RequestMethod.GET, value = "/FetchNextNumber")
    public String getData(@RequestParam(value = "num") Integer n2) {
        var l = DemoprojectApplication.columns;
        int num1 = n2;
        if (l.contains(num1))
        {
            int result = 0;
            if (num1 % 9 == 0) {
                result = num1 + 1;
            } else {
                result = num1 + (9 - (num1 % 9)) + 1;
            }
            JsonObject json_return = new JsonObject();
            json_return.addProperty("old value", n2);
            json_return.addProperty("New value", result);
            json_return.addProperty("Comments", "Category code available in table");
    
            return String.valueOf(json_return);
        }
        else
        {
            JsonObject json_return = new JsonObject();
            json_return.addProperty("old value", n2);
            json_return.addProperty("New value", 0);
            json_return.addProperty("Comments", "Category code not available in table");
            return String.valueOf(json_return);
        }
    }
}