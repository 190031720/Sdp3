package com.customer.module;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("CustomerConfirmationTokenRepository")
public interface CustomerConfirmationTokenRepository extends CrudRepository<CustomerConfirmationToken, String>
{
	CustomerConfirmationToken findByConfirmationToken(String confirmationToken);

}
