package br.surb.com.br.dscommerce.shared.exeptions.service;

public class ServiceDataIntegrityViolationException extends RuntimeException {
    public ServiceDataIntegrityViolationException(String msg){
        super(msg);
    }
}
