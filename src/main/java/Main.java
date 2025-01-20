import entities.SanPham;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("mariadb")
                .createEntityManager();

        EntityTransaction tr = em.getTransaction();

//        Faker faker = new Faker();
//
//        for (int i = 0; i < 10; i++) {
//            Group group = new Group();
//            User user = new User();
//
//            String gName = faker.company().name();
//            String us = faker.name().username();
//            String pw = faker.internet().password();
//            String email = faker.internet().emailAddress();
//
//            group.setName(gName);
//
//            user.setUsername(us);
//            user.setPassword(pw);
//            user.setEmail(email);
//
//            user.setGroups(new HashSet<>(List.of(group)));
//
//            tr.begin();
//
//            em.persist(group);
//            em.persist(user);
//
//            tr.commit();

//        }
    }
}
