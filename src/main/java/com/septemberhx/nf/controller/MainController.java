package com.septemberhx.nf.controller;

import com.septemberhx.common.bean.MResponse;
import com.septemberhx.mclient.annotation.MFuncDescription;
import com.septemberhx.nf.utils.MBaseUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author SeptemberHX
 * @version 0.1
 * @date 2020/3/31
 */
@Controller
public class MainController {

    private Logger logger = LogManager.getLogger(this);

    @PostMapping(path = "/PDelivery")
    @ResponseBody
    @MFuncDescription(value = "PDelivery", level = 5)
    public MResponse pdelivery(@RequestBody MResponse params, HttpServletRequest request) {
        boolean r = MBaseUtils.verDepRequest("pay", 18, request, logger);

        if (!r) {
            return MResponse.failResponse();
        }
        return MBaseUtils.generateResInKBSize(14);
    }
}
