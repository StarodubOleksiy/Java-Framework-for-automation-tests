package data;

import java.util.HashMap;
import java.util.Map;

public class ChangeInstrument {

    public static final String all = "All";

    public static final String pathFxAlfaAUDCHF1 = "FX/alfa/AUDCHF1";

    public static final String itemAUDCHF = "AUDCHF";

    public static final String itemAUDCHFDesc = "AUDCHF1";

    public static final String pathFxAlfaAUDJPY = "FX/alfa/AUDJPY";

    public static final String itemAUDJPY = "AUDJPY";

    public static final String itemEURUSD = "EURUSD";

    public static final String itemUSDRUB = "USDRUB";

    public static final String pathFx0647809USDRUB = "FX/0647809/USDRUB";

    public static final String itemCADJPY = "CADJPY";

    public static final String  pathFxAlfaCADJPY = "FX/alfa/CADJPY";

    public static final String itemCHFRUB = "CHFRUB";

    public static final String pathFxAlfaCHFRUB = "FX/alfa/CHFRUB_TOM";

    public static final String item_MGS_5_8_Aug_2021 = "MGS 5 8aug2021";//"  MGS 5 8aug2021";

    public static final String itemCAPCLSE = "GAZP ADR";//"CAPC.LSE";

    public static final String item_RTS_FORTS_H2019 = "RTS.FORTS.H2019";

    public static final String itemMGS58aug2021 = "MGS 5 8aug2021";

    public static final String itemRSTFORTSH2019 = "RTS.FORTS.H2019";

    public static final Map<String, String> findPathToItem = new HashMap<String, String>();

    static {
        findPathToItem.put(itemAUDCHF, "FX/alfa/AUDCHF1");
        findPathToItem.put(itemAUDJPY, "FX/alfa/AUDJPY");
        findPathToItem.put(itemUSDRUB, "FX/0647809/USDRUB");
        findPathToItem.put(itemCADJPY, "FX/alfa/CADJPY");
    }

}
