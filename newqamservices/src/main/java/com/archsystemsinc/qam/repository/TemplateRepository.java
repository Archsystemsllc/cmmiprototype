package com.archsystemsinc.qam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.archsystemsinc.qam.model.TemplateData;

/**
 * 
 */
public interface TemplateRepository extends JpaRepository<TemplateData, Long>{
}
