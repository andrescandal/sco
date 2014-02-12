package com.ceop.pd.model;
public class EnumTypeOfPause{

public enum tipoPausa {
CAFE(7), BAÑO(8), BANO(8), OTROS(9);

int idDescanso;

tipoPausa(int idDescanso) {
this.idDescanso = idDescanso;
}
public int getIdDescanso(String string) {
return this.idDescanso;
}
}


} 
