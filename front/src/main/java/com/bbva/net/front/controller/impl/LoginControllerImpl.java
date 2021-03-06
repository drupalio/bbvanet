package com.bbva.net.front.controller.impl;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Value;

import com.bbva.net.back.facade.LoginFacade;
import com.bbva.net.front.controller.LoginController;
import com.bbva.net.front.core.AbstractBbvaController;
import com.bbva.saz.co.grantingticket.v01.AuthenticationState;

public class LoginControllerImpl extends AbstractBbvaController implements LoginController {
    
    private static final long serialVersionUID = 1L;
    
    @Resource(name = "loginFacade")
    private LoginFacade loginFacade;
    
    @Value("${granting.ivTicketId}")
    private String IV_TICKET_SERVICE;
    
    @Override
    public void login() {
        try {
            LOGGER.info("LOGIN BBVA NET .................");
            // 1 Create Session;
            final FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.getExternalContext().getSession(true);
            
            LOGGER.info("Leyendo de cabecera ... " + IV_TICKET_SERVICE);
            // 2. Get iv_ticketService from header
            final String ivTicketValue = getRequest().getHeader("iv_ticketService");
            
            // 3. Set CurrentUser
            final String user = getRequest().getHeader("iv-user");
            
            // 4. Get cod-client
            final String codClient = getRequest().getHeader("codigo_cliente");
            
            this.setDefaultUser(user);
            LOGGER.info("Login with User: " + user);
            LOGGER.info("iv_ticketService: " + ivTicketValue);
            LOGGER.info("Login with codClient: " + codClient);
            
            // 4. Set status User
            String statusUSer = getRequest().getHeader("iv_TX_CESTADO");
            if ( statusUSer == null ) {
                statusUSer = "";
            }
            LOGGER.info("iv_TX_CESTADO: " + statusUSer);
            
            if ( statusUSer.equals("SINTJC") ) {
                LOGGER.info("Sin tarjeta de coordenadas ");
                // <!-- Entelgy / SPRING 1 / 05112015 / INICIO -->
                FacesContext ctx = FacesContext.getCurrentInstance();
                ctx.addMessage(
                        "login",
                        new FacesMessage(
                                FacesMessage.SEVERITY_ERROR,
                                "Ha vencido su plazo para ingresar sin tarjeta Net Segura",
                                "Por favor acérquese a cualquiera de nuestras sucursales y solicitela. Una vez hecho esto usted podrá ingresar al portal transaccional. Para mayor información, comuniquese a nuestras Líneas BBVA"));
                // <!-- Entelgy / SPRING 1 / 05112015 / INICIO -->
            } else {
                LOGGER.info("Con tarjeta de coordenadas");
                // 4. Invocar al GrantingTicket y almacenar AuthenticationState
                final AuthenticationState authenticationState = this.loginFacade.login(ivTicketValue, user,
                        getRequestParameter("pass"), getRequestParameter("numero"), getRequestParameter("tipo"));
                // 5. Put in Session
                this.getSession().setAttribute(SessionParamenterType.AUTHENTICATION_STATE.name(), authenticationState);
                this.getSession().setAttribute("userName", user.substring(0, 8));
                this.getSession().setAttribute("docTypeUser", user.substring(8, 10));
                this.getSession().setAttribute("docIdUser", user.substring(10, 25));
                this.getSession().setAttribute("codClient", codClient);
            }
            
        } catch (Exception e) {
            LOGGER.info("Error al iniciar sesión " + e.getMessage());
            try {
                getSession().removeAttribute("tsec");
                getSession().removeAttribute(SessionParamenterType.AUTHENTICATION_STATE.name());
                getSession().removeAttribute("userName");
                getSession().removeAttribute("docTypeUser");
                getSession().removeAttribute("docIdUser");
                getSession().removeAttribute("codClient");
                FacesContext context = FacesContext.getCurrentInstance();
                context.getExternalContext().redirect("/kqco_co_web/errorService/errorService.xhtml");
            } catch (Exception d) {
                
            }
            
        }
    }
    
    /**
     * @param loginFacade
     */
    public void setLoginFacade(LoginFacade loginFacade) {
        this.loginFacade = loginFacade;
    }
    
}
