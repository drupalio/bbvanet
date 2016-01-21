package com.bbva.net.front.core;

import java.util.ArrayList;
import java.util.List;

import org.fluttercode.datafactory.impl.DataFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bbva.net.back.facade.impl.CheckBookFacadeImpl;
import com.bbva.net.back.facade.impl.QuotaDetailFacadeImpl;
import com.bbva.net.front.test.utils.AbstractBbvaControllerTest;

public class PaginationControllerTest extends AbstractBbvaControllerTest {

    private PaginationController<Long> paginatedController;

    private DataFactory dataFactory;

    @Before
    public void init() {

        super.setUp();

        this.dataFactory = new DataFactory();

        this.paginatedController = new PaginationController<Long>() {

            private static final long serialVersionUID = 812884175518015059L;

            @Override
            protected Integer getNextPaginantionKey(List<Long> lastPage, Integer paginationKey) {
                return Integer.valueOf(Integer.MIN_VALUE);
            }

            @Override
            protected List<Long> getNextPage(int paginantionKey, int psize) {

                final List<Long> currentList = new ArrayList<Long>();
                currentList.add(Long.valueOf(dataFactory.getNumberUpTo(100)));
                currentList.add(Long.valueOf(dataFactory.getNumberUpTo(100)));
                currentList.add(Long.valueOf(dataFactory.getNumberUpTo(100)));
                currentList.add(Long.valueOf(dataFactory.getNumberUpTo(100)));
                currentList.add(Long.valueOf(dataFactory.getNumberUpTo(100)));
                currentList.add(Long.valueOf(dataFactory.getNumberUpTo(100)));
                currentList.add(Long.valueOf(dataFactory.getNumberUpTo(100)));
                currentList.add(Long.valueOf(dataFactory.getNumberUpTo(100)));
                currentList.add(Long.valueOf(dataFactory.getNumberUpTo(100)));
                currentList.add(Long.valueOf(dataFactory.getNumberUpTo(100)));

                return currentList;
            }
        };
    }

    @Test
    public void checkInitController() {

        this.paginatedController.init();
        Assert.assertNotNull(this.paginatedController.getCurrentList());
    }

    @Test
    public void checkSetCurrentList() {

        final List<Long> currentList = new ArrayList<Long>();
        currentList.add(Long.valueOf(dataFactory.getNumberUpTo(100)));
        currentList.add(Long.valueOf(dataFactory.getNumberUpTo(100)));
        currentList.add(Long.valueOf(dataFactory.getNumberUpTo(100)));

        this.paginatedController.setCurrentList(currentList);
        Assert.assertNotNull(this.paginatedController.getCurrentList());
        Assert.assertEquals(this.paginatedController.getCurrentList().size(), 3);
    }

    @Test
    public void checkGettersMethods() {

        this.paginatedController.setPaginationKey(Integer.valueOf("1"));
        Assert.assertNotNull(this.paginatedController.getPaginationKey());
        this.paginatedController.setPaginationKey(null);
        Assert.assertNull(this.paginatedController.getPaginationKey());
    }

    @Test
    public void checkHasMoreElementsDefault() {

        Assert.assertTrue(this.paginatedController.isHasMorePages());

    }

    @Test
    public void checkWithMoreElements() {

        this.paginatedController.init();

        this.paginatedController.setPaginationKey(Integer.valueOf("1"));
        this.paginatedController.next();
        Assert.assertTrue(this.paginatedController.isHasMorePages());
    }

    @Test
    public void checkNOMoreElements() {

        this.paginatedController.init();
        this.paginatedController.setPaginationKey(Integer.valueOf("1"));
        PaginationController.PAGE_SIZE = 11;
        this.paginatedController.next();
        Assert.assertFalse(this.paginatedController.isHasMorePages());
    }

    @Test
    public void checkSetQuotaDetailFacade() {
        this.paginatedController.setQuotaDetailFacade(new QuotaDetailFacadeImpl());
    }

    @Test
    public void checksetCheckBookFacade() {
        this.paginatedController.setCheckBookFacade(new CheckBookFacadeImpl());
    }
}
