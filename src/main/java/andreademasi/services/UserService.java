package andreademasi.services;

import andreademasi.entities.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

@Service
public class UserService {
    private List<User> authors = new ArrayList<>();

    //GET authors
    public List<User> getAllAuthors() {
        return this.authors;
    }

    //POST crea un nuovo autore
    public User save(User user) {
        Random rndm = new Random();
        user.setId(rndm.nextInt(1, 100));
        this.authors.add(user);
        return user;
    }

    //GET author by id

    public User findAuthorById(long id) {
        User foundUser = null;
        for (User user : this.authors) {
            if (user.getId() == id) {
                foundUser = user;
            }
        }
        return foundUser;
    }

    //PUT modifica dello specifico autore
    public User findByIdAndUpdate(long id, User user) {
        User foundUser = this.findAuthorById(id);
        foundUser.setId(id);
        foundUser.setName(user.getName());
        foundUser.setSurname(user.getSurname());
        foundUser.setEmail(user.getEmail());
        foundUser.setBirthDate(user.getBirthDate());
        foundUser.setAvatar(user.getAvatar());
        return foundUser;
    }

    //DELETE dell'author
    public void findByIdAndDelete(long id) {
        ListIterator<User> iterator = this.authors.listIterator();

        while (iterator.hasNext()) {
            User current = iterator.next();
            if (current.getId() == id) {
                iterator.remove();
            }
        }
    }


}
