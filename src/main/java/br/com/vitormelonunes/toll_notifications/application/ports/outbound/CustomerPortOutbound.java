package br.com.vitormelonunes.toll_notifications.application.ports.outbound;

import br.com.vitormelonunes.toll_notifications.application.model.Customer;

public interface CustomerPortOutbound {
    Customer getCustomer(String licensePlateNumber) throws Exception;
}
