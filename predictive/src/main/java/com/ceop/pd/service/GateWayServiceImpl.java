package com.ceop.pd.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.tempuri.WebServiceSoap;

import com.ceop.pd.model.EnumTypeOfPause.tipoPausa;
import com.ceop.pd.model.NeotelHashMapBuilder;
import com.ceop.pd.model.NeotelString;
import com.ceop.pd.model.RequestResponse;
import com.ceop.pd.rs.GateWayService;

public class GateWayServiceImpl implements GateWayService {

    @Autowired
    WebServiceSoap neotelService;

    private final Logger logger = LoggerFactory.getLogger(GateWayServiceImpl.class);

    @Override
    public RequestResponse loginCampaignWithNeotelUser(int campaign, String neotelUser) {

        RequestResponse requestResponse = new RequestResponse();

        try {
            logger.info("Login del usuario: " + neotelUser + " en la campaña: " + campaign);
            neotelService.loginCampaign(neotelUser, campaign);

            String position = neotelService.position(neotelUser);
            NeotelString neotel = NeotelHashMapBuilder.buildHashMapWithPipeDelimited(position);

            logger.debug(position);
            logger.debug(neotel.toString());

            String num = String.valueOf(campaign);

            if (neotel.getSalCampaniaDefault().equals(num)) {

                requestResponse.setStatus("OK");
                requestResponse.setCode("00");
                requestResponse.setDescription("User Loged correctly");

                logger.info("El usuario: " + neotelUser + " se ha logueado correctamente en la campaña: " + campaign);

                return requestResponse;

            } else {

                requestResponse.setStatus("ERROR");
                requestResponse.setCode("01");
                requestResponse.setDescription("Incorrect Campaign");

                logger.error("El usuario: " + neotelUser + "no se pudo loguear correctamente en la campaña: " + campaign);

                return requestResponse;
            }
            
        } catch (Exception errorNeotel) {

            requestResponse.setStatus("ERROR");
            requestResponse.setCode("02");

            String message = errorNeotel.getMessage();
            String cause = "";
            if (errorNeotel.getCause() != null) {
                cause = ": " + errorNeotel.getCause().getMessage();
            }

            requestResponse.setDescription(message + cause);

            logger.error("Se produjo el siguiente error: " + errorNeotel.getMessage() + "usuario: " + neotelUser + "Campaña: " + campaign);

            return requestResponse;
        }

    }

    @Override
    public RequestResponse answerCall(String neotelUser) {

        RequestResponse response = new RequestResponse();

        try {
            String position = neotelService.position(neotelUser);
            NeotelString neotel = NeotelHashMapBuilder.buildHashMapWithPipeDelimited(position);
            logger.debug(position);
            logger.debug(neotel.toString());
            if (neotel.getSubEstado().equals("AGENT")) {
                int num = Integer.parseInt(neotel.getIdContacto());
                neotelService.crmMostrandoContacto(neotelUser, num, neotel.getData());
                response.setStatus("OK");
                response.setCode("00");
                response.setDescription(neotel.getData());
                logger.debug("OK: El usuario: " + neotelUser + " esta en comunicacion con el siguiente contacto: " + neotel.getIdContacto());
                return response;

            } else {
                response.setStatus("ERROR");
                response.setCode("01");
                response.setDescription("EL SUB_ESTADO NO SE ENCUENTRA EN AGENT");
                logger.debug("ERROR: El Sub_Estado no se encuentra en AGENT  ");
                return response;
            }
        } catch (Exception errorNeotel) {
            response.setStatus("ERROR");
            response.setCode("02");
            String message = errorNeotel.getMessage();
            String cause = "";
            if (errorNeotel.getCause() != null) {
                cause = ": " + errorNeotel.getCause().getMessage();
            }
            response.setDescription(message + cause);
            logger.error("Se produjo el siguiente error: " + errorNeotel.getMessage() + "usuario: " + neotelUser);

            return response;
        }
    }

    @Override
    public RequestResponse acceptCall(String neotelUser) {

        RequestResponse response = new RequestResponse();

        try {
            logger.info("Seteando al usuario: " + neotelUser + " para recibir llamados");
            neotelService.crmAvailable(neotelUser);
            neotelService.unpause(neotelUser);
            String position = neotelService.position(neotelUser);
            NeotelString neotel = NeotelHashMapBuilder.buildHashMapWithPipeDelimited(position);

            logger.debug(position);
            logger.debug(neotel.toString());

            if (neotel.getEstadoCrm().equalsIgnoreCase("Available")) {

                response.setStatus("OK");
                response.setCode("00");
                response.setDescription("Usuario a la espera de llamadas");
                logger.info("Usuario a la espera de llamadas");

                return response;

            } else {

                response.setStatus("ERROR");
                response.setCode("01");
                response.setDescription("Usuario no disponible");
                logger.error("usuario no disponible");

                return response;
            }
        } catch (Exception errorNeotel) {

            response.setStatus("ERROR");
            response.setCode("02");

            String message = errorNeotel.getMessage();
            String cause = "";
            if (errorNeotel.getCause() != null) {
                cause = ": " + errorNeotel.getCause().getMessage();
            }

            response.setDescription(message + cause);

            logger.error("Se produjo el siguiente error: " + errorNeotel.getMessage() + "usuario: " + neotelUser);

            return response;
        }
    }

    @Override
    public RequestResponse logoutCampaign(String neotelUser) {

        RequestResponse response = new RequestResponse();

        try {
            logger.info("Deslogueando al usuario: " + neotelUser);
            neotelService.logoutCampaign(neotelUser);
            neotelService.crmNoDisponible(neotelUser);
            neotelService.unpause(neotelUser);
            String position = neotelService.position(neotelUser);
            NeotelString neotel = NeotelHashMapBuilder.buildHashMapWithPipeDelimited(position);
            logger.debug(position);
            logger.debug(neotel.toString());
            if (neotel.getEstadoCrm().equals("Unavailable")) {
                response.setStatus("OK");
                response.setCode("00");
                response.setDescription("Usuario deslogueado correctamente de la campania");
                logger.info(" OK: Usuario " + neotelUser + " dessloguado correctamente");
                return response;
            } else {
                response.setStatus("ERROR");
                response.setCode("01");
                response.setDescription("No se deslogueo correctamente");
                logger.error("ERROR: Usuario " + neotelUser + " no pudo desloguarse correctamente");
                return response;
            }
        } catch (Exception errorNeotel) {

            response.setStatus("ERROR");
            response.setCode("02");

            String message = errorNeotel.getMessage();
            String cause = "";
            if (errorNeotel.getCause() != null) {
                cause = ": " + errorNeotel.getCause().getMessage();
            }

            response.setDescription(message + cause);

            logger.error("Se produjo el siguiente error: " + errorNeotel.getMessage() + "usuario: " + neotelUser);

            return response;
        }

    }

    @Override
    public RequestResponse pause(String neotelUser, String subtipoDescanso) {
        RequestResponse response = new RequestResponse();
        try {
            if (subtipoDescanso.equalsIgnoreCase("CAFE") || subtipoDescanso.equalsIgnoreCase("BAÑO") || subtipoDescanso.equalsIgnoreCase("BANO")
                    || subtipoDescanso.equalsIgnoreCase("OTROS")) {
                try {
                    String position = neotelService.position(neotelUser);
                    NeotelString neotel = NeotelHashMapBuilder.buildHashMapWithPipeDelimited(position);
                    logger.debug(position);
                    logger.debug(neotel.toString());
                    logger.debug("Pausando encuestador: " + neotelUser);
                    tipoPausa descanso = tipoPausa.valueOf(subtipoDescanso.toUpperCase());
                    neotelService.pause(neotelUser, descanso.getIdDescanso(subtipoDescanso));
                    neotelService.crmNoDisponible(neotelUser);
                    response.setStatus("OK");
                    response.setCode("00");
                    response.setDescription("Usuario en pausa.No recibira llamadas momentaneamente");
                    logger.debug("OK: El usuario se encuentra en la siguiente pausa: " + subtipoDescanso);
                    return response;
                } catch (Exception errorNeotel) {
                    response.setStatus("ERROR");
                    response.setCode("01");
                    response.setDescription("Usuario incorrecto");
                    logger.debug("ERROR: Usuario incorrecto ");
                    return response;
                }
            } else {
                response.setStatus("ERROR");
                response.setCode("01");
                response.setDescription("Descanso incorrecto");
                logger.debug("ERROR: El descanso seleccionado no es correcto");
                return response;
            }
        } catch (Exception errorNeotel) {
            response.setStatus("ERROR");
            response.setCode("02");
            String message = errorNeotel.getMessage();
            String cause = "";
            if (errorNeotel.getCause() != null) {
                cause = ": " + errorNeotel.getCause().getMessage();
            }
            response.setDescription(message + cause);
            logger.error("Se produjo el siguiente error: " + errorNeotel.getMessage() + "usuario: " + neotelUser);

            return response;
        }
    }

    @Override
    public RequestResponse dialPhone(String neotelUser, String telephone) {

        RequestResponse response = new RequestResponse();

        try {

            logger.info("Usuario: " + neotelUser + " intentando llamar a  " + telephone);

            String position = neotelService.position(neotelUser);
            NeotelString neotel = NeotelHashMapBuilder.buildHashMapWithPipeDelimited(position);

            logger.debug(position);
            logger.debug(neotel.toString());

            if (neotel.getSalCampaniaDefault().equals("0")) {

                response.setStatus("ERROR");
                response.setCode("01");
                response.setDescription("Usuario no logeado a una campania");
                logger.error("Usuario no logeado a una campania");

                return response;

            } else {

                neotelService.crmUnavailable(neotelUser);
                neotelService.unpause(neotelUser);
                neotelService.dial(neotelUser, telephone);

                response.setStatus("OK");
                response.setCode("00");
                response.setDescription("Llamando al Telefono indicado");

                logger.info("usuario: " + neotelUser + "Llamando al: " + telephone);

                return response;
            }
        } catch (Exception errorNeotel) {

            response.setStatus("ERROR");
            response.setCode("02");

            String message = errorNeotel.getMessage();
            String cause = "";
            if (errorNeotel.getCause() != null) {
                cause = ": " + errorNeotel.getCause().getMessage();
            }

            response.setDescription(message + cause);

            logger.error("Se produjo el siguiente error: " + errorNeotel.getMessage() + "usuario: " + neotelUser);

            return response;
        }

    }

    @Override
    public RequestResponse stopCalls(String idCampania, String campo1, String campo2) {
        RequestResponse response = new RequestResponse();
        logger.info("Iniciando Stoppeo de llamadas para la campaña: " + idCampania + "con los campos: " + campo1 + " y " + campo2);
        try {
            String camp1 =  campo1.trim();
            if(camp1.isEmpty()){
                response.setStatus("ERROR");
                response.setCode("01");
                response.setDescription("Campo 1 no contiene ningun valor");
                return response;
                
            } else{
                
            
                String c2 = "s";
                String c1 = "s";
                String auxCamp1 = campo1.trim();
                campo1 = auxCamp1;
                if (campo2.isEmpty()){
                     c2 = "n";
                }else {
                    
                    String auxCamp2 = campo2.trim();
                    campo2 = auxCamp2;
                }
              
         
                
                String mensaje = neotelService.executeTask06(15, c1, campo1, c2, campo2, idCampania, "N");

                response.setStatus("OK");
                response.setCode("00");
                response.setDescription(mensaje);
//                response.setDescription("Stopeo realizado con exito");
                logger.info("Stopeo de llamadas realizado con exito");
                return response;
            }
        } catch (Exception errorNeotel) {
            response.setStatus("ERROR");
            response.setCode("02");
            
            String message = errorNeotel.getMessage();
            String cause = "";
            if (errorNeotel.getCause() != null) {
                cause = ": " + errorNeotel.getCause().getMessage();
            }
            
            response.setDescription(message + cause);
            
            logger.error("Se produjo el siguiente error: " + errorNeotel.getMessage());
            
            return response;
        }
    }
   
 
    @Override
    public RequestResponse activeCalls(String idCampania, String campo1, String campo2) {
        
        RequestResponse response = new RequestResponse();
        logger.info("Iniciando Activar llamadas para la campaña: " + idCampania + "con los campos: " + campo1 + " y "+ campo2);
        try {
            String camp1 =  campo1.trim();
            if(camp1.isEmpty()){
                response.setStatus("ERROR");
                response.setCode("01");
                response.setDescription("Campo 1 no contiene ningun valor");
                return response;
                
            }else{
                
            
            String c2 = "s";
            String c1 = "s";
            String auxCamp1 = campo1.trim();
            campo1 = auxCamp1;
            
            if (campo2.isEmpty()){
                 c2 = "n";
            }else {
                
                String auxCamp2 = campo2.trim();
                campo2 = auxCamp2;
            }
            
          
            String mensaje = neotelService.executeTask06(15, c1, campo1, c2, campo2, idCampania, "S");
            
            response.setStatus("OK");
            response.setCode("00");
            response.setDescription(mensaje);
//          response.setDescription("Activación realizada con éxito");
            logger.info("Activación de llamada realizada con éxito");
            return response;
            }
        } catch (Exception errorNeotel) {
            response.setStatus("ERROR");
            response.setCode("02");
            
            String message = errorNeotel.getMessage();
            String cause = "";
            if (errorNeotel.getCause() != null) {
                cause = ": " + errorNeotel.getCause().getMessage();
            }
            
            response.setDescription(message + cause);
            
            logger.error("Se produjo el siguiente error: " + errorNeotel.getMessage());
            
            return response;
        }
    }
}

                    


