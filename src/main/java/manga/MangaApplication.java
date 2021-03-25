package manga;

import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import manga.model.Actualiter;
import manga.model.Role;
import manga.repository.ActualiterRepository;
import manga.repository.RoleRepository;

@SpringBootApplication
public class MangaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MangaApplication.class, args);
		System.out.println("bismark");
	}
	
	@Autowired
	private ActualiterRepository actualiterRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Bean
	CommandLineRunner run() {
		return args -> {
			
			GregorianCalendar calandar = new GregorianCalendar(2017, 4, 21);
			Date date = calandar.getTime();
			
			Actualiter actualiter = new Actualiter("Tres bon manga", date);
			actualiterRepository.save(actualiter);
			
			Role user = new Role(Role.USER);
			Role admin = new Role(Role.ADMIN);
			roleRepository.save(user);
			roleRepository.save(admin);
			
			
			
		 };
	}

}
