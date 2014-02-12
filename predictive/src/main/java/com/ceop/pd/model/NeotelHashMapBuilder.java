package com.ceop.pd.model;

import java.util.HashMap;
import java.util.StringTokenizer;

public class NeotelHashMapBuilder {

	public static NeotelString buildHashMapWithPipeDelimited(String text)  {
		
		NeotelString neotel = new NeotelString();
		
		String separatorStr = "\\|";

		HashMap<String, String> neotelHashMap = new HashMap<String, String>();
		StringTokenizer st = new StringTokenizer(text, separatorStr);
					
		while (st.hasMoreTokens()) {
			String thisToken = st.nextToken();
			StringTokenizer st2 = new StringTokenizer(thisToken, "=");
			if (thisToken.startsWith("SAL_CAMPA")) {
				
				@SuppressWarnings("unused")
				String unUsedKey = st2.nextToken(); //no usado para tomar el valor de Sal_campaña_default  
				String key = "SAL_CAMPA";
				String value = st2.nextToken();
				neotelHashMap.put(key, value != null ? value : "");
			}
			else {
				neotelHashMap.put(st2.nextToken(), st2.hasMoreTokens() ? st2.nextToken() : "");
			}
				
			
		}
		
	
		neotel.setSalCampaniaDefault(neotelHashMap.get("SAL_CAMPA"));
		neotel.setIdLlamada(neotelHashMap.get("IDLLAMADA"));
		neotel.setData(neotelHashMap.get("DATA"));
		neotel.setEstadoCrm(neotelHashMap.get("ESTADO_CRM"));
		neotel.setSubEstado(neotelHashMap.get("SUB_ESTADO"));
		neotel.setIdContacto(neotelHashMap.get("IDCONTACTO"));	
		return neotel;
	}	
}
