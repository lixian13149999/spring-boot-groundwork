package com.bcdbook.common.demo.result;

import com.bcdbook.common.result.Result;
import com.bcdbook.common.result.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lason on 2017/7/9.
 */
@RestController
@RequestMapping("/demo/result")
public class ResultController {

    /**
     * 返回一个统一返回值对象的测试方法
     * @return
     */
    @GetMapping("/success")
    @ResponseBody
    public Result helloResult(){

        return ResultUtil.success();
    }
}
