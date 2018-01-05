package com.app.entity;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.app.entity.Purchas;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)


public class PurchaseWrapper {

	private Purchas[] purchas;
	
	@JsonProperty("purchases")
    public Purchas[] getPurchas ()
    {
        return purchas;
    }

    public void setPurchas (Purchas[] purchas)
    {
        this.purchas = purchas;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [purchases = " + purchas + "]";
    }
}