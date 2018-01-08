package com.archsystemsinc.qam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TemplateConfig {
	public JpaRepository findByTemplateId(Long templateId);
}
