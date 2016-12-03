package pcs3614.howstheweather.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Samsung on 03/12/2016.
 */

public class Constants {
    // Informações sobre a API e seus parâmetros
    // http://www.myweather2.com/developer/apis.aspx?uref=becda844-8299-4bf6-899b-d771a92b9dbf

    // URL BASE
    private static final String URL_BASE = "http://www.myweather2.com/developer/forecast.ashx?";

    // PARÂMETROS

    // Código de acesso
    private static final String UAC = "mOZe06wPPC";
    // Tipo de retorno
    private static final String OUTPUT = "json";
    // Unidade de temperatura
    private static final String TEMP_UNIT = "c";
    // Unidade de velocidade do vento
    private static final String WS_UNIT = "kph";

    // REQUISIÇÃO
    public static final String URL = URL_BASE + "uac=" + UAC + "&output=" + OUTPUT + "&temp_unit=" + TEMP_UNIT + "&ws_unit" + WS_UNIT + "&query=";

    // CIDADES E SUAS COORDENADAS NO FORMATO LAT,LONG
    public static final Map<String, String> CIDADES;

    static {
        CIDADES = new HashMap<String, String>();
        CIDADES.put("Aracaju - SE", "-10.911,-37.071");
        CIDADES.put("Belém - PA", "-1.4558,-48.504");
        CIDADES.put("Belo Horizonte - MG", "-19.920,-43.937");
        CIDADES.put("Boa Vista - RR", "2.81972,-60.673");
        CIDADES.put("Brasília - DF", "-15.779,-47.929");
        CIDADES.put("Campo Grande - MS", "-20.442,-54.646");
        CIDADES.put("Cuiabá - MT", "-15.596,-56.096");
        CIDADES.put("Curitiba - PR", "-25.427,-49.273");
        CIDADES.put("Florianópolis - SC", "-27.596,-48.549");
        CIDADES.put("Fortaleza - CE", "-3.7172,-38.543");
        CIDADES.put("Goiânia - GO", "-16.678,-49.253");
        CIDADES.put("João Pessoa - PB", "-7.115,-34.863");
        CIDADES.put("Macapá - AP", "0.03888,-51.066");
        CIDADES.put("Maceió - AL", "-9.6658,-35.735");
        CIDADES.put("Manaus - AM", "-3.1019,-60.025");
        CIDADES.put("Natal - RN", "-5.795,-35.209");
        CIDADES.put("Palmas - TO", "-10.212,-48.360");
        CIDADES.put("Porto Alegre - RS", "-30.033,-51.23");
        CIDADES.put("Porto Velho - RO", "-8.7619,-63.903");
        CIDADES.put("Recife - PE", "-8.0538,-34.881");
        CIDADES.put("Rio Branco - AC", "-9.9747,-67.81");
        CIDADES.put("Rio de Janeiro - RJ", "-22.902,-43.207");
        CIDADES.put("Salvador - BA", "-12.971,-38.510");
        CIDADES.put("São Luís - MA", "-2.5297,-44.302");
        CIDADES.put("São Paulo - SP", "-23.547,-46.636");
        CIDADES.put("Teresina - PI", "-5.0891,-42.801");
        CIDADES.put("Vitória - ES", "-20.319,-40.337");
    }

}
