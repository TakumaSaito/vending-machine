package jp.co.tis.model;

/**
 * お金の種類をもったクラス。
 *
 * @author Saito Takuma
 * @since 1.0
 */
public class Coins {

    /**
     * コンストラクタ。 インスタンス生成抑止のためprivate。
     */
    private Coins() {
    }

    /** 1円玉 */
    public static final int COIN_1 = 1;

    /** 5円玉 */
    public static final int COIN_5 = 5;

    /** 10円玉 */
    public static final int COIN_10 = 10;

    /** 50円玉 */
    public static final int COIN_50 = 50;

    /** 100円玉 */
    public static final int COIN_100 = 100;

    /** 500円玉 */
    public static final int COIN_500 = 500;

    /** 1000円札 */
    public static final int BILL_1000 = 1000;

    /** 2000円札 */
    public static final int BILL_2000 = 2000;

    /** 5000円札 */
    public static final int BILL_5000 = 5000;

    /** 10000円札 */
    public static final int BILL_10000 = 10000;

}
