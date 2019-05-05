package airbnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a menu of dishes with prices on it, you have certain amount of money. You want to use all
 * of the money to buy different dishes. What are the combinations you could have?
 *
 * 本质是combination sum，但要注意价格为double，不能直接用 == 比较
 * 1. 转成cents，即全部乘以100，这样可以作为int处理
 * 2. 设定精度epsilon，两个数相差小于epsilon就认为是相等
 */

public class MenuOrder {
    public List<List<Double>> getCombos(double[] prices, double target) {
        List<List<Double>> res = new ArrayList<>();
        if (prices == null || prices.length == 0 || target <= 0) {
            return res;
        }

        int centsTarget = (int)Math.round(target * 100);
        Arrays.sort(prices);
        int[] centsPrices = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            centsPrices[i] = (int)Math.round(prices[i] * 100);
        }

        search(res, centsPrices, 0, centsTarget, new ArrayList<>(), prices);
        return res;
    }

    private void search(List<List<Double>> res, int[] centsPrices, int start, int centsTarget,
                        List<Double> curCombo, double[] prices) {
        if (centsTarget == 0) {
            res.add(new ArrayList<>(curCombo));
            return;
        }

        for (int i = start; i < centsPrices.length; i++) {
            if (i > start && centsPrices[i] == centsPrices[i - 1]) {
                continue;
            }
            if (centsPrices[i] > centsTarget) {
                break;
            }
            curCombo.add(prices[i]);
            search(res, centsPrices, i + 1, centsTarget - centsPrices[i], curCombo, prices);
            curCombo.remove(curCombo.size() - 1);
        }
    }
}
