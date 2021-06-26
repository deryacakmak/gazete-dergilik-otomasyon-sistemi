<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:ui="http://java.sun.com/jsf/facelets"
      xmlns:p="http://primefaces.org/ui">

<h:head>
</h:head>
<h:body>
    <h:form id="LoginForm">
        <p:dialog header="Login" widgetVar="dlg" resizable="false">
            <h:panelGrid columns="2" cellpadding="5">
                <h:outputLabel for="username" value="Username:" />
                <p:inputText id="username" value="#{loginDto.username}" required="true" label="username" />

                <h:outputLabel for="password" value="Password:" />
                <p:password id="password" value="#{loginDto.password}" required="true" label="password" />

                <f:facet name="footer">
                    <p:commandButton value="Login" update="growl" action="#{accessController.login(loginDto)}"
                                     oncomplete="handleLoginRequest(xhr, status, args)" />
                </f:facet>
            </h:panelGrid>
        </p:dialog>
    </h:form>
</h:body>
</html>