package bg.d3soft.example.spring;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "application")
public class ApplicationProperties {

	private String name;
	private String version;

	
	public ApplicationProperties() {
		super();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
}