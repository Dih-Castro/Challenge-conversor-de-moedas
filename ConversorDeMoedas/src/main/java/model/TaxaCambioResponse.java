package com.seudesafio.conversor.model;

import java.util.Map;

public class TaxaCambioResponse {
    private String base_code;
    private String documentation;
    private String terms_of_use;
    private long time_last_update_unix;
    private String time_last_update_utc;
    private long time_next_update_unix;
    private String time_next_update_utc;
    private String base_code_for_query;
    private Map<String, Double> conversion_rates;

    public String getBase_code() {
        return base_code;
    }

    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public void setConversion_rates(Map<String, Double> conversion_rates) {
        this.conversion_rates = conversion_rates;
    }

    @Override
    public String toString() {
        return "TaxaCambioResponse{" +
                "base_code='" + base_code + '\'' +
                ", conversion_rates=" + conversion_rates +
                '}';
    }
}