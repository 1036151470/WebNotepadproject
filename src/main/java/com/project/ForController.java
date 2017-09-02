package com.project;

import com.alibaba.fastjson.JSON;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;

@Controller
@Scope("prototype")
public class ForController {

    @GetMapping("/exit")
    public String exit() {
        System.exit(0);
        return "";
    }


    @PostMapping("/intofile")
    @ResponseBody
    public Object intofile(String files) throws IOException {
        System.out.println(files);
        File file = new File(files);

        if (!file.exists()) {
            return "error";
        }

        Justpojo justpojo = new Justpojo();
        justpojo.setName(file.getName());
        justpojo.setAddress(file.getParent());
        justpojo.setSize(String.valueOf(file.length()));
        justpojo.setAbsoluteFile(String.valueOf(file.getAbsoluteFile()));
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuffer stringBuffer = new StringBuffer();
        String line = null;
        while ((line = reader.readLine()) != null) {
            stringBuffer.append(line + "\r\n");
        }
        justpojo.setContext(stringBuffer.toString());

        reader.close();
        return JSON.toJSONString(justpojo);
    }


    @PostMapping("/savefile")
    public String savefile(String context, String absoluteFile) throws IOException {
        context = context.replace("&#10;", "");

        FileOutputStream outputStream = new FileOutputStream(absoluteFile);
        outputStream.write(context.getBytes());
        outputStream.close();
        return "isok";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}

