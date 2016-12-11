package pcs3614.howstheweather.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Constants {
    /* ------------------------------------------- API ------------------------------------------ */
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
    public static final String URL = URL_BASE + "uac=" + UAC + "&output=" + OUTPUT + "&temp_unit=" + TEMP_UNIT + "&ws_unit=" + WS_UNIT + "&query=";

    /* ------------------------------------------------------------------------------------------ */

    public static final String CIDADE_DEFAULT = "São Paulo - SP";

    public static final String BROADCAST_WEATHER = "BROADCAST_WEATHER";

    public static final int ESTADO_INDISPONIVEL = 0;
    public static final int ESTADO_IDEAL = 1;
    public static final int ESTADO_ATENCAO = 2;
    public static final int ESTADO_ALERTA = 3;
    public static final int ESTADO_EMERGENCIA = 4;

    public static final String ESTADO_INDISPONIVEL_HEADER = "";
    public static final String ESTADO_IDEAL_HEADER = "Estado ideal";
    public static final String ESTADO_ATENCAO_HEADER = "Estado de atenção";
    public static final String ESTADO_ALERTA_HEADER = "Estado de alerta";
    public static final String ESTADO_EMERGENCIA_HEADER = "Estado de emergência";

    public static final String ESTADO_INDISPONIVEL_DESCRIP = "Informações não disponíveis.";
    public static final String ESTADO_IDEAL_DESCRIP = "exercícios físicos ao ar livre são totalmente recomendados. Não se esqueça de hidratar-se frequentemente e utilizar roupas leves.";
    public static final String ESTADO_ATENCAO_DESCRIP = "sugere-se que exercícios físicos ao ar livre entre 11 e 15 horas sejam evitados. Sempre que possível, permaneça em locais protegidos do sol, em áreas vegetadas ou afins. Recomenda-se que cerca de 300 a 500 ml de água sejam ingeridos 30 minutos antes da atividade física e 200 a 250 ml a cada 20 minutos.";
    public static final String ESTADO_ALERTA_DESCRIP = "é sugerido que não sejam realizados exercícios físicos e trabalhos ao ar livre entre 10 e 16 horas. Atividades em ambientes fechados também não são recomendadas devido à quantidade de pessoas aglomeradas no mesmo recinto.";
    public static final String ESTADO_EMERGENCIA_DESCRIP = "ualquer atividade ao ar livre entre 10 e 16 horas deve ser suspensa, assim como as atividades que exijam aglomerações de pessoas em recintos fechados.";

    public static final String[] LISTA_CIDADES = {
            "Aracaju - SE"
            , "Belém - PA"
            , "Belo Horizonte - MG"
            , "Boa Vista - RR"
            , "Brasília - DF"
            , "Campo Grande - MS"
            , "Cuiabá - MT"
            , "Curitiba - PR"
            , "Florianópolis - SC"
            , "Fortaleza - CE"
            , "Goiânia - GO"
            , "João Pessoa - PB"
            , "Macapá - AP"
            , "Maceió - AL"
            , "Manaus - AM"
            , "Natal - RN"
            , "Palmas - TO"
            , "Porto Alegre - RS"
            , "Porto Velho - RO"
            , "Recife - PE"
            , "Rio Branco - AC"
            , "Rio de Janeiro - RJ"
            , "Salvador - BA"
            , "São Luís - MA"
            , "São Paulo - SP"
            , "Teresina - PI"
            , "Vitória - ES"
    };

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

    public static final Map<String, String> MESES;

    static {
        MESES = new HashMap<String, String>();
        MESES.put("01", "janeiro");
        MESES.put("02", "fevereiro");
        MESES.put("03", "março");
        MESES.put("04", "abril");
        MESES.put("05", "maio");
        MESES.put("06", "junho");
        MESES.put("07", "julho");
        MESES.put("08", "agosto");
        MESES.put("09", "setembro");
        MESES.put("10", "outubro");
        MESES.put("11", "novembro");
        MESES.put("12", "dezembro");
    }

    public static final Map<String, String> DESCRICAO;

    static {
        DESCRICAO = new HashMap<String, String>();
        DESCRICAO.put("-999", "N/A");
        DESCRICAO.put("0", "Céu limpo");
        DESCRICAO.put("1", "Céu parcialmente nublado");
        DESCRICAO.put("2", "Céu nublado");
        DESCRICAO.put("3", "Céu encoberto");
        DESCRICAO.put("10", "Neblina");
        DESCRICAO.put("21", "Possibilidade de chuvas esparsas");
        DESCRICAO.put("22", "Possibilidade de neve");
        DESCRICAO.put("23", "Possibilidade de granizo");
        DESCRICAO.put("24", "Possibilidade de  garoa");
        DESCRICAO.put("29", "Pancadas de chuva");
        DESCRICAO.put("38", "Neve");
        DESCRICAO.put("39", "Nevasca");
        DESCRICAO.put("45", "Nevoeiro");
        DESCRICAO.put("49", "Nevoeiro");
        DESCRICAO.put("50", "Garoa");
        DESCRICAO.put("51", "Garoa leve");
        DESCRICAO.put("56", "Garoa intensa");
        DESCRICAO.put("57", "Garoa intensa");
        DESCRICAO.put("60", "Possibilidade de chuvas leves");
        DESCRICAO.put("61", "Chuva leve");
        DESCRICAO.put("62", "Pancadas de chuva moderadas");
        DESCRICAO.put("63", "Chuva moderada");
        DESCRICAO.put("64", "Pancadas de chuva forte");
        DESCRICAO.put("65", "Chuva forte");
        DESCRICAO.put("66", "Chuva congelante leve");
        DESCRICAO.put("67", "Chuva congelante moderada");
        DESCRICAO.put("68", "Granizo leve");
        DESCRICAO.put("69", "Granizo moderado ou forte");
        DESCRICAO.put("70", "Possibilidade de neve");
        DESCRICAO.put("71", "Neve leve");
        DESCRICAO.put("72", "Possibilidade de neve moderada");
        DESCRICAO.put("73", "Neve moderada");
        DESCRICAO.put("74", "Possibilidade de neve forte");
        DESCRICAO.put("75", "Neve forte");
        DESCRICAO.put("79", "Granizo");
        DESCRICAO.put("80", "Chuva leve");
        DESCRICAO.put("81", "Chuvas moderadas ou fortes");
        DESCRICAO.put("82", "Tempestades");
        DESCRICAO.put("83", "Granizo leve");
        DESCRICAO.put("84", "Granizo moderado ou forte");
        DESCRICAO.put("85", "Neve leve");
        DESCRICAO.put("86", "Neve moderada ou forte");
        DESCRICAO.put("87", "Granizo");
        DESCRICAO.put("88", "Granizo moderado ou forte");
        DESCRICAO.put("91", "Possibilidade de chuvas com trovoadas");
        DESCRICAO.put("92", "Chuvas moderadas ou fortes com trovoadas");
        DESCRICAO.put("93", "Possibilidade de neve com trovoadas");
        DESCRICAO.put("94", "Neve moderada ou forte com trovoadas");
    }
}
