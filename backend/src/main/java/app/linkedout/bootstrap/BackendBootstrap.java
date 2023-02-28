package app.linkedout.bootstrap;


import app.linkedout.models.Users;
import app.linkedout.repositories.AdminRepository;
import app.linkedout.repositories.UsersRepository;
import app.linkedout.services.AdminService;
import app.linkedout.services.UsersService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


/*
* Bootstrap Component
* Define entity instances here for testing purposes.
* Entities are created at the startup of application and dropped when the application terminates.
* */


@Component
public class BackendBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    // Define necessary services and repositories.
    private final UsersService usersService;
    private final UsersRepository usersRepository;
    private final AdminService adminService;
    private final AdminRepository adminRepository;

    public BackendBootstrap(UsersService usersService, UsersRepository usersRepository, AdminService adminService, AdminRepository adminRepository) {
        this.usersService = usersService;
        this.usersRepository = usersRepository;
        this.adminService = adminService;
        this.adminRepository = adminRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        // Define entity instances

        Users user1 = new Users();
        Users user2 = new Users();

        // Set entity properties

        user1.setName("Kawhi");
        user1.setSurname("Leonard");
        user1.setEmail("kleonard@gmail.com");
        user1.setJobTitle("Full-time NBA Basketball player @LAClippers");

        user2.setName("Paul");
        user2.setSurname("George");
        user2.setEmail("pgeorge@gmail.com");
        user2.setJobTitle("Full-time NBA Basketball player @LAClippers");

        // Save entity instances

        usersService.save(user1);
        usersService.save(user2);
    }
}
