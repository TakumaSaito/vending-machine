package jp.co.tis.model;

/**
 * テストケース用サンプルコード
 *
 * @author Fujiwara Chie
 * @since 1.0
 */
public class Goods {

    /** 商品名 */
    private String name;

    /** 値段 */
    private int price;

    /** 在庫 */
    private int stock;

    /**
     * 商品名のgetter。
     *
     * @return 商品名
     */
    public String getName() {
        return name;
    }

    /**
     * 商品名のsetter。
     *
     * @param name セットする商品名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 値段のgetter。
     *
     * @return 商品名
     */
    public int getPrice() {
        return price;
    }

    /**
     * 値段のsetter。
     *
     * @param price セットする値段
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * 在庫のgetter。
     *
     * @return 商品名
     */
    public int getStock() {
        return stock;
    }

    /**
     * 在庫のsetter。
     *
     * @param stock セットする在庫
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * 購入可能かの判定。
     *
     * @param amount 投入金額
     * @return 購入可否
     */
    public boolean canPurchase(int amount) {
        if (stock > 0 && amount >= price) {
            return true;
        } else {
            return false;
        }
    }

}
