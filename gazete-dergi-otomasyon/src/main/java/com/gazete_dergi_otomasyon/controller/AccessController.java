package com.gazete_dergi_otomasyon.controller;

import com.gazete_dergi_otomasyon.dto.LoginDto;
import com.gazete_dergi_otomasyon.dto.SignUpDto;
import com.gazete_dergi_otomasyon.exception.AccessException;
import com.gazete_dergi_otomasyon.service.IAccessService;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.validation.ConstraintViolationException;
import java.security.NoSuchAlgorithmException;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

@Controller
@ViewScoped
public class AccessController {

    @Autowired
     private IAccessService accessService;

    public AccessController() {}

    public String login(LoginDto loginDto){
        try{
            this.accessService.login(loginDto.getEmail(), loginDto.getPassword());
            resetLoginInputText(loginDto);
        }
        catch (AccessException | NoSuchAlgorithmException ex){
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "UYARI",ex.getMessage());
            PrimeFaces.current().dialog().showMessageDynamic(msg);
            return "";
        }
        return "index";
    }

    public String signUp(SignUpDto signUpDto){
            try{
                this.accessService.signUp(signUpDto.getFirstName(),signUpDto.getLastName(), signUpDto.getEmail(), signUpDto.getPassword());
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "UYARI","Kaydolma İşlemi Başarılı!");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                resetSignUpInputText(signUpDto);
            }
            catch (AccessException ex){
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                      "UYARI",  ex.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return "";
            }
            catch(ConstraintViolationException ex){
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "UYARI","Mail formatına uygun giriniz");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return "";
            }
            catch (NoSuchAlgorithmException ex) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                       "UYARI" , "Lütfen başka şifre deneyin");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return "";
            }
        return "";
    }

    private void resetSignUpInputText(SignUpDto signUpDto){
        signUpDto.setEmail(null);
        signUpDto.setFirstName(null);
        signUpDto.setLastName(null);
    }

    private void resetLoginInputText(LoginDto loginDto){
        loginDto.setEmail(null);
    }


}