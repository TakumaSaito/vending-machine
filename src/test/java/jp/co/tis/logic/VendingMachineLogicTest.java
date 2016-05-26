package jp.co.tis.logic;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import jp.co.tis.model.Coins;
import jp.co.tis.model.Goods;
import jp.co.tis.model.VendingMachine;

/**
 * 自動販売機Logicのテストクラス。
 *
 * @author Saito Takuma
 * @since 1.0
 */
public class VendingMachineLogicTest {

    /** テスト対象クラス */
    private VendingMachineLogic target = new VendingMachineLogic();

    /**
     * 認識可能なお金のテスト（100円玉）。
     */
    @Test
    public void testIsValidMoneyCoin100() {
        boolean result = target.isValidMoney(Coins.COIN_100);
        assertThat(result, is(true));
    }

    /**
     * 認識不可能なお金のテスト（1円玉）。
     */
    @Test
    public void testIsValidMoneyCoin1() {
        boolean result = target.isValidMoney(Coins.COIN_1);
        assertThat(result, is(false));
    }

    /**
     * 認識不可能なお金のテスト（5円玉）。
     */
    @Test
    public void testIsValidMoneyCoin5() {
        boolean result = target.isValidMoney(Coins.COIN_5);
        assertThat(result, is(false));
    }

    /**
     * 認識不可能なお金のテスト（2000円札）。
     */
    @Test
    public void testIsValidMoneyBill2000() {
        boolean result = target.isValidMoney(Coins.BILL_2000);
        assertThat(result, is(false));
    }

    /**
     * 認識不可能なお金のテスト（5000円札）。
     */
    @Test
    public void testIsValidMoneyBill5000() {
        boolean result = target.isValidMoney(Coins.BILL_5000);
        assertThat(result, is(false));
    }

    /**
     * 認識不可能なお金のテスト（10000円札）。
     */
    @Test
    public void testIsValidMoneyBill10000() {
        boolean result = target.isValidMoney(Coins.BILL_10000);
        assertThat(result, is(false));
    }

    /**
     * 商品名から商品情報を取得するテスト。
     */
    @Test
    public void testGetGoodsInfo() {
        Map<String, Goods> goodsInfoMap = new HashMap<String, Goods>();
        Goods coke = new Goods("コーラ", 120, 5);
        goodsInfoMap.put(coke.getGoodsName(), coke);

        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setGoodsInfoMap(goodsInfoMap);
        Goods result = target.getGoodsInfo("コーラ", vendingMachine);

        assertThat(result.getGoodsName(), is("コーラ"));
        assertThat(result.getPrice(), is(120));
        assertThat(result.getStock(), is(5));
    }

    /**
     * 商品名から商品情報を取得するテスト。
     */
    @Test
    public void testIsPurchasable() {
        Goods coke = new Goods("コーラ", 120, 5);
        boolean result = target.isPurchasable(120, coke);

        assertThat(result, is(true));
    }

    /**
     * 商品名から商品情報を取得するテスト(在庫が０)。
     */
    @Test
    public void testIsPurchasableForStock0() {
        Goods coke = new Goods("コーラ", 120, 0);
        boolean result = target.isPurchasable(120, coke);

        assertThat(result, is(false));
    }

    /**
     * 商品名から商品情報を取得するテスト(投入金額が値段より低い)。
     */
    @Test
    public void testIsPurchasableForInsertMoneyLessThanPrice() {
        Goods coke = new Goods("コーラ", 120, 5);
        boolean result = target.isPurchasable(110, coke);

        assertThat(result, is(false));
    }

    /**
     * 商品名から商品情報を取得するテスト(投入金額が値段より低い)。
     */
    @Test
    public void testGetPurchasableGoodsList() {
        Map<String, Goods> goodsInfoMap = new LinkedHashMap<String, Goods>();
        Goods coke = new Goods("コーラ", 120, 5);
        Goods energyDrink = new Goods("エナジードリンク", 200, 5);
        Goods water = new Goods("水", 100, 0);
        goodsInfoMap.put(coke.getGoodsName(), coke);
        goodsInfoMap.put(energyDrink.getGoodsName(), energyDrink);
        goodsInfoMap.put(water.getGoodsName(), water);

        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setGoodsInfoMap(goodsInfoMap);

        List<Goods> purchasableGoodsList = target.getPurchasableGoodsList(vendingMachine);
        assertThat(purchasableGoodsList.size(), is(2));
        assertThat(purchasableGoodsList.get(0).getGoodsName(), is("コーラ"));
        assertThat(purchasableGoodsList.get(1).getGoodsName(), is("エナジードリンク"));
    }

    /**
     * どの硬貨でお釣りを返すかを取得するテスト(異常系)。
     */
    @Test
    public void testGetChangeMoneyAbnormal() {
        VendingMachine vendingMachine = new VendingMachine();

        Map<Integer, Integer> changeMoneyMap = target.getChangeMoneyForCoin(-100, vendingMachine);
        assertThat(changeMoneyMap, is(nullValue()));
    }

    /**
     * どの硬貨でお釣りを返すかを取得するテスト(お釣り40)。
     */
    @Test
    public void testGetChangeMoney40() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setCoin10Stock(10);
        vendingMachine.setCoin50Stock(10);
        vendingMachine.setCoin100Stock(10);
        vendingMachine.setCoin500Stock(10);

        Map<Integer, Integer> changeMoneyMap = target.getChangeMoneyForCoin(40, vendingMachine);
        assertThat(changeMoneyMap.get(500), is(0));
        assertThat(changeMoneyMap.get(100), is(0));
        assertThat(changeMoneyMap.get(50), is(0));
        assertThat(changeMoneyMap.get(10), is(4));
    }

    /**
     * どの硬貨でお釣りを返すかを取得するテスト(お釣り40)。
     */
    @Test
    public void testGetChangeMoney40No10Coin() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setCoin10Stock(0);
        vendingMachine.setCoin50Stock(10);
        vendingMachine.setCoin100Stock(10);
        vendingMachine.setCoin500Stock(10);

        Map<Integer, Integer> changeMoneyMap = target.getChangeMoneyForCoin(40, vendingMachine);
        assertThat(changeMoneyMap, is(nullValue()));

    }

    /**
     * どの硬貨でお釣りを返すかを取得するテスト(お釣り50)。
     */
    @Test
    public void testGetChangeMoney50No50Coin() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setCoin10Stock(4);
        vendingMachine.setCoin50Stock(0);
        vendingMachine.setCoin100Stock(10);
        vendingMachine.setCoin500Stock(10);

        Map<Integer, Integer> changeMoneyMap = target.getChangeMoneyForCoin(50, vendingMachine);
        assertThat(changeMoneyMap, is(nullValue()));

    }

    /**
     * どの硬貨でお釣りを返すかを取得するテスト(お釣り80)。
     */
    @Test
    public void testGetChangeMoney80() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setCoin10Stock(10);
        vendingMachine.setCoin50Stock(10);
        vendingMachine.setCoin100Stock(10);
        vendingMachine.setCoin500Stock(10);

        Map<Integer, Integer> changeMoneyMap = target.getChangeMoneyForCoin(80, vendingMachine);
        assertThat(changeMoneyMap.get(500), is(0));
        assertThat(changeMoneyMap.get(100), is(0));
        assertThat(changeMoneyMap.get(50), is(1));
        assertThat(changeMoneyMap.get(10), is(3));

    }

    /**
     * どの硬貨でお釣りを返すかを取得するテスト(お釣り80)。
     */
    @Test
    public void testGetChangeMoney80No50Coin() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setCoin10Stock(8);
        vendingMachine.setCoin50Stock(0);
        vendingMachine.setCoin100Stock(10);
        vendingMachine.setCoin500Stock(10);

        Map<Integer, Integer> changeMoneyMap = target.getChangeMoneyForCoin(80, vendingMachine);
        assertThat(changeMoneyMap.get(500), is(0));
        assertThat(changeMoneyMap.get(100), is(0));
        assertThat(changeMoneyMap.get(50), is(0));
        assertThat(changeMoneyMap.get(10), is(8));

    }

    /**
     * どの硬貨でお釣りを返すかを取得するテスト(お釣り100)。
     */
    @Test
    public void testGetChangeMoney100() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setCoin10Stock(10);
        vendingMachine.setCoin50Stock(10);
        vendingMachine.setCoin100Stock(10);
        vendingMachine.setCoin500Stock(10);

        Map<Integer, Integer> changeMoneyMap = target.getChangeMoneyForCoin(100, vendingMachine);
        assertThat(changeMoneyMap.get(500), is(0));
        assertThat(changeMoneyMap.get(100), is(1));
        assertThat(changeMoneyMap.get(50), is(0));
        assertThat(changeMoneyMap.get(10), is(0));

    }

    /**
     * どの硬貨でお釣りを返すかを取得するテスト(お釣り100)。
     */
    @Test
    public void testGetChangeMoney100No100Coin() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setCoin10Stock(10);
        vendingMachine.setCoin50Stock(10);
        vendingMachine.setCoin100Stock(0);
        vendingMachine.setCoin500Stock(10);

        Map<Integer, Integer> changeMoneyMap = target.getChangeMoneyForCoin(100, vendingMachine);
        assertThat(changeMoneyMap.get(500), is(0));
        assertThat(changeMoneyMap.get(100), is(0));
        assertThat(changeMoneyMap.get(50), is(2));
        assertThat(changeMoneyMap.get(10), is(0));

    }

    /**
     * どの硬貨でお釣りを返すかを取得するテスト(お釣り100)。
     */
    @Test
    public void testGetChangeMoney100No100CoinOne50Coin() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setCoin10Stock(10);
        vendingMachine.setCoin50Stock(1);
        vendingMachine.setCoin100Stock(0);
        vendingMachine.setCoin500Stock(10);

        Map<Integer, Integer> changeMoneyMap = target.getChangeMoneyForCoin(100, vendingMachine);
        assertThat(changeMoneyMap.get(500), is(0));
        assertThat(changeMoneyMap.get(100), is(0));
        assertThat(changeMoneyMap.get(50), is(1));
        assertThat(changeMoneyMap.get(10), is(5));

    }

    /**
     * どの硬貨でお釣りを返すかを取得するテスト(お釣り100)。
     */
    @Test
    public void testGetChangeMoney100No100CoinNo50Coin() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setCoin10Stock(5);
        vendingMachine.setCoin50Stock(0);
        vendingMachine.setCoin100Stock(0);
        vendingMachine.setCoin500Stock(0);

        Map<Integer, Integer> changeMoneyMap = target.getChangeMoneyForCoin(100, vendingMachine);
        assertThat(changeMoneyMap, is(nullValue()));

    }

    /**
     * どの硬貨でお釣りを返すかを取得するテスト(お釣り500)。
     */
    @Test
    public void testGetChangeMoney500No500Coin() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setCoin10Stock(10);
        vendingMachine.setCoin50Stock(10);
        vendingMachine.setCoin100Stock(10);
        vendingMachine.setCoin500Stock(0);

        Map<Integer, Integer> changeMoneyMap = target.getChangeMoneyForCoin(500, vendingMachine);
        assertThat(changeMoneyMap.get(500), is(0));
        assertThat(changeMoneyMap.get(100), is(5));
        assertThat(changeMoneyMap.get(50), is(0));
        assertThat(changeMoneyMap.get(10), is(0));

    }

    /**
     * どの硬貨でお釣りを返すかを取得するテスト(お釣り500)。
     */
    @Test
    public void testGetChangeMoney500No500CoinNo100Coin() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setCoin10Stock(10);
        vendingMachine.setCoin50Stock(10);
        vendingMachine.setCoin100Stock(0);
        vendingMachine.setCoin500Stock(0);

        Map<Integer, Integer> changeMoneyMap = target.getChangeMoneyForCoin(500, vendingMachine);
        assertThat(changeMoneyMap.get(500), is(0));
        assertThat(changeMoneyMap.get(100), is(0));
        assertThat(changeMoneyMap.get(50), is(10));
        assertThat(changeMoneyMap.get(10), is(0));

    }

    /**
     * どの硬貨でお釣りを返すかを取得するテスト(お釣り500)。
     */
    @Test
    public void testGetChangeMoney500No500CoinNo100CoinNo50Coin() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setCoin10Stock(10);
        vendingMachine.setCoin50Stock(0);
        vendingMachine.setCoin100Stock(0);
        vendingMachine.setCoin500Stock(0);

        Map<Integer, Integer> changeMoneyMap = target.getChangeMoneyForCoin(500, vendingMachine);
        assertThat(changeMoneyMap, is(nullValue()));

    }

    /**
     * どの硬貨でお釣りを返すかを取得するテスト(お釣り500)。
     */
    @Test
    public void testGetChangeMoney500No500CoinOne100Coin() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setCoin10Stock(10);
        vendingMachine.setCoin50Stock(7);
        vendingMachine.setCoin100Stock(1);
        vendingMachine.setCoin500Stock(0);

        Map<Integer, Integer> changeMoneyMap = target.getChangeMoneyForCoin(500, vendingMachine);
        assertThat(changeMoneyMap.get(500), is(0));
        assertThat(changeMoneyMap.get(100), is(1));
        assertThat(changeMoneyMap.get(50), is(7));
        assertThat(changeMoneyMap.get(10), is(5));
    }

}
