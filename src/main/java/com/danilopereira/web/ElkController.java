package com.danilopereira.web;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.PrintWriter;
import java.io.StringWriter;

@RestController
public class ElkController {

    private static final Logger LOG = Logger.getLogger(ElkController.class.getName());

    @GetMapping("/success")
    public String success(){
        String response = "Success!";
        LOG.log(Level.INFO, "/success" + response);
        return response;
    }

    @GetMapping("/error")
    public int error(){
        int i = 0;
        try {
            i = 1/0;
        }catch (Exception e){
            e.printStackTrace();
            LOG.error(e);
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            LOG.error(sw.toString());
        }

        return i;
    }

}
