package com.bbva.net.back.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bbva.net.back.core.pattern.dao.AbstractBbvaDao;
import com.bbva.net.back.dao.MultiValueGroupDAO;
import com.bbva.net.back.entity.MultiValueGroup;

/**
 * @author User
 */
@Repository(value = "multiValueGroupDao")
public class MultiValueGroupDAOImpl extends AbstractBbvaDao<MultiValueGroup> implements MultiValueGroupDAO {

	private static final String TYPE_ID = "typeId";

	@Override
	@SuppressWarnings("unchecked")
	public List<MultiValueGroup> getTypes(final Integer typeId) {

		MultiValueGroup aux;

		ArrayList<MultiValueGroup> listAux = new ArrayList<MultiValueGroup>();
		if (typeId == null) {

			return new ArrayList<MultiValueGroup>();
		}

		if (typeId == 3) {
			aux = new MultiValueGroup();
			aux.setId((long)286);
			aux.setTypeId(230);
			aux.setValue("text.combo.period.lastsix");
			listAux.add(aux);
			aux = new MultiValueGroup();
			aux.setId((long)295);
			aux.setTypeId(230);
			aux.setValue("text.combo.period.lastthree");
			listAux.add(aux);
			aux = new MultiValueGroup();
			aux.setId((long)301);
			aux.setTypeId(230);
			aux.setValue("text.combo.period.lastmonth");
			listAux.add(aux);
		} else if (typeId == 2) {
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(2);
			aux.setValue("text.combo.cheks.available");
			aux.setValueId(0);
			listAux.add(aux);
			aux = new MultiValueGroup();
			aux.setId((long)461);
			aux.setTypeId(2);
			aux.setValue("text.combo.cheks.canceled");
			aux.setValueId(1);
			listAux.add(aux);
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(2);
			aux.setValue("text.combo.cheks.lost");
			aux.setValueId(2);
			listAux.add(aux);
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(2);
			aux.setValue("text.combo.cheks.paid.by.redemption");
			aux.setValueId(3);
			listAux.add(aux);
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(2);
			aux.setValue("text.combo.cheks.paid.by.window");
			aux.setValueId(4);
			listAux.add(aux);
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(2);
			aux.setValue("text.combo.cheks.stop.payment");
			aux.setValueId(8);
			listAux.add(aux);
		} else if (typeId == 6) {
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(407);
			aux.setValue("quiero.viewBalancesMovements");
			aux.setValueId(458);
			listAux.add(aux);
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(407);
			aux.setValue("quiero.tranfers");
			aux.setValueId(458);
			listAux.add(aux);
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(407);
			aux.setValue("quiero.manageTransfers");
			aux.setValueId(458);
			listAux.add(aux);
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(407);
			aux.setValue("quiero.seeMoreOptions");
			aux.setValueId(458);
			listAux.add(aux);
		} else if (typeId == 7) {
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(407);
			aux.setValue("quiero.viewMovements");
			aux.setValueId(458);
			listAux.add(aux);
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(407);
			aux.setValue("quiero.blockCard");
			aux.setValueId(458);
			listAux.add(aux);
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(407);
			aux.setValue("quiero.payPurchases");
			aux.setValueId(458);
			listAux.add(aux);
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(407);
			aux.setValue("quiero.seeMoreOptions");
			aux.setValueId(458);
			listAux.add(aux);
		} else if (typeId == 8) {
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(407);
			aux.setValue("quiero.viewMovements");
			aux.setValueId(458);
			listAux.add(aux);
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(407);
			aux.setValue("quiero.makingMinimumPayments");
			aux.setValueId(458);
			listAux.add(aux);
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(407);
			aux.setValue("quiero.seeMoreOptions");
			aux.setValueId(458);
			listAux.add(aux);
		} else if (typeId == 12) {
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(407);
			aux.setValue("quiero.seeMoreOptions");
			aux.setValueId(458);
			listAux.add(aux);
		} else if (typeId == 9) {
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(407);
			aux.setValue("quiero.viewMovements");
			aux.setValueId(458);
			listAux.add(aux);
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(407);
			aux.setValue("quiero.payLoan");
			aux.setValueId(458);
			listAux.add(aux);
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(407);
			aux.setValue("quiero.householdLoans");
			aux.setValueId(458);
			listAux.add(aux);
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(407);
			aux.setValue("quiero.seeMoreOptions");
			aux.setValueId(458);
			listAux.add(aux);
		} else if (typeId == 10) {
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(407);
			aux.setValue("quiero.viewMovements");
			aux.setValueId(458);
			listAux.add(aux);
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(407);
			aux.setValue("quiero.renewMyDeposits");
			aux.setValueId(458);
			listAux.add(aux);
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(407);
			aux.setValue("quiero.rescueMyDeposits");
			aux.setValueId(458);
			listAux.add(aux);
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(407);
			aux.setValue("quiero.seeMoreOptions");
			aux.setValueId(458);
			listAux.add(aux);
		} else if (typeId == 11) {
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(407);
			aux.setValue("quiero.viewBalancesMovements");
			aux.setValueId(458);
			listAux.add(aux);
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(407);
			aux.setValue("quiero.investingFund");
			aux.setValueId(458);
			listAux.add(aux);
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(407);
			aux.setValue("quiero.rescue");
			aux.setValueId(458);
			listAux.add(aux);
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(407);
			aux.setValue("quiero.reinvestAnotherFund");
			aux.setValueId(458);
			listAux.add(aux);
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(407);
			aux.setValue("quiero.seeMoreOptions");
			aux.setValueId(458);
			listAux.add(aux);
		} else if (typeId == 13) {
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(407);
			aux.setValue("mov.OK");
			aux.setValueId(458);
			listAux.add(aux);
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(407);
			aux.setValue("mov.NK");
			aux.setValueId(458);
			listAux.add(aux);
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(407);
			aux.setValue("mov.NP");
			aux.setValueId(458);
			listAux.add(aux);
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(407);
			aux.setValue("mov.TA");
			aux.setValueId(458);
			listAux.add(aux);
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(407);
			aux.setValue("mov.PF");
			aux.setValueId(458);
			listAux.add(aux);
		} else if (typeId == 14) {
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(407);
			aux.setValue("mov.inactive");
			aux.setValueId(458);
			listAux.add(aux);
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(407);
			aux.setValue("mov.active");
			aux.setValueId(458);
			listAux.add(aux);
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(407);
			aux.setValue("mov.suspend");
			aux.setValueId(458);
			listAux.add(aux);
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(407);
			aux.setValue("mov.cancel");
			aux.setValueId(458);
			listAux.add(aux);
		} else if (typeId == 15) {
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(407);
			aux.setValue("mov.confirm");
			aux.setValueId(458);
			listAux.add(aux);
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(407);
			aux.setValue("mov.returned");
			aux.setValueId(458);
			listAux.add(aux);
			aux = new MultiValueGroup();
			aux.setId((long)456);
			aux.setTypeId(407);
			aux.setValue("mov.pending");
			aux.setValueId(458);
			listAux.add(aux);
		} else {

			return new ArrayList<MultiValueGroup>();

		}
		return listAux;

	}

}
