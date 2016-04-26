package jp.co.tis.model;

/**
 * テストケース用サンプルコード
 *
 * @author Fujiwara Chie
 * @since 1.0
 */
public class VendingMachineStep1 {

    /** 投入金額 */
    private int amount;

    /** 釣り銭 */
    private int change;

    /**
     * コンストラクタ。
     */
    public VendingMachineStep1() {
        setAmount(0);
        setChange(0);
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
     * 現金の投入。
     *
     * @param money 投入する現金
     */
    public void insert(int money) {
        this.amount += money;
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
