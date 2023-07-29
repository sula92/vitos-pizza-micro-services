package com.vitospizza.userservice.controller;


import com.vitospizza.userservice.dto.UserLoginDTO;
import com.vitospizza.userservice.model.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping(
        value = "/api",
        produces = "application/json")

@CrossOrigin(origins = {
        "*"

},
        allowedHeaders = "*",

        maxAge = 15 * 60,
        methods = {
                RequestMethod.GET,
                RequestMethod.POST,
                RequestMethod.DELETE,
                RequestMethod.PUT
        })
@Transactional
public class UserController {

    @Autowired
    UserRepository userRepository;

    private final String placeOrderPage="place-order.html";
    private final String errorPage="error.html";

    @PostMapping("/users/login")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @SneakyThrows
    public String  login(/*@RequestBody UserLoginDTO userLoginDTO*/){

        /*System.out.println("hhhhhhhhhhhhhhh");
        System.out.println(userLoginDTO.getUserName());
        System.out.println(userLoginDTO.getPassword());


         userRepository.findAll().stream().anyMatch(
                user -> user.getUserName().equalsIgnoreCase(userLoginDTO.getUserName())
                        &
                        user.getPassword().equalsIgnoreCase(userLoginDTO.getPassword())
        );*/

         return "";
       /* for (User user:users) {
            if(user.getUserName().equalsIgnoreCase(userLoginDTO.getUserName()) &
                    user.getPassword().equalsIgnoreCase(userLoginDTO.getPassword()) &
                    user.getPrivilege().equalsIgnoreCase("customer")){

                Session.userId= String.valueOf(user.getId());
                Session.userName=user.getUserName();
                Session.privilege=user.getPrivilege();

                System.out.println(user.getPrivilege());

                return new UserInfoDTO(String.valueOf(user.getId()), placeOrderPage, user.getPrivilege());
            }
        }*/
        //return new UserInfoDTO("error", errorPage, "error");

    }

    @GetMapping("/test")
    @ResponseStatus(HttpStatus.OK)
    public Boolean test(){
        return true;
    }

}
