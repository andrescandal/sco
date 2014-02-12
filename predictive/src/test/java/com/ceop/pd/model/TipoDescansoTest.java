package com.ceop.pd.model;

import junit.framework.Assert;

import org.junit.Test;

import com.ceop.pd.model.EnumTypeOfPause.tipoPausa;

public class TipoDescansoTest {

	@Test
	public void tiposDeDescansoTest() {
		try{
			
		String tipoDescanso = "Cafe";
		tipoPausa descanso = tipoPausa.valueOf(tipoDescanso.toUpperCase());
		Assert.assertEquals("7", String.valueOf(descanso.getIdDescanso(tipoDescanso)));
		}
		catch (Exception e) {
           System.out.println(e);		}

	}
}