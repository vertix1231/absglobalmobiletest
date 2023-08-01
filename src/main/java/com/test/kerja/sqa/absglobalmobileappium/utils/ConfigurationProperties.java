package com.test.kerja.sqa.absglobalmobileappium.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import lombok.Getter;

@Getter
@Component
@PropertySource("framework.properties")
public class ConfigurationProperties {
	@Value("${mainContactTitle}")
	private String mainContactTitle;
	@Value("${selectedContactTitleTitle}")
	private String selectedContactTitleTitle;
}
