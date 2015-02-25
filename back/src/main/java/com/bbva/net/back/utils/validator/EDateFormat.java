package com.bbva.net.back.utils.validator;

import javax.swing.text.EditorKit;

/**
 * Created by Entelgy on 28/01/2015.
 */
public enum EDateFormat {

    ANIO_MES_DIA("yyyy-MM-dd"),
    DIA_MES_ANIO("dd/MM/yyyy"),
    MES_ANIO("MMyyyy"),
    MONTH("MM");

    private String pattern;

    private EDateFormat(String pattern){
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
