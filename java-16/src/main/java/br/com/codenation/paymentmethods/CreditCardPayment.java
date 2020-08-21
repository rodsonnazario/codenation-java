package br.com.codenation.paymentmethods;

public class CreditCardPayment implements PriceStrategy {

    private static final Double DISCOUNT = 0.98;

    @Override
    public Double calculate(Double price) {
        return price * DISCOUNT;
    }
}
