package jp.co.tis.model;

/**
 * 商品の情報を保持するクラス。
 *
 * @author Saito Takuma
 * @since 1.0
 */
public class Goods {

    /** 商品名 */
    private String goodsName;

    /** 値段 */
    private int price;

    /** 在庫 */
    private int stock;

    /**
     * デフォルトコンストラクタ。
     */
    public Goods() {
        setGoodsName("");
        setPrice(0);
        setStock(0);
    }

    /**
     * コンストラクタ。
     *
     * @param goodsName 商品名
     * @param price 値段
     * @param stock 在庫
     *
     */
    public Goods(String goodsName, int price, int stock) {
        setGoodsName(goodsName);
        setPrice(price);
        setStock(stock);
    }

    /**
     * 商品名を取得する。
     *
     * @return 商品名
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 商品名を設定する。
     *
     * @param goodsName 商品名
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /**
     * 値段を取得する。
     *
     * @return 値段
     */
    public int getPrice() {
        return price;
    }

    /**
     * 値段を設定する。
     *
     * @param price 値段
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * 在庫を取得する。
     *
     * @return 在庫
     */
    public int getStock() {
        return stock;
    }

    /**
     * 在庫を設定する。
     *
     * @param stock 在庫
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

}
