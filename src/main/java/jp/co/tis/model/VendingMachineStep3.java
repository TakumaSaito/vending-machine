package jp.co.tis.model;

import java.util.ArrayList;
import java.util.List;

/**
 * テストケース用サンプルコード
 *
 * @author Fujiwara Chie
 * @since 1.0
 */
public class VendingMachineStep3 {

    /** 投入金額 */
    private int amount;

    /** 釣り銭 */
    private int change;

    /** 飲み物のリスト */
    private List<Goods> juices = new ArrayList<Goods>();

    /**
     * コンストラクタ。
     */
    public VendingMachineStep3() {
        setAmount(0);
        setChange(0);
        setJuices(new ArrayList<Goods>());
    }

    /**
     * コンストラクタ。
     */
    public VendingMachineStep3(int amount, int change, List<Goods> juices) {
        setAmount(amount);
        setChange(change);
        setJuices(juices);
    }

    /**
     * 投入金額のgetter。
     *
     * @return 投入金額
     */
    public int getAmount() {
        return amount;
    }

    /**
     * 投入金額のsetter。
     *
     * @param amount セットする投入金額
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * 釣り銭のgetter。
     *
     * @return 釣り銭
     */
    public int getChange() {
        return change;
    }

    /**
     * 釣り銭のsetter。
     *
     * @param change セットする釣り銭
     */
    public void setChange(int change) {
        this.change = change;
    }

    /**
     * 飲み物のリストを取得する。
     *
     * @return juices
     */
    public List<Goods> getJuices() {
        return juices;
    }

    /**
     * 飲み物のリストを設定する。
     *
     * @param juices 飲み物のリスト
     */
    public void setJuices(List<Goods> juices) {
        this.juices = juices;
    }

    /**
     * 現金の投入。
     *
     * @param money 投入する現金
     */
    public void insert(int money) {
        if (money == Coins.COIN_10 || money == Coins.COIN_50 || money == Coins.COIN_100 || money == Coins.COIN_500) {
            this.amount += money;
        } else {
            outChange();
        }
    }

    /**
     * 払い戻し。
     */
    public void refund() {
        change = amount;
        amount = 0;
        outChange();
    }

    /**
     * 釣り銭を出力。
     */
    public void outChange() {
        System.out.println("釣り銭は" + change + "円です。");
    }
}
