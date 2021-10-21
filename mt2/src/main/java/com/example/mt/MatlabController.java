package com.example.mt;

import com.mathworks.toolbox.javabuilder.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import yxy_test.*;

import java.util.Random;

@RestController
@RequestMapping("/api")
public class MatlabController {


    @RequestMapping("/test")
    @ResponseBody
    public String test() throws MWException {
        Random random = new Random();
        Object[] input = new Object[2];
        Object[] result = new Object[1];
        input[0]=random.nextInt(10);
        input[1]=random.nextInt(10);

        jifaceshi jiafa = new jifaceshi();
        jiafa.yxy_test(result, input);
        return  String.format("加法测试%s+%s=%s",  input[0].toString(), input[1].toString(),result[0].toString());
    }

}
