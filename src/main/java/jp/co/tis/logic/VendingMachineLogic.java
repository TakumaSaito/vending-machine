package jp.co.tis.logic;

import jp.co.tis.model.Coins;

/**
 * 自動販売機Logicクラス。<br/> コントローラーに直接メソッド切り出しを行うと行数が膨れるため<br/>
 * 業務ロジック部分はロジッククラスに切り出す。<br/> JUnitテストをしやすくするための目的もある。
 *
 * @author Saito Takuma
 * @since 1.0
 */
public class VendingMachineLogic {

    /**
     * 自販機で認識可能なお金かどうかを判断する。
     *
     * @param insertMoney 投入したお金
     * @return {@code true} 認識可能 {@code false} 認識不可能
     */
    public boolean isValidMoney(int insertMoney) {
        if (insertMoney == Coins.COIN_1) {
            return false;
        }
        if (insertMoney == Coins.COIN_5) {
            return false;
        }
        if (insertMoney == Coins.BILL_2000) {
            return false;
        }
        if (insertMoney == Coins.BILL_5000) {
            return false;
        }
        if (insertMoney == Coins.BILL_10000) {
            return false;
        }
        return true;
    }

}
