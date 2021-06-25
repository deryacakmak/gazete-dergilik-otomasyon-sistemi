package com.gazete_dergi_otomasyon.controller;

import com.gazete_dergi_otomasyon.dto.LoginDto;
import com.gazete_dergi_otomasyon.exception.AccessException;
import com.gazete_dergi_otomasyon.service.AccessService;
import com.gazete_dergi_otomasyon.service.IAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Controller
public class AccessController {

    @Autowired
    IAccessService accessService;

    public String login(LoginDto loginDto){
        try{
            this.accessService.login(loginDto.getEmail(), loginDto.getPassword());
        }
        catch (AccessException ex){
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                    ex.getMessage(),"");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "";
        }
        return "home";
    }




}
