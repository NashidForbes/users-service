package io.axoniq.usersservice.query.handler;

import io.axoniq.core.model.PaymentDetails;
import io.axoniq.core.model.User;
import io.axoniq.core.query.FetchUserPaymentDetailsQuery;
import org.springframework.stereotype.Component;
import org.axonframework.queryhandling.QueryHandler;

@Component
public class UserEventsHandler {

    @QueryHandler
    public User getUserPaymentDetails(FetchUserPaymentDetailsQuery query){

        PaymentDetails paymentDetails = PaymentDetails.builder()
                .cardNumber("123Card")
                .cvv("123")
                .name("NASH FORBES")
                .validUntilMonth(12)
                .validUntilYear(2030)
                .build();

        User userRest = User.builder()
                .firstName("Nash")
                .lastName("Forbes")
                .foodCartId(query.getFoodCartId())
                .paymentDetails(paymentDetails)
                .build();

        return userRest;

    }
}
