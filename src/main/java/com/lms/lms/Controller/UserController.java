package com.lms.lms.Controller;

import com.lms.lms.entiry.Users;
import com.lms.lms.dao.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping(value = "/home/users/issued" , method = RequestMethod.GET)
    public List<Map<Integer, Users>> getAllIssuedUsers() throws SQLException {
        return userService.getAllIssuedUsers();
    }
    @RequestMapping(value = "/home/users" , method = RequestMethod.GET)
    public List<Users> getAllUsers(){
        return userService.getAllUsers();
    }
    @RequestMapping(value = "/home/users/{id}" , method = RequestMethod.GET)
    public Users getUser(@PathVariable String id){
        return userService.getUser(id);
    }

    @RequestMapping(value = "/home/users" , method = RequestMethod.POST)
    public int addUser(@RequestBody Users users){
        return userService.addUser(users);
    }

    @RequestMapping(value = "/home/users" , method = RequestMethod.PUT)
    public int updateUser(@RequestBody Users users){
        return userService.updateUser(users);
    }

    @RequestMapping(value = "/home/users/{id}" , method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable String id){
        userService.deleteUser(Integer.parseInt(id));
    }

}
