package com.qul.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@Controller
public class VersionController {

    @RequestMapping("/getVersion")
    @ResponseBody
    public String getVersion(){
        StringBuilder sb=new StringBuilder();
        String version = readGitProperties().split("\n")[7].split("=")[1];
        String hash = readGitProperties().split("\n")[11].split("=")[1];
        sb.append(version).append("+").append(hash);
        return sb.toString();
    }
    /**
     * 读取Git文件
     * @return
     */
    private String readGitProperties() {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("git.properties");
        return readFromInputStream(inputStream);
    }
    private String readFromInputStream(InputStream inputStream) {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream,"utf-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
            inputStream.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultStringBuilder.toString();
    }
}
