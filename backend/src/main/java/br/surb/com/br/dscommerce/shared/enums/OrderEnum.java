package br.surb.com.br.dscommerce.shared.enums;

import lombok.Getter;

@Getter
public enum OrderEnum {
    WAITING_PAYMENT,
    PAID,
    SHIPPED,
    DELIVERED,
    CANCELED
}
