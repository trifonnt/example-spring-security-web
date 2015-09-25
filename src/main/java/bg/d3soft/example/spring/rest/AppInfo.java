package bg.d3soft.example.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bg.d3soft.example.spring.ApplicationProperties;


@RestController
@Configuration
@RequestMapping("/appinfo")
@EnableAutoConfiguration
public class AppInfo {

	@Autowired
	ApplicationProperties applicationProperties;


	@RequestMapping(method=RequestMethod.GET)
	public String get() {
		return applicationProperties.getName() + " " + applicationProperties.getVersion();
	}
}