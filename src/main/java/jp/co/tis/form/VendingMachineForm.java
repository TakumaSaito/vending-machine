package jp.co.tis.form;

import java.io.Serializable;

/**
 * 自動販売機用Form。<br/>
 * 画面の入力項目や画面から送られてくる項目をプロパティとして持つクラス。
 *
 * @author Saito Takuma
 * @since 1.0
 */
public class VendingMachineForm implements Serializable {

    /** 日付 */
    private String weatherDate;

    /**
     * デフォルトコンストラクタ。
     */
    public VendingMachineForm() {
    }

    /**
     * コンストラクタ。
     *
     * @param weatherDate 日付
     */
    public VendingMachineForm(String weatherDate) {
        this.weatherDate = weatherDate;
    }

    /**
     * 日付を取得する。
     *
     * @return 日付
     */
    public String getWeatherDate() {
        return weatherDate;
    }

    /**
     * 日付を設定する。
     *
     * @param weatherDate 日付
     */
    public void setWeatherDate(String weatherDate) {
        this.weatherDate = weatherDate;
    }
}
