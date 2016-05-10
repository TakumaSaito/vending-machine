package jp.co.tis.model;

import java.util.HashMap;
import java.util.Map;

/**
 * 自動販売機クラス。
 *
 * @author Saito Takuma
 * @since 1.0
 */
public class VendingMachine {

    /** 投入金額 */
    private int insertMoney;

    /** 釣り銭 */
    private int changeMoney;

    /** 売上金 */
    private int saleAmount;

    /** 商品情報Map（key : 商品名 value : 商品情報 ） */
    private Map<String, Goods> goodsInfoMap;

    /** 釣り銭（10円）のストック */
    private int coin10Stock;

    /** 釣り銭（50円）のストック */
    private int coin50Stock;

    /** 釣り銭（100円）のストック */
    private int coin100Stock;

    /** 釣り銭（500円）のストック */
    private int coin500Stock;

    /**
     * コンストラクタ。
     */
    public VendingMachine() {
        setInsertMoney(0);
        setChangeMoney(0);
        setSaleAmount(0);
        setGoodsInfoMap(new HashMap<String, Goods>());
        setCoin10Stock(0);
        setCoin50Stock(0);
        setCoin100Stock(0);
        setCoin500Stock(0);
    }

    /**
     * 投入金額を取得する。
     *
     * @return 投入金額
     */
    public int getInsertMoney() {
        return insertMoney;
    }

    /**
     * 投入金額を設定する。
     *
     * @param insertMoney 投入金額
     */
    public void setInsertMoney(int insertMoney) {
        this.insertMoney = insertMoney;
    }

    /**
     * 釣り銭を取得する。
     *
     * @return 釣り銭
     */
    public int getChangeMoney() {
        return changeMoney;
    }

    /**
     * 釣り銭を設定する。
     *
     * @param changeMoney 釣り銭
     */
    public void setChangeMoney(int changeMoney) {
        this.changeMoney = changeMoney;
    }

    /**
     * 売上金を取得する。
     *
     * @return 売上金
     */
    public int getSaleAmount() {
        return saleAmount;
    }

    /**
     * 売上金を設定する。
     *
     * @param saleAmount 売上金
     */
    public void setSaleAmount(int saleAmount) {
        this.saleAmount = saleAmount;
    }

    /**
     * 商品情報を取得する。
     *
     * @return 商品情報
     */
    public Map<String, Goods> getGoodsInfoMap() {
        return goodsInfoMap;
    }

    /**
     * 商品情報を設定する。
     *
     * @param goodsInfoMap 商品情報
     */
    public void setGoodsInfoMap(Map<String, Goods> goodsInfoMap) {
        this.goodsInfoMap = goodsInfoMap;
    }

    /**
     * 釣り銭（10円）のストックを取得する。
     *
     * @return 釣り銭（10円）のストック
     */
    public int getCoin10Stock() {
        return coin10Stock;
    }

    /**
     * 釣り銭（10円）のストックを設定する。
     *
     * @param coin10Stock 釣り銭（10円）のストック
     */
    public void setCoin10Stock(int coin10Stock) {
        this.coin10Stock = coin10Stock;
    }

    /**
     * 釣り銭（50円）のストックを取得する。
     *
     * @return 釣り銭（50円）のストック
     */
    public int getCoin50Stock() {
        return coin50Stock;
    }

    /**
     * 釣り銭（50円）のストックを設定する。
     *
     * @param coin50Stock 釣り銭（50円）のストック
     */
    public void setCoin50Stock(int coin50Stock) {
        this.coin50Stock = coin50Stock;
    }

    /**
     * 釣り銭（100円）のストックを取得する。
     *
     * @return 釣り銭（100円）のストック
     */
    public int getCoin100Stock() {
        return coin100Stock;
    }

    /**
     * 釣り銭（100円）のストックを設定する。
     *
     * @param coin100Stock 釣り銭（100円）のストック
     */
    public void setCoin100Stock(int coin100Stock) {
        this.coin100Stock = coin100Stock;
    }

    /**
     * 釣り銭（500円）のストックを取得する。
     *
     * @return 釣り銭（500円）のストック
     */
    public int getCoin500Stock() {
        return coin500Stock;
    }

    /**
     * 釣り銭（500円）のストックを設定する。
     *
     * @param coin500Stock 釣り銭（500円）のストック
     */
    public void setCoin500Stock(int coin500Stock) {
        this.coin500Stock = coin500Stock;
    }

}
