package com.ceop.pd.model;

import java.util.HashMap;
import java.util.StringTokenizer;

import junit.framework.Assert;

import org.junit.Test;

public class NeotelBuilderStringTest {

	@Test
	public void shouldGetValuesOfString() {

	
		
		final String str = "DEVICE=SIP/6000|IP=0.0.0.0|PORT=0|STATUS=|SERVER=NEO2|USUARIO=6000|SAL_CAMPAÑA_DEFAULT=123|SUBTIPO_DESCANSO=0|ESTADO_CRM=Available|TIEMPO_LOGIN=24/07/2012 12:23:46 p.m.|TIEMPO_LLAMADA=24/07/2012 12:33:09 p.m.|CHANNEL=|CAMPAÑA=0|CAMPAÑA_ULT=0|COLA=0|COLA_ULT=0|SUB_ESTADO=|SUB_ESTADO_ULT=|DNIS=|ANI=|TELEFONO=|ANI_TELEFONO_ULT=|TIPO_LLAMADA=NotSet|TIPO_LLAMADA_ULT=NotSet|ORIGEN_LLAMADA=|ORIGEN_LLAMADA_ULT=|DIRECCION=|DIRECCION_ULT=|CRM=0|BASE=0|IDCONTACTO=0|DATA=4321|CLAVE=|CAMPO_BUSQUEDA=|IDLLAMADA=1234|IDLLAMADA_ULT=0|CONFERENCIA=|GRABANDO=NO|GRABACION=|TELEFONO_DESVIO=|SAL_TIPO_DISCADOR=Manual|SAL_CRM=0|SAL_BASE=0|UNIQUEID_CANAL_ASOCIADO=|";
		final String separatorStr = "\\|";

		final HashMap<String, String> map = new HashMap<String, String>();
		final String str2 = str.substring(0, str.length() - 1); 
		final StringTokenizer st = new StringTokenizer(str2, separatorStr);
					
		while (st.hasMoreTokens()) {
			String thisToken = st.nextToken();
			StringTokenizer st2 = new StringTokenizer(thisToken, "=");
			map.put(st2.nextToken(), st2.hasMoreTokens() ? st2.nextToken() : "");
		}
		String salCampa = map.get("SAL_CAMPAÑA_DEFAULT");
		String idUsuario = map.get("IDLLAMADA");
		String data = map.get("DATA");
		
		Assert.assertEquals("123", salCampa );
		Assert.assertEquals("1234", idUsuario );
		Assert.assertEquals("4321", data );
		
	}
	
	@Test
	public void shouldGetValuesWithNeotelMapBuilder() {

		String str = "DEVICE=SIP/6000|IP=0.0.0.0|PORT=0|STATUS=|SERVER=NEO2|USUARIO=6000|SAL_CAMPAÑA_DEFAULT=123|SUBTIPO_DESCANSO=0|ESTADO_CRM=Available|TIEMPO_LOGIN=24/07/2012 12:23:46 p.m.|TIEMPO_LLAMADA=24/07/2012 12:33:09 p.m.|CHANNEL=|CAMPAÑA=0|CAMPAÑA_ULT=0|COLA=0|COLA_ULT=0|SUB_ESTADO=sub|SUB_ESTADO_ULT=|DNIS=|ANI=|TELEFONO=|ANI_TELEFONO_ULT=|TIPO_LLAMADA=NotSet|TIPO_LLAMADA_ULT=NotSet|ORIGEN_LLAMADA=|ORIGEN_LLAMADA_ULT=|DIRECCION=|DIRECCION_ULT=|CRM=0|BASE=0|IDCONTACTO=0|DATA=4321|CLAVE=|CAMPO_BUSQUEDA=|IDLLAMADA=1234|IDLLAMADA_ULT=0|CONFERENCIA=|GRABANDO=NO|GRABACION=|TELEFONO_DESVIO=|SAL_TIPO_DISCADOR=Manual|SAL_CRM=0|SAL_BASE=0|UNIQUEID_CANAL_ASOCIADO=|";
		
		NeotelString neotelMap = NeotelHashMapBuilder.buildHashMapWithPipeDelimited(str);
		
		Assert.assertEquals("123", neotelMap.getSalCampaniaDefault() );
		Assert.assertEquals("1234", neotelMap.getIdLlamada() );
		Assert.assertEquals("4321", neotelMap.getData() );
		Assert.assertEquals("Available", neotelMap.getEstadoCrm() );
		Assert.assertEquals("sub", neotelMap.getSubEstado());
		Assert.assertEquals("0", neotelMap.getIdContacto());
		
	}

}
