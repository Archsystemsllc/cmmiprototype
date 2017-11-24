/*package com.archsystemsinc.qam.restcontroller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.archsystemsinc.qam.model.CustomerDetails;
import com.archsystemsinc.qam.model.HealthDataTemplateConfig;

@RestController
@RequestMapping("map")
public class CustomerMapController {
	
	private static final Logger log = Logger.getLogger(FileUploadService.class);
	
	@RequestMapping(value = "/mapCustomerData", method = RequestMethod.POST)
	public CustomerDetails mapCustomerData(CustomerDetails data) {
		log.debug("--> createTemplate" + data);
		return healthCommunityDataService.createHealthTemplateConfig(data);
	}

}
*/