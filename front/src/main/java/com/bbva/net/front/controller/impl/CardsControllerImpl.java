package com.bbva.net.front.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.view.ViewScoped;

import org.apache.cxf.jaxrs.ext.search.client.SearchConditionBuilder;
import org.primefaces.event.SelectEvent;

import com.bbva.net.back.facade.CardsFacade;
import com.bbva.net.back.facade.FundsTypeFacade;
import com.bbva.net.back.facade.GlobalPositionFacade;
import com.bbva.net.back.model.globalposition.BalanceDto;
import com.bbva.net.back.model.globalposition.FundDto;
import com.bbva.net.back.model.globalposition.GlobalProductsDto;
import com.bbva.net.back.model.movements.GlobalResumeMovementsDto;
import com.bbva.net.back.facade.AccountMovementsResumeFacade;
import com.bbva.net.front.controller.CardsController;
import com.bbva.net.front.controller.GlobalPositionController;
import com.bbva.net.front.core.AbstractBbvaController;
import com.bbva.net.front.delegate.GraphicBarLineDelegate;
import com.bbva.net.front.delegate.GraphicPieDelegate;
import com.bbva.net.front.helper.MessagesHelper;
import com.bbva.net.front.ui.globalposition.AccountBarLineUI;
import com.bbva.net.front.ui.globalposition.SituationPiesUI;
import com.bbva.net.front.ui.pie.PieConfigUI;

@ManagedBean
@ViewScoped
public class CardsControllerImpl extends AbstractBbvaController implements CardsController {


}
