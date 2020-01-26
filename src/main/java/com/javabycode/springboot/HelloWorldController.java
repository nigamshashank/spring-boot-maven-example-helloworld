package com.javabycode.springboot;

import com.javabycode.springboot.domain.UserResponse;
import com.javabycode.springboot.entity.User;
import com.javabycode.springboot.service.UserService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloWorldController {

    protected static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldController.class);
    @Autowired
    private UserService userService;
    @Autowired
    protected ModelMapper pojoMapper;

    @RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        
        String message="You just create Spring Boot Example successfully";
        model.addAttribute("name", name);
        model.addAttribute("message", message);
        
        return "hello";
    }

    @RequestMapping(value="", method= RequestMethod.GET)
    public List<UserResponse> getUsers() {
        LOGGER.debug("Received request to list all users");
        List<User> users = new ArrayList<User>();
        users = (List<User>) userService.findAll();
        // convert User to UserResponse
        List<UserResponse> usersResponse = new ArrayList<UserResponse>();
        for (User user : users) {
            usersResponse.add(pojoMapper.map(user, UserResponse.class));
        }
        return usersResponse;
    }
}
