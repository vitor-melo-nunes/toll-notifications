package br.com.vitormelonunes.toll_notifications.adapters.outbound.integration.customer;

import br.com.vitormelonunes.toll_notifications.application.model.Customer;
import br.com.vitormelonunes.toll_notifications.application.ports.outbound.CustomerPortOutbound;
import org.springframework.stereotype.Component;

@Component
public class CustomerIntegartionAdapterOutbound implements CustomerPortOutbound {

    private final CustomerClient customerClient;

    public CustomerIntegartionAdapterOutbound(CustomerClient customerClient) {
        this.customerClient = customerClient;
    }

    @Override
    public Customer getCustomer(String licensePlateNumber) throws Exception {
        CustomerResponseBody customerResponseBody = this.customerClient.getCustomer(licensePlateNumber);
        return customerResponseBody.convertToDomain();
    }
}
