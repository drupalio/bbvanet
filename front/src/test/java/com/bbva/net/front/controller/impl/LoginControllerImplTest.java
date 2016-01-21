package com.bbva.net.front.controller.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import com.bbva.net.back.facade.LoginFacade;
import com.bbva.net.front.test.utils.AbstractBbvaControllerTest;
import com.bbva.saz.co.grantingticket.v01.AuthenticationState;

public class LoginControllerImplTest extends AbstractBbvaControllerTest {

    private LoginControllerImpl loginController;

    // Mocks
    private LoginFacade loginFacade;

    @Before
    public void init() {

        super.setUp();
        this.loginController = new LoginControllerImpl();
        this.loginFacade = Mockito.mock(LoginFacade.class);
        this.loginController.setLoginFacade(this.loginFacade);

    }

    @Test
    public void testLogin_OK() {

        // Configure Mocks
        Mockito.when(request.getHeader("iv-user")).thenReturn("julio123CC000001020715321");
        Mockito.when(request.getHeader("iv_ticketService")).thenReturn(
                "cqwAIvi92lzshpPQR9RYK2RFo9axRY697/TtCA4N/bnM6d5znws5S1T3rYwHVRU3YnYvpZZXF4s=");
        Mockito.when(request.getHeader("iv_TX_CESTADO")).thenReturn("asdas");
        Mockito.when(request.getHeader("codigo_cliente")).thenReturn("123");
        Mockito.when(request.getParameter("pass")).thenReturn("91261343");
        Mockito.when(request.getParameter("numero")).thenReturn("1020715321");
        Mockito.when(request.getParameter("tipo")).thenReturn("CC");

        Mockito.when(
                this.loginFacade.login("cqwAIvi92lzshpPQR9RYK2RFo9axRY697/TtCA4N/bnM6d5znws5S1T3rYwHVRU3YnYvpZZXF4s=",
                        "julio123CC000001020715321", "91261343", "1020715321", "CC"))
                .thenReturn(
                        new AuthenticationState());

        // Invoke Check method
        this.loginController.login();

        Mockito.when(request.getHeader("iv_TX_CESTADO")).thenReturn("SINTJC");
        // Invoke Check method
        this.loginController.login();

        // Assert and verify results
        Mockito.verify(this.loginFacade, Mockito.atLeastOnce()).login(
                "cqwAIvi92lzshpPQR9RYK2RFo9axRY697/TtCA4N/bnM6d5znws5S1T3rYwHVRU3YnYvpZZXF4s=",
                "julio123CC000001020715321", "91261343", "1020715321", "CC");
    }

    @Test
    public void testLogin_No_Ok() {

        Mockito.when(
                this.loginFacade.login(Matchers.anyString(), Matchers.anyString(), Matchers.anyString(),
                        Matchers.anyString(), Matchers.anyString()))
                .thenReturn(new AuthenticationState());

        // Invoke Check method
        this.loginController.login();

    }
}
