package com.archsystemsinc.qam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.archsystemsinc.qam.model.EmailAddress;

/**
 */
public interface EmailAddressRepository extends JpaRepository<EmailAddress, Long>
{
	EmailAddress findByEmailId(String emailId);
}
