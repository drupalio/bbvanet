package com.bbva.net.webservices.subjects.impl;

import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.web.client.RestClientException;

import com.bbva.net.webservices.core.pattern.AbstractBbvaRestService;
import com.bbva.net.webservices.core.stereotype.RestService;
import com.bbva.net.webservices.subjects.SubjetsService;
import com.bbva.zic.subjects.v01.UpdateAccountOut;
import com.bbva.zic.subjects.v01.UpdateSubjectIn;

@RestService(value = "subjetsService")
public class SubjetsServiceImpl extends AbstractBbvaRestService implements SubjetsService {
    
    @Override
    public UpdateAccountOut updateSubject(String contractNumber, UpdateSubjectIn updatesubjectin) {
        try {
            final WebClient webc = getJsonWebClient(URL_SUBJETS + contractNumber);
            UpdateAccountOut response = webc.put(updatesubjectin, UpdateAccountOut.class);
            if (webc.getResponse().getStatus() == 200) {
                LOGGER.info("Servicio updateSubject actualizó el alias");
                return response;
            }
        } catch (Exception ex) {
            LOGGER.info("[Servicio updateSubject No respondió al actualizar el alias] " + ex.getMessage());
            throw new RestClientException(
                    "Servicio no disponible - No se ha podido actualizar el alias, para mayor información comunicate a nuestras líneas BBVA");
        }
        return new UpdateAccountOut();
    }
}
