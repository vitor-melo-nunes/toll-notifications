package br.com.vitormelonunes.toll_notifications.adapters.outbound.integration.customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-client", url = "http://localhost:9999")
public interface CustomerClient {
    @GetMapping("/customers/{licensePlateNumber}/")
    CustomerResponseBody getCustomer(@PathVariable("licensePlateNumber") String licensePlateNumber);
}