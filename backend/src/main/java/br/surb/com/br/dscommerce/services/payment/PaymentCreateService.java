package br.surb.com.br.dscommerce.services.payment;

import br.surb.com.br.dscommerce.dto.PaymentDTO;
import br.surb.com.br.dscommerce.entities.Order;
import br.surb.com.br.dscommerce.entities.Payment;
import br.surb.com.br.dscommerce.repositories.OrderRepository;
import br.surb.com.br.dscommerce.repositories.PaymentRepository;
import br.surb.com.br.dscommerce.shared.constants.ConstantException;
import br.surb.com.br.dscommerce.shared.exeptions.resource.ResourceNotFondExecption;
import br.surb.com.br.dscommerce.shared.exeptions.service.ServiceDataIntegrityViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentCreateService {
    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    public PaymentCreateService(PaymentRepository paymentRepository, OrderRepository orderRepository) {
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }

    @Transactional
    public PaymentDTO execute(PaymentDTO dto) {
        if (!orderRepository.existsById(dto.orderId()))
            throw new ResourceNotFondExecption(ConstantException.ENTITY_NOT_FOUND);

        try {
            Payment entity = new Payment();
            Order order = orderRepository.getReferenceById(dto.orderId());
            order.setId(dto.orderId());
            entity.setOrder(order);
            entity = paymentRepository.save(entity);
            return new PaymentDTO(entity.getId(), entity.getMoment(), entity.getOrder().getId());
        } catch (DataIntegrityViolationException e) {
            throw new ServiceDataIntegrityViolationException(ConstantException.DATA_INTEGRITY_VIOLATION);
        }

    }
}
