package jp.co.tis.model;

/**
 * テストケース用サンプルコード
 *
 * @author Fujiwara Chie
 * @since 1.0
 */
public class VendingMachineStep5 {

    /** 投入金額。 */
    private int amount;

    /** 釣り銭。 */
    private int change;

    /** 売上金。 */
    private int saleAmount;

    private Goods cola = new Goods();
    private Goods readbull = new Goods();
    private Goods water = new Goods();

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
     * 売上金のgetter。
     *
     * @return 売上金。
     */
    public int getSaleAmount() {
        return saleAmount;
    }

    /**
     * 売上金のsetter。
     *
     * @param saleAmount セットする売上金。
     */
    public void setSaleAmount(int saleAmount) {
        this.saleAmount = saleAmount;
    }

    /**
     * コンストラクタ。
     */
    VendingMachineStep5() {
        setAmount(0);
        setChange(0);
        setSaleAmount(0);
    }

    /**
     * 現金の投入。
     *
     * @param money 投入する現金
     */
    public void insert(int money) {
        if (money == Coins.COIN_10 || money == Coins.COIN_50 || money == Coins.COIN_100 || money == Coins.COIN_500) {
            amount += money;
        } else {
            change = money;
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
     * 購入。
     */
    public void purchase() {
        if (cola.canPurchase(amount)) {
            cola.setStock(cola.getStock() - 1);
            saleAmount += cola.getPrice();
            amount -= cola.getPrice();
        }

    }

    /**
     * 釣り銭を出力。
     */
    public void outChange() {
        System.out.println("釣り銭は" + change + "円です。");
    }

}
