package br.com.fiap.postech.techchallenge.core.usecase.order;

import br.com.fiap.postech.techchallenge.core.domain.Combo;
import br.com.fiap.postech.techchallenge.core.domain.Customer;
import br.com.fiap.postech.techchallenge.core.domain.Order;
import br.com.fiap.postech.techchallenge.core.usecase.paymentorder.CreatePaymentOrderUseCase;
import br.com.fiap.postech.techchallenge.application.interfaces.repository.IAddonRepository;
import br.com.fiap.postech.techchallenge.application.interfaces.repository.ICustomerRepository;
import br.com.fiap.postech.techchallenge.application.interfaces.repository.IProductRepository;
import br.com.fiap.postech.techchallenge.application.interfaces.repository.IOrderRepository;
import br.com.fiap.postech.techchallenge.core.exception.EntityNotFoundException;
import br.com.fiap.postech.techchallenge.application.mapper.IOrderMapper;
import br.com.fiap.postech.techchallenge.application.dto.CreateComboDto;
import br.com.fiap.postech.techchallenge.application.dto.order.CreateOrderDto;
import br.com.fiap.postech.techchallenge.application.dto.order.OrderDto;
import org.springframework.stereotype.Service;


@Service
public class CreateOrderUseCase {

    private final IOrderRepository orderRepository;
    private final IProductRepository productRepository;
    private final IAddonRepository addonRepository;
    private final IOrderMapper orderMapper;
    private final ICustomerRepository customerRepository;
    private final CreatePaymentOrderUseCase createPaymentOrderUseCase;

    public CreateOrderUseCase(IOrderRepository orderRepository, IProductRepository productRepository, IAddonRepository addonRepository, IOrderMapper orderMapper, ICustomerRepository customerRepository, CreatePaymentOrderUseCase createPaymentOrderUseCase) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.addonRepository = addonRepository;
        this.orderMapper = orderMapper;
        this.customerRepository = customerRepository;
        this.createPaymentOrderUseCase = createPaymentOrderUseCase;
    }

    public OrderDto create(CreateOrderDto createOrderDto) throws EntityNotFoundException {
        Order order = new Order();
        for (CreateComboDto comboDto : createOrderDto.getCombos()){
            Combo combo = createCombo(comboDto);
            order.addCombo(combo);
        }

        addCustomerInOrder(order, createOrderDto);

        var orderSaved = orderRepository.save(order);
        createPaymentOrderUseCase.create(orderSaved);
        return orderMapper.toOrderDto(orderSaved);
    }

    private Combo createCombo(CreateComboDto comboDto) throws EntityNotFoundException {
        var product = productRepository.findById(comboDto.getProductId());
        Combo combo = new Combo(product);
        for(Long id : comboDto.getAddonsId()){
            combo.addAddon(addonRepository.findById(id));
        }
        return combo;
    }

    private void addCustomerInOrder(Order order, CreateOrderDto createOrderDto) throws EntityNotFoundException {
        Customer customer;
        try {
            customer = customerRepository.findById(createOrderDto.getCustomerId());
        } catch (EntityNotFoundException e){
            customer = customerRepository.save(new Customer());
        }

        order.setCustomer(customer);
    }
}
