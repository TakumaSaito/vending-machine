package jp.co.tis.form;

import java.io.Serializable;

/**
 * 自動販売機用Form。<br/> 画面の入力項目や画面から送られてくる項目をプロパティとして持つクラス。
 *
 * @author Saito Takuma
 * @since 1.0
 */
public class VendingMachineForm implements Serializable {

    /** 投入金額 */
    private String insertMoney;

    /** 商品 */
    private String goods;

    /** 金額合計 */
    private String sumMoney;

    /**
     * デフォルトコンストラクタ。
     */
    public VendingMachineForm() {
    }

    /**
     * コンストラクタ。
     *
     * @param insertMoney 投入金額
     * @param goods 商品
     * @param sumMoney 金額合計
     */
    public VendingMachineForm(String insertMoney, String goods, String sumMoney) {
        this.insertMoney = insertMoney;
        this.goods = goods;
        this.sumMoney = sumMoney;
    }

    /**
     * 投入金額を取得する。
     *
     * @return 投入金額
     */
    public String getInsertMoney() {
        return insertMoney;
    }

    /**
     * 投入金額を設定する。
     *
     * @param insertMoney 投入金額
     */
    public void setInsertMoney(String insertMoney) {
        this.insertMoney = insertMoney;
    }

    /**
     * 商品を取得する。
     *
     * @return 商品
     */
    public String getGoods() {
        return goods;
    }

    /**
     * 商品を設定する。
     *
     * @param goods 商品
     */
    public void setGoods(String goods) {
        this.goods = goods;
    }

    /**
     * 金額合計を取得する。
     *
     * @return 金額合計
     */
    public String getSumMoney() {
        return sumMoney;
    }

    /**
     * 金額合計を設定する。
     *
     * @param sumMoney 金額合計
     */
    public void setSumMoney(String sumMoney) {
        this.sumMoney = sumMoney;
    }
}
