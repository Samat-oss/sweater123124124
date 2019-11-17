package example.dog.demo.repo;



import example.dog.demo.domians.Message;
import org.springframework.data.repository.CrudRepository;



public interface MessageRepo extends CrudRepository<Message, Long> {
}
