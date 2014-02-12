package com.ceop.pd.model;

public class NeotelString {
	
	private String salCampaniaDefault;
	private String subEstado;
	private String estadoCrm;
	private String idLlamada;
	private String idContacto;
	private String data;
	
	public NeotelString(String salCampaniaDefault, String subEstado,
			String estadoCrm, String idLlamada, String data, String idContacto) {
		this.salCampaniaDefault = salCampaniaDefault;
		this.subEstado = subEstado;
		this.estadoCrm = estadoCrm;
		this.idLlamada = idLlamada;
		this.idContacto = idContacto;
		this.data = data;
	}
	
	

	public NeotelString() {	}


	public String getSalCampaniaDefault() {
		return salCampaniaDefault;
	}

	public void setSalCampaniaDefault(String salCampaniaDefault) {
		this.salCampaniaDefault = salCampaniaDefault;
	}

	public String getSubEstado() {
		return subEstado;
	}

	public void setSubEstado(String subEstado) {
		this.subEstado = subEstado;
	}

	public String getEstadoCrm() {
		return estadoCrm;
	}

	public void setEstadoCrm(String estadoCrm) {
		this.estadoCrm = estadoCrm;
	}



	public String getIdLlamada() {
		return idLlamada;
	}



	public void setIdLlamada(String idLlamada) {
		this.idLlamada = idLlamada;
	}



	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}



	public String getIdContacto() {
		return idContacto;
	}



	public void setIdContacto(String idContacto) {
		this.idContacto = idContacto;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Campania = "+ salCampaniaDefault +"|").append(" SubEstado = "+ subEstado +"|").append(" EstadoCRM = "+ estadoCrm +"|").append(" IdLlamada = "+ idLlamada +"|").append(" IdContacto = "+ idContacto +"|").append(" Data = "+ data +"|");
		return sb.toString();
	}

}
