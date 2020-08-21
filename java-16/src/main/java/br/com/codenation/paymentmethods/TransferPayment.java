package br.com.codenation.paymentmethods;

public class TransferPayment implements PriceStrategy{

    private static final Double DISCOUNT = 0.92;

    @Override
    public Double calculate(Double price) {
        return price * DISCOUNT;
    }
}
