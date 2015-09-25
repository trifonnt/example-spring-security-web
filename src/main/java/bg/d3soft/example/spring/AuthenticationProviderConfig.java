package bg.d3soft.example.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

@Configuration
public class AuthenticationProviderConfig {

	@Bean(name = "applicationProperties")
	public ApplicationProperties getAppProperties() {
		return new ApplicationProperties();
	}

	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
/*
		String envVar = System.getenv("OPENSHIFT_ENV_VAR");

		<database> is MONGODB, MYSQL, or POSTGRESQL

		OPENSHIFT_<database>_DB_HOST
		OPENSHIFT_<database>_DB_PORT
		OPENSHIFT_<database>_DB_USERNAME
		OPENSHIFT_<database>_DB_PASSWORD
		OPENSHIFT_<database>_DB_URL
*/
		return getMySqlDS();
	}

	private DriverManagerDataSource getMySqlDS() {
		String dbHost = System.getenv("OPENSHIFT_MYSQL_DB_HOST") == null ? "localhost" : System.getenv("OPENSHIFT_MYSQL_DB_HOST");
		String dbPort = System.getenv("OPENSHIFT_MYSQL_DB_PORT") == null ? "3306" : System.getenv("OPENSHIFT_MYSQL_DB_PORT");
		String username = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME") == null ? "userexample" : System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
		String password = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD") == null ? "userexample" : System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
		String database = System.getenv("OPENSHIFT_APP_NAME") == null ? "userexample" : System.getenv("OPENSHIFT_APP_NAME");

		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://"+dbHost+":"+dbPort+"/"+database);
		driverManagerDataSource.setUsername( username );
		driverManagerDataSource.setPassword( password );
		return driverManagerDataSource;		
	}
	@SuppressWarnings("unused")
	private DriverManagerDataSource getPostrgeSqlDS() {
		String dbHost   = System.getenv("OPENSHIFT_POSTGRESQL_DB_HOST") == null ? "localhost" : System.getenv("OPENSHIFT_POSTGRESQL_DB_HOST");
		String dbPort   = System.getenv("OPENSHIFT_POSTGRESQL_DB_PORT")      == null ? "5432" : System.getenv("OPENSHIFT_POSTGRESQL_DB_PORT");
		String username = System.getenv("OPENSHIFT_POSTGRESQL_DB_USERNAME")  == null ? "userexample" : System.getenv("OPENSHIFT_POSTGRESQL_DB_USERNAME");
		String password = System.getenv("OPENSHIFT_POSTGRESQL_DB_PASSWORD")  == null ? "userexample" : System.getenv("OPENSHIFT_POSTGRESQL_DB_PASSWORD");
		String database = System.getenv("OPENSHIFT_APP_NAME") == null ? "userexample" : System.getenv("OPENSHIFT_APP_NAME");

		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
		driverManagerDataSource.setUrl("jdbc:postgresql://"+dbHost+":"+dbPort+"/"+database);
		driverManagerDataSource.setUsername( username );
		driverManagerDataSource.setPassword( password );
		return driverManagerDataSource;		
	}
	@SuppressWarnings("unused")
	private DriverManagerDataSource getMongoDS() {
		String dbHost   = System.getenv("OPENSHIFT_MONGODB_DB_HOST") == null ? "localhost" : System.getenv("OPENSHIFT_MONGODB_DB_HOST");
		String dbPort   = System.getenv("OPENSHIFT_MONGODB_DB_PORT")      == null ? "????" : System.getenv("OPENSHIFT_MONGODB_DB_PORT"); //TODO
		String username = System.getenv("OPENSHIFT_MONGODB_DB_USERNAME")  == null ? "userexample" : System.getenv("OPENSHIFT_MONGODB_DB_USERNAME");
		String password = System.getenv("OPENSHIFT_MONGODB_DB_PASSWORD")  == null ? "userexample" : System.getenv("OPENSHIFT_MONGODB_DB_PASSWORD");
		String database = System.getenv("OPENSHIFT_APP_NAME") == null ? "userexample" : System.getenv("OPENSHIFT_APP_NAME");

		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("???"); // TODO
		driverManagerDataSource.setUrl("jdbc:???://"+dbHost+":"+dbPort+"/"+database); //TODO
		driverManagerDataSource.setUsername( username );
		driverManagerDataSource.setPassword( password );
		return driverManagerDataSource;		
	}

	@Bean(name = "userDetailsService")
	public UserDetailsService userDetailsService() {
		JdbcDaoImpl jdbcImpl = new JdbcDaoImpl();
		jdbcImpl.setDataSource(dataSource());
		jdbcImpl.setUsersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username=?");
		jdbcImpl.setAuthoritiesByUsernameQuery("SELECT usr.username, roles.role FROM user_roles roles, users usr WHERE usr.username=? and roles.username=usr.username");
		return jdbcImpl;
	}
}
