package jp.co.tis.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.tis.model.Coins;
import jp.co.tis.model.Goods;
import jp.co.tis.model.VendingMachine;

/**
 * 自動販売機Logicクラス。<br/> コントローラーに直接メソッド切り出しを行うと行数が膨れるため<br/>
 * 業務ロジック部分はロジッククラスに切り出す。<br/> JUnitテストをしやすくするための目的もある。
 *
 * @author Saito Takuma
 * @since 1.0
 */
public class VendingMachineLogic {

    /**
     * 自販機で認識可能なお金かどうかを判断する。
     *
     * @param insertMoney 投入したお金
     * @return {@code true} 認識可能 {@code false} 認識不可能
     */
    public boolean isValidMoney(int insertMoney) {
        if (insertMoney == Coins.COIN_1) {
            return false;
        }
        if (insertMoney == Coins.COIN_5) {
            return false;
        }
        if (insertMoney == Coins.BILL_2000) {
            return false;
        }
        if (insertMoney == Coins.BILL_5000) {
            return false;
        }
        if (insertMoney == Coins.BILL_10000) {
            return false;
        }
        return true;
    }

    /**
     * 商品名から商品情報を取得する。
     *
     * @param goodsName 取得したい商品名
     * @param vendingMachine 自動販売機
     * @return 商品情報
     */
    public Goods getGoodsInfo(String goodsName, VendingMachine vendingMachine) {
        Map<String, Goods> goodsInfoMap = vendingMachine.getGoodsInfoMap();
        Goods goods = goodsInfoMap.get(goodsName);

        return goods;
    }

    /**
     * 投入金額、在庫の点で、商品が購入できるかどうかを判断する。
     *
     * @param sumInsertMoney 投入金額
     * @param goods 購入したい商品情報
     * @return {@code true} 購入可能 {@code false} 購入不可能
     */
    public boolean isPurchasable(int sumInsertMoney, Goods goods) {
        if (goods.getStock() == 0) {
            return false;
        }
        if (sumInsertMoney < goods.getPrice()) {
            return false;
        }
        return true;
    }

    /**
     * 在庫があるドリンクのリストを取得する。
     *
     * @param vendingMachine 自動販売機
     * @return 在庫があるドリンクのリスト
     */
    public List<Goods> getPurchasableGoodsList(VendingMachine vendingMachine) {
        List<Goods> goodsList = new ArrayList<Goods>();
        Map<String, Goods> goodsInfoMap = vendingMachine.getGoodsInfoMap();

        for (String goodsName : goodsInfoMap.keySet()) {
            Goods goods = goodsInfoMap.get(goodsName);
            if (goods.getStock() > 0) {
                goodsList.add(goods);
            }
        }

        return goodsList;
    }

    /**
     * どの硬貨でお釣りを返すかを取得する。<br/>
     * 戻り値のMapの「key」には硬貨の値が設定してあり、「value」には硬貨の枚数が設定してある。<br/>
     * お釣りを返せない場合はnullを返却する。
     *
     * @param changeMoney お釣りの金額
     * @param vendingMachine 自動販売機
     * @return どの硬貨で何枚返すかのMap
     */
    public Map<Integer, Integer> getChangeMoneyForCoin(int changeMoney, VendingMachine vendingMachine) {
        if (changeMoney < 0) {
            return null;
        }
        Map<Integer, Integer> changeMoneyCoinMap = new HashMap<Integer, Integer>();
        changeMoneyCoinMap.put(10, 0);
        changeMoneyCoinMap.put(50, 0);
        changeMoneyCoinMap.put(100, 0);
        changeMoneyCoinMap.put(500, 0);
        int vendingMachine10CoinStock = vendingMachine.getCoin10Stock();
        int vendingMachine50CoinStock = vendingMachine.getCoin50Stock();
        int vendingMachine100CoinStock = vendingMachine.getCoin100Stock();
        int vendingMachine500CoinStock = vendingMachine.getCoin500Stock();

        // お釣りの金額に応じて硬貨の枚数を計算する
        int[] yenTypes = { 500, 100, 50, 10 };
        Map<Integer, Integer> numberOfCoins = new HashMap<Integer, Integer>();
        for (int yenType : yenTypes) {
            if (changeMoney < yenType) {
                numberOfCoins.put(yenType, 0);
                continue;
            }
            numberOfCoins.put(yenType, changeMoney / yenType);
            changeMoney = changeMoney % yenType;
        }

        // お釣りに使用する硬貨の枚数と硬貨のストックを比べて返却する硬貨を選択する
        int numberOf10Coin = numberOfCoins.get(10);
        int numberOf50Coin = numberOfCoins.get(50);
        int numberOf100Coin = numberOfCoins.get(100);
        int numberOf500Coin = numberOfCoins.get(500);

        // 500円
        if (vendingMachine500CoinStock < numberOf500Coin) {
            changeMoneyCoinMap.put(500, vendingMachine500CoinStock);
            int remainChangeMoney = (numberOf500Coin * 500) - (vendingMachine500CoinStock * 500);
            vendingMachine500CoinStock = 0;
            if (vendingMachine100CoinStock < remainChangeMoney / 100) {
                changeMoneyCoinMap.put(100, vendingMachine100CoinStock);
                remainChangeMoney = (numberOf500Coin * 500) - (vendingMachine100CoinStock * 100);
                vendingMachine100CoinStock = 0;
                if (vendingMachine50CoinStock < remainChangeMoney / 50) {
                    changeMoneyCoinMap.put(50, vendingMachine50CoinStock);
                    remainChangeMoney -= vendingMachine50CoinStock * 50;
                    vendingMachine50CoinStock = 0;
                    if (vendingMachine10CoinStock < remainChangeMoney / 10) {
                        return null;
                    } else {
                        changeMoneyCoinMap.put(10, remainChangeMoney / 10);
                        vendingMachine10CoinStock -= remainChangeMoney / 10;
                    }
                } else {
                    changeMoneyCoinMap.put(50, remainChangeMoney / 50);
                    vendingMachine50CoinStock -= remainChangeMoney / 50;
                }
            } else {
                changeMoneyCoinMap.put(100, numberOf500Coin * 5);
                vendingMachine100CoinStock -= numberOf500Coin * 5;
            }
        } else {
            changeMoneyCoinMap.put(500, numberOf500Coin);
        }

        // 100円
        if (vendingMachine100CoinStock < numberOf100Coin) {
            changeMoneyCoinMap.put(100, vendingMachine100CoinStock + changeMoneyCoinMap.get(100));
            int remainChangeMoney = (numberOf100Coin * 100) - (vendingMachine100CoinStock * 100);
            vendingMachine100CoinStock = 0;
            if (vendingMachine50CoinStock < remainChangeMoney / 50) {
                changeMoneyCoinMap.put(50, vendingMachine50CoinStock + changeMoneyCoinMap.get(50));
                remainChangeMoney = (numberOf100Coin * 100) - (vendingMachine50CoinStock * 50);
                vendingMachine50CoinStock = 0;
                if (vendingMachine10CoinStock < remainChangeMoney / 10) {
                    return null;
                } else {
                    changeMoneyCoinMap.put(10, (remainChangeMoney / 10) + changeMoneyCoinMap.get(10));
                    vendingMachine10CoinStock -= remainChangeMoney / 10;
                }
            } else {
                changeMoneyCoinMap.put(50, (numberOf100Coin * 2) + changeMoneyCoinMap.get(50));
                vendingMachine50CoinStock -= numberOf100Coin * 2;
            }
        } else {
            changeMoneyCoinMap.put(100, numberOf100Coin + +changeMoneyCoinMap.get(100));
        }

        // 50円
        if (vendingMachine50CoinStock < numberOf50Coin) {
            if (vendingMachine10CoinStock < numberOf50Coin * 5) {
                return null;
            } else {
                changeMoneyCoinMap.put(10, (numberOf50Coin * 5) + changeMoneyCoinMap.get(10));
                vendingMachine10CoinStock -= numberOf50Coin * 5;
            }
        } else {
            changeMoneyCoinMap.put(50, numberOf50Coin + changeMoneyCoinMap.get(50));
        }

        // 10円
        if (vendingMachine10CoinStock < numberOf10Coin) {
            return null;
        } else {
            changeMoneyCoinMap.put(10, numberOf10Coin + changeMoneyCoinMap.get(10));
        }

        return changeMoneyCoinMap;

    }
}
