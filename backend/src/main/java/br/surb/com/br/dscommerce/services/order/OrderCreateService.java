package br.surb.com.br.dscommerce.services.order;

import br.surb.com.br.dscommerce.response.OrderDTO;
import br.surb.com.br.dscommerce.response.OrderUserDTO;
import br.surb.com.br.dscommerce.entities.Order;
import br.surb.com.br.dscommerce.entities.User;
import br.surb.com.br.dscommerce.repositories.OrderRepository;
import br.surb.com.br.dscommerce.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderCreateService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderCreateService(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public OrderDTO execute(OrderDTO dto) {
        Order entity = new Order();
        User user = userRepository.getReferenceById(dto.client().id());
//        User user = new User();
//        user.setId(dto.client().id());
        entity.setClient(user);
        entity = orderRepository.save(entity);
        OrderUserDTO orderUserDTO = new OrderUserDTO(user.getId(), user.getName(), user.getEmail(), user.getPhone());
        return new OrderDTO(entity.getId(), entity.getStatus(), entity.getMoment(), orderUserDTO);
    }
}
