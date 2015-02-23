package com.bbva.net.back.utils.validator;

/**
 * Listado de errores comunes en servicios.
 *
 * @author Adesis
 *
 */
public enum EnumError {

    /**
     * Lanzado cuando se ha realizado una solicitud en la que hay parámetros obligatorios en la entrada y no se han especificado.
     */
    MANDATORY_PARAMETERES_MISSING("mandatoryParametersMissing"),
    /**
     * Lanzado cuando se realiza una solicitud con el parámetro especial "expands" y el elemento que queremos expandir no es una subentidad
     * de la entidad reflejada en la uri.
     */
    EXPAND_ERROR("expandError"),
    /**
     * Lanzado cuando se realiza una solicitud con el parámetro especial "expands" y no se le asigna un valor.
     */
    EXPAND_EMPTY("expandEmpty"),
    /**
     * Lanzado cuando se solicita un listado de valores inexistente para la entidad que se está tratando.
     */
    LISTING_NOT_FOUND("listingNotFound"),
    /**
     * Lanzado cuando se realiza una solicitud con el parámetro especial "filter" y el elemento por el que queremos filtrar no existe.
     */
    INEXISTENT_FILTER("inexistentFilter"),
    /**
     * Lanzado cuando se realiza una solicitud con el parámetro especial "filter" y no se le asigna un valor.
     */
    FILTER_EMPTY("filterEmpty"),
    /**
     * Lanzado cuando, debido a restricciones en la entrada del servicio, haya parámetros no obligatorios, que se convierten en obligatorios
     * en consecuencia del valor de otros campos.
     */
    PARAMETER_MISSING("parametersMissing"),
    /**
     * Lanzado cuando se especifican valores de filtrado que no tienen sentido de manera combinada.
     */
    EXCLUSIVE_FILTER("exclusiveFilter"),
    /**
     * Lanzado cuando se especifican parámetros cuyos valores son incorrectos en referencia a su sintaxis, tipo de dato, etc.
     */
    WRONG_PARAMETERS("wrongParameters"),
    /**
     * Lanzado cuando en el campo de paginación que indica cuántos registros se solicitan, se indica un número mayor que el que la
     * transacción es capaz de dar.
     */
    PAGE_SIZE_TOO_BIG("pageSizeTooBig"),
    /**
     * Lanzado cuando para una búsqueda no se encuentra ningún elemento.
     */
    NO_DATA("noData"),
    /**
     * Lanzado cuando se intenta obtener el detalle de una entidad que no existe.
     */
    INEXISTENT_ENTITY("inexistentEntity"),
    /**
     * Lanzado cuando se intenta filtrar por un rango de fechas demasiado extenso.
     */
    DATE_INTERVAL_OUT_OF_RANGE("dateIntervalOutOfRange"),
    /**
     * Lanzado cuando en el servicio se considera que se ha producido un error técnico.
     */
    TECHNICAL_ERROR("technicalError"),
    /**
     * Lanzado cuando al intentar crear una entidad, algún campo identificativo "choca" con otro ya existente.
     */
    ENTITY_EXISTS("entityExists"),
    /**
     * Lanzado cuando se ha realizado una solicitud en la que hay parámetros obligatorios en la entrada y no se han especificado.
     */
    MANDATORY_PARAMETERS_MISSING_EXPLICIT("mandatoryParametersMissingExplicit"),
    /**
     * Lanzado cuando se especifican valores de filtrado que no tienen sentido de manera combinada.
     */
    EXCLUSIVE_FILTER_EXPLICIT("exclusiveFilterExplicit"),
    /**
     * Lanzado cuando se especifican parámetros cuyos valores son incorrectos en referencia a su sintaxis, tipo de dato, etc.
     */
    WRONG_PARAMETERS_EXPLICIT("wrongParametersExplicit"),
    /**
     * Lanzado cuando en el campo de paginación que indica cuántos registros se solicitan, se indica un número mayor que el que la
     * transacción es capaz de dar.
     */
    PAGE_SIZE_TOO_BIG_EXPLICIT("pageSizeTooBigExplicit"),
    /**
     * Lanzado cuando el valor del campo {1} obliga a una tipología de valores del campo {0} que no se cumple.
     */
    RELATED_PARAMETERS("relatedParameters");

    private String alias;

    EnumError(final String alias) {
        this.alias = alias;
    }

    public String getAlias() {
        return this.alias;
    }

    /**
     * Obtiene el enum a partir del alias del error.
     *
     * @param alias
     *            Alias del error.
     * @return
     */
    public static EnumError fromAlias(final String alias) {
        for (final EnumError error : values()) {
            if (error.alias.equals(alias)) {
                return error;
            }
        }
        return null;
    }

}
