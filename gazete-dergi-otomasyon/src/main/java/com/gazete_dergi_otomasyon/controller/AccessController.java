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
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

@Controller
public class AccessController {

    @Autowired
     private IAccessService accessService;

    public AccessController() {}

    public String login(LoginDto loginDto){
        try{
            this.accessService.login(loginDto.getEmail(), loginDto.getPassword());
        }
        catch (AccessException | NoSuchAlgorithmException ex){
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
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                       "Kayıt Olma İşlemi Başarılı","");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                TimeUnit.SECONDS.sleep(1);
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
            catch (NoSuchAlgorithmException ex) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Lütfen başka şifre deneyin", "");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return "";

            } catch (InterruptedException e) {
                e.printStackTrace();
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