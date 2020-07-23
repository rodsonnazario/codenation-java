package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.reflect.Field;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {
    @Override
    public BigDecimal somar(Object object) {
        BigDecimal resultado = BigDecimal.ZERO;
        Field[] fields = object.getClass().getDeclaredFields();
        for(Field field: fields) {
            if(field.getType().isAssignableFrom(BigDecimal.class) && field.getDeclaredAnnotation(Somar.class) != null) {
                field.setAccessible(true);
                try {
                    resultado = resultado.add((BigDecimal) field.get(object));
                } catch (IllegalAccessException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
        return resultado;
    }

    @Override
    public BigDecimal subtrair(Object object) {
        BigDecimal resultado = BigDecimal.ZERO;
        Field[] fields = object.getClass().getDeclaredFields();
        for(Field field: fields) {
            if(field.getType().isAssignableFrom(BigDecimal.class) && field.getDeclaredAnnotation(Subtrair.class) != null) {
                field.setAccessible(true);
                try {
                    resultado = resultado.add((BigDecimal) field.get(object));
                } catch (IllegalAccessException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
        return resultado;
    }

    @Override
    public BigDecimal totalizar(Object object) {
        return somar(object).subtract(subtrair(object));
    }
}
