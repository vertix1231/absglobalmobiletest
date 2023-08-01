package com.test.kerja.sqa.absglobalmobileappium.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// untuk menjadikan sebagai pusat context spring framework
@Configuration
@ComponentScan("com.test.kerja.sqa.absglobalmobileappium")
public class AutomationFrameworkConfiguration {
	public AutomationFrameworkConfiguration() {
		
	}
}
