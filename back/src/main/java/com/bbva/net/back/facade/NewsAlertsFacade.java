package com.bbva.net.back.facade;

import java.util.List;

import com.bbva.net.back.model.newsAlerts.NewsAlertsDTOTest;

/**
 * @author Entelgy
 */
public interface NewsAlertsFacade {

	/**
	 * @return Objeto con lista de alertas y novedades de un usuario Si no existen alertas devolverá una instancia con el
	 *         método isEmpty a true;
	 */
	List<NewsAlertsDTOTest> getNewsAlertsList();

	/**
	 * Metodo encargado de eliminar alertas y novedades
	 * 
	 * @param List<NewsAlertsDTO> Identificador del objeto NewsAlerts
	 * @return boolean si pudo eliminar o no la(s) alerta(s)
	 **/
	boolean deleteNewsAlertsFacade(List<NewsAlertsDTOTest> newsAlertSelectedList);

	/**
	 * Metodo encargado de cambiar el estado de alertas y novedades a no visto
	 * 
	 * @param List<NewsAlertsDTO> Identificador del objeto NewsAlerts
	 * @return boolean si pudo cambiar el estado o no la(s) alerta(s)
	 **/
	boolean changeNoViewedState(List<NewsAlertsDTOTest> newsAlertSelectedList);

	/**
	 * Metodo encargado de cambiar el estado de alertas y novedades a visto
	 * 
	 * @param List<NewsAlertsDTO> Identificador del objeto NewsAlerts
	 * @return boolean si pudo eliminar o no la(s) alerta(s)
	 **/
	boolean changeViewedState(List<NewsAlertsDTOTest> newsAlertSelectedList);

}