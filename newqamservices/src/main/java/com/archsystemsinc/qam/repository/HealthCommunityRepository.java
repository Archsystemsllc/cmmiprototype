/**
 * 
 */
package com.archsystemsinc.qam.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.archsystemsinc.qam.model.HealthCommunity;

/**
 * @author Prakash T
 *
 */
public interface HealthCommunityRepository extends JpaRepository<HealthCommunity, Long>
{

	List<HealthCommunity> findByProcessedDateLessThanEqual(Date date);

}
