package com.archsystemsinc.qam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.archsystemsinc.qam.model.BpciTemplateConfig;

public interface BpciConfigRepository extends JpaRepository< BpciTemplateConfig, Long>{

	public BpciTemplateConfig findByTemplateId(Long templateId);
}
