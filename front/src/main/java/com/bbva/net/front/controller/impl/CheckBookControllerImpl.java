/**
 * 
 */
package com.bbva.net.front.controller.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.event.ActionEvent;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bbva.net.back.entity.MultiValueGroup;
import com.bbva.net.back.facade.CheckBookFacade;
import com.bbva.net.back.facade.MultiValueGroupFacade;
import com.bbva.net.back.model.checkbook.CheckDto;
import com.bbva.net.back.model.checkbook.CheckbookDto;
import com.bbva.net.back.model.comboFilter.EnumCheckStatus;
import com.bbva.net.back.model.comboFilter.EnumPeriodType;
import com.bbva.net.back.model.commons.DateRangeDto;
import com.bbva.net.back.model.enums.RenderAttributes;
import com.bbva.net.back.service.impl.DateFilterServiceImpl;
import com.bbva.net.front.controller.CheckBookController;
import com.bbva.net.front.core.AbstractBbvaController;
import com.bbva.net.front.helper.MessagesHelper;

/**
 * @author User
 */

@Controller(value = "checkBookController")
@Scope(value = "globalSession")
public class CheckBookControllerImpl extends AbstractBbvaController implements CheckBookController {

	private static final long serialVersionUID = 1L;

	private static final String SEARCH_CHECK = MessagesHelper.INSTANCE.getString("text.search.by.numberbook");

	private static final String CONCRETE_DATE = MessagesHelper.INSTANCE.getString("select.radio.concret.date");

	private static final Integer LIST_CHECK_STATUS = 2;

	private String selectDate;

	private Date sinceDate;

	private Date toDate;

	private String actionState;

	private String checkState;

	private String checkBookNumber;
	
	private String sinceDatestr;

	private String toDatestr;
	
	private String title =  MessagesHelper.INSTANCE.getString("text.last.movments");

	private Map<String, Boolean> renderComponents = new HashMap<String, Boolean>();

	private List<MultiValueGroup> multiValueList = new ArrayList<MultiValueGroup>();
	
	private List<CheckbookDto> checkBookList = new ArrayList<CheckbookDto>();
	
	private List<CheckDto> checkList = new ArrayList<CheckDto>();

	private CheckDto check = new CheckDto();

	private DateRangeDto dateRange = new DateRangeDto();	

	@Resource(name = "checkBookFacade")
	private transient CheckBookFacade checkBookFacade;

	@Resource(name = "multiValueGroupFacade")
	private transient MultiValueGroupFacade multiValueGroupFacade;
	
	SimpleDateFormat dateFormat = new SimpleDateFormat( MessagesHelper.INSTANCE.getStringI18("date.pattner.dd.mm.yyyy"));

	@PostConstruct
	public void init() {
		this.multiValueList = this.getListMultiValueChecks();
		renderComponents.put(RenderAttributes.MOVEMENTSTABLE.toString(), true);
		renderComponents.put(RenderAttributes.CHECKTABLE.toString(), false);
		clean();
	}

	@Override
	public void clean() {
		
		renderComponents.put(RenderAttributes.CALENDAR.toString(), true);
		renderComponents.put(RenderAttributes.BUTTONDATE.toString(), true);

		renderComponents.put(RenderAttributes.NUMBERBOOK.toString(), true);
		renderComponents.put(RenderAttributes.NUMBERCHECK.toString(), true);
		renderComponents.put(RenderAttributes.BUTTONBOOK.toString(), true);
		
		renderComponents.put(RenderAttributes.FILTERNUMBERCHECK.toString(), false);
		renderComponents.put(RenderAttributes.FILTERCHECKBOOK.toString(), false);
		renderComponents.put(RenderAttributes.FILTERDATE.toString(), false);		
		
	}
	

	@Override
	public void oneSelectDate() {
		System.out.println("Method oneSelectDate");
		
		renderComponents.put(RenderAttributes.FILTERDATE.toString(), true);
		
		if (getSelectDate().equals(CONCRETE_DATE)) {
			renderComponents.put(RenderAttributes.CALENDAR.toString(), false);
			renderComponents.put(RenderAttributes.BUTTONDATE.toString(), false);
	
		} else {
			renderComponents.put(RenderAttributes.CALENDAR.toString(), true);
			renderComponents.put(RenderAttributes.BUTTONDATE.toString(), false);
		
		}
	}

	@Override
	public void setCustomDate(final ActionEvent event) {
		System.out.println("setCustomDate");

		this.dateRange.setDateSince(getSinceDate());
		this.dateRange.setDateTo(getToDate());
		if (! (getSinceDate()==(null)) && ! (getToDate()==(null))) {
			sinceDatestr = "Desde: "+dateFormat.format(getSinceDate());
			toDatestr = "Hasta: "+dateFormat.format(getToDate());
		}else{
			sinceDatestr =getSelectDate();
		}		
		System.out.println(getSelectDate());
		System.out.println(sinceDatestr);
		System.out.println(toDatestr);		 
	}

	@Override
	public void actionState() {
		System.out.println("method Action State");
		if (getActionState().equals(SEARCH_CHECK)) {
			
			renderComponents.put(RenderAttributes.FILTERNUMBERCHECK.toString(), true);
			renderComponents.put(RenderAttributes.NUMBERCHECK.toString(), true);
			renderComponents.put(RenderAttributes.NUMBERBOOK.toString(), false);
			renderComponents.put(RenderAttributes.BUTTONBOOK.toString(), false);

		} else {
						
			renderComponents.put(RenderAttributes.FILTERCHECKBOOK.toString(), true);
			renderComponents.put(RenderAttributes.NUMBERBOOK.toString(), true);
			renderComponents.put(RenderAttributes.NUMBERCHECK.toString(), false);
			renderComponents.put(RenderAttributes.BUTTONBOOK.toString(), false);
		}
	}
	
	@Override
	public void showResults(final ActionEvent event){
		System.out.println("showResults");					
		
		if( renderComponents.get(RenderAttributes.FILTERCHECKBOOK.toString()) ){
			System.out.println("cheques");			
			//ToDo servicio que consulta cheques.			
			System.out.println("check num: " + check.getId() + " check State: " +  EnumCheckStatus.valueOf(Integer.parseInt(getCheckState())) );
			// this.checkList = checkBookFacade.getCheck(check.getId(), EnumCheckStatus.valueOf(Integer.parseInt(getCheckState())) );
			setTitle( new String(MessagesHelper.INSTANCE.getString("tex.check.status")) );
			renderComponents.put(RenderAttributes.MOVEMENTSTABLE.toString(), false);
			System.out.println(renderComponents.containsValue(RenderAttributes.MOVEMENTSTABLE.toString()));
			renderComponents.put(RenderAttributes.CHECKTABLE.toString(), true);
			clean();
		}else if(renderComponents.get(RenderAttributes.FILTERNUMBERCHECK.toString()) ){			
			System.out.println("talonarios");
			System.out.println("checkbook num: " + getCheckBookNumber());
			//ToDo servicio que consulta talonarios.
			//this.checkBookList = checkBookFacade.getCheckbookDto(getCheckBookNumber());
			setTitle( MessagesHelper.INSTANCE.getString("tex.check.status") );
			renderComponents.put(RenderAttributes.MOVEMENTSTABLE.toString(), false);
			renderComponents.put(RenderAttributes.CHECKTABLE.toString(), true);
			clean();
		}else if( renderComponents.get( RenderAttributes.FILTERDATE.toString() ) ){
			//ToDo servicio que consulta cheques por fecha
			EnumPeriodType periodType = EnumPeriodType.valueOfLabel( this.getSelectDate() );
			System.out.println("periodType "+periodType);
			dateRange =  new DateFilterServiceImpl().getPeriodFilter(periodType);
			System.out.println(dateRange.getDateSince() + "  to "+dateRange.getDateTo());
			setTitle( MessagesHelper.INSTANCE.getString("tex.check.status") );
			renderComponents.put(RenderAttributes.MOVEMENTSTABLE.toString(), false);
			renderComponents.put(RenderAttributes.CHECKTABLE.toString(), true);
			clean();
		}else{
			System.out.println("sin filtros");
		}
	}

	@Override
	public List<MultiValueGroup> getListMultiValueChecks() {
		return this.multiValueGroupFacade.getMultiValueTypes(LIST_CHECK_STATUS);
	}

	@Override
	public void setNumberCheckOrBook(final ActionEvent event) {
		System.out.println("setNumberCheckOrBook");
		EnumCheckStatus.valueOf(Integer.parseInt(getCheckState()));
		System.out.println(check.getId() + " C.E " + EnumCheckStatus.valueOf(Integer.parseInt(getCheckState())) + "  "
				+ getCheckBookNumber());
	}

	/**
	 * @return the selectDate
	 */
	public String getSelectDate() {
		return selectDate;
	}

	/**
	 * @param selectDate the selectDate to set
	 */
	public void setSelectDate(String selectDate) {
		this.selectDate = selectDate;
	}

	/**
	 * @return the sinceDate
	 */
	public Date getSinceDate() {
		return sinceDate;
	}

	/**
	 * @param sinceDate the sinceDate to set
	 */
	public void setSinceDate(Date sinceDate) {
		this.sinceDate = sinceDate;
	}

	/**
	 * @return the toDate
	 */
	public Date getToDate() {
		return toDate;
	}

	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	/**
	 * @return the actionState
	 */
	public String getActionState() {
		return actionState;
	}

	/**
	 * @param actionState the actionState to set
	 */
	public void setActionState(String actionState) {
		this.actionState = actionState;
	}

	/**
	 * @return the checkState
	 */
	public String getCheckState() {
		return checkState;
	}

	/**
	 * @param checkState the checkState to set
	 */
	public void setCheckState(String checkState) {
		this.checkState = checkState;
	}

	/**
	 * @return the checkBookNumber
	 */
	public String getCheckBookNumber() {
		return checkBookNumber;
	}

	/**
	 * @param checkBookNumber the checkBookNumber to set
	 */
	public void setCheckBookNumber(String checkBookNumber) {
		this.checkBookNumber = checkBookNumber;
	}

	
	
	/**
	 * @return the sinceDatestr
	 */
	public String getSinceDatestr() {
		return sinceDatestr;
	}

	
	/**
	 * @param sinceDatestr the sinceDatestr to set
	 */
	public void setSinceDatestr(String sinceDatestr) {
		this.sinceDatestr = sinceDatestr;
	}

	
	/**
	 * @return the toDatestr
	 */
	public String getToDatestr() {
		return toDatestr;
	}

	
	/**
	 * @param toDatestr the toDatestr to set
	 */
	public void setToDatestr(String toDatestr) {
		this.toDatestr = toDatestr;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the renderComponents
	 */
	public Map<String, Boolean> getRenderComponents() {
		return renderComponents;
	}

	/**
	 * @param renderComponents the renderComponents to set
	 */
	public void setRenderComponents(Map<String, Boolean> renderComponents) {
		this.renderComponents = renderComponents;
	}

	/**
	 * @return the multiValueList
	 */
	public List<MultiValueGroup> getMultiValueList() {
		return multiValueList;
	}

	/**
	 * @param multiValueList the multiValueList to set
	 */
	public void setMultiValueList(List<MultiValueGroup> multiValueList) {
		this.multiValueList = multiValueList;
	}

	
	/**
	 * @return the checkBookList
	 */
	public List<CheckbookDto> getCheckBookList() {
		return checkBookList;
	}

	
	/**
	 * @param checkBookList the checkBookList to set
	 */
	public void setCheckBookList(List<CheckbookDto> checkBookList) {
		this.checkBookList = checkBookList;
	}

	
	/**
	 * @return the checkList
	 */
	public List<CheckDto> getCheckList() {
		return checkList;
	}

	
	/**
	 * @param checkList the checkList to set
	 */
	public void setCheckList(List<CheckDto> checkList) {
		this.checkList = checkList;
	}

	/**
	 * @return the check
	 */
	public CheckDto getCheck() {
		return check;
	}

	/**
	 * @param check the check to set
	 */
	public void setCheck(CheckDto check) {
		this.check = check;
	}

	/**
	 * @return the dateRange
	 */
	public DateRangeDto getDateRange() {
		return dateRange;
	}

	/**
	 * @param dateRange the dateRange to set
	 */
	public void setDateRange(DateRangeDto dateRange) {
		this.dateRange = dateRange;
	}

	/**
	 * @return the checkBookFacade
	 */
	public CheckBookFacade getCheckBookFacade() {
		return checkBookFacade;
	}

	/**
	 * @param checkBookFacade the checkBookFacade to set
	 */
	public void setCheckBookFacade(CheckBookFacade checkBookFacade) {
		this.checkBookFacade = checkBookFacade;
	}

	/**
	 * @return the multiValueGroupFacade
	 */
	public MultiValueGroupFacade getMultiValueGroupFacade() {
		return multiValueGroupFacade;
	}

	/**
	 * @param multiValueGroupFacade the multiValueGroupFacade to set
	 */
	public void setMultiValueGroupFacade(MultiValueGroupFacade multiValueGroupFacade) {
		this.multiValueGroupFacade = multiValueGroupFacade;
	}
}