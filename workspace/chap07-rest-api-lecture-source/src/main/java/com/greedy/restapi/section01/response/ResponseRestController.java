package com.greedy.restapi.section01.response;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//@Controller
@RestController
@RequestMapping("/response")
public class ResponseRestController {

    @GetMapping("/hello")
//    @ResponseBody
    public String helloworld() {

        System.out.println("hello?");
        return "hello world";
    }

    @GetMapping("/random")
    public int getRandNumber() {

        return (int) (Math.random() * 10) + 1;
    }

    @GetMapping("/message")
    public Message getMessage() {

        /* 메세지 컨버터에 의해 자동 json문자열로 변경된다. */
        return new Message(200,"메세지를 응답합니다.");
    }

    @GetMapping("/list")
    public List<String> getList() {

        return List.of(new String[] {"사과", "바나나", "복숭아"});
    }

    @GetMapping("/map")
    public Map<Integer, String> getMap() {

        List<Message> messages = new ArrayList<>();
        messages.add(new Message(200, "정상 응답"));
        messages.add(new Message(404, "페이지를 찾을 수 없습니다."));
        messages.add(new Message(500, "개발자의 잘못입니다."));

        return messages.stream().collect(Collectors.toMap(Message::getHttpStatusCode, Message::getMessage));
    }

    /* produces는 response header의 content-type 설정이다. */
    @GetMapping(value = "/image", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getImage() throws IOException {

        File file = new File("C:\\Lecture\\10_spring\\04_spring-mvc\\workspace\\chap07-rest-api-lecture-source\\src\\main\\java\\com\\greedy\\restapi\\section01\\response\\sample.PNG");
        FileInputStream fin = new FileInputStream(file);

        byte[] bytes = fin.readAllBytes();

        return  bytes;
    }

    @GetMapping("/entity")
    public ResponseEntity<Message> getEntity() {

        return  ResponseEntity.ok(new Message(201, "hello world"));
    }
}
