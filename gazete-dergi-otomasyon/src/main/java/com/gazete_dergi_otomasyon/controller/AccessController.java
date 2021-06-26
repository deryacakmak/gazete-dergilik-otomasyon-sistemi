package com.gazete_dergi_otomasyon.controller;

import com.gazete_dergi_otomasyon.dto.LoginDto;
import com.gazete_dergi_otomasyon.dto.SignUpDto;
import com.gazete_dergi_otomasyon.exception.AccessException;
import com.gazete_dergi_otomasyon.service.IAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.validation.ConstraintViolationException;

@Controller
public class AccessController {

    @Autowired
     private IAccessService accessService;

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
        return "index";
    }


    public String signUp(SignUpDto signUpDto){
            try{
                this.accessService.signUp(signUpDto.getFirstName(),signUpDto.getLastName(), signUpDto.getEmail(), signUpDto.getPassword());
            }
            catch (AccessException ex){
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                        ex.getMessage(),"");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return "";
            }
            catch(ConstraintViolationException ex){
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Mail formatına uygun giriniz","");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return "";
            }

        return "login";
    }




    public IAccessService getAccessService() {
        return accessService;
    }

    public void setAccessService(IAccessService accessService) {
        this.accessService = accessService;
    }
}
