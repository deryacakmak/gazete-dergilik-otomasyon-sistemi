package com.gazete_dergi_otomasyon.controller;

import com.gazete_dergi_otomasyon.model.User;
import com.gazete_dergi_otomasyon.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.faces.bean.ViewScoped;
import java.util.List;

@Controller
@ViewScoped
public class UserController {


    @Autowired
    private IUserService userService;

    private User selectedUser;

    public List<User> getAllUser(){
        return this.userService.getAllUser();
    }


    public void removeUser(User user){
        this.userService.removeUser(user);
    }


    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }
}
