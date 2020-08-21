package br.com.codenation.paymentmethods;

public class DebitCardPayment implements PriceStrategy {

    private static final Double DISCOUNT = 0.95;

    @Override
    public Double calculate(Double price) {
        return price * DISCOUNT;
    }
}
