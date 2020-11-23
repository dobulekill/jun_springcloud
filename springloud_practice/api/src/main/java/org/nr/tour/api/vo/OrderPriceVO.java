package org.nr.tour.api.vo;

/**
 * @author Wujun
 */
public class OrderPriceVO extends BaseVO {

    private Double price;

    private Double marketPrice;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }
}
