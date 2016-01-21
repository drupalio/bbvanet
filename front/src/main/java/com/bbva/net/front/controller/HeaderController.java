package com.bbva.net.front.controller;

import com.bbva.net.back.model.header.CustomerDto;
import com.bbva.net.back.model.header.ExecutiveDto;

public interface HeaderController {

    ExecutiveDto getExecutive();

    CustomerDto getCustomer();

    CustomerDto getCliente();

    void logOut();

    void setLastDownload(String file);

    void deleteLastDownload();
}
