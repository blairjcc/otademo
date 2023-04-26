package edu.sunyjcc.otademo.domain;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportTicketRepository extends CrudRepository<SupportTickets, Long>{
}




