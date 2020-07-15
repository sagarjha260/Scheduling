package Scheduling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@RestController
@EnableScheduling
public class SpringBootJdbcController {
	
	@Autowired
	JdbcTemplate jdbc;
	
	@Scheduled(cron = "0 * * ? * *")
	@RequestMapping("/insert")
	public String index() {
		
		jdbc.execute("insert into Account(name, owner, country, Annual_Income) values('Jack','Sparrow', 'Ocean', 100000000)");
		return "Data inserted Successfully !!";
	}

}
