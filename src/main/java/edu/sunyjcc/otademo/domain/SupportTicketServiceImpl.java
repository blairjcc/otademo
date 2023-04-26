package edu.sunyjcc.otademo.domain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("supportTicketServicImpl")
public class SupportTicketServiceImpl implements SupportTicketService {

	@Autowired
	private SupportTicketRepository supportTicketRepository;
	@Override
	public List<SupportTickets> findSupportTickets() {
		return (List) supportTicketRepository.findAll();
	}
	@Override
	public Optional<SupportTickets> findSupportTicket(Long id) {
		return supportTicketRepository.findById(id);
	}
	@Override
	public void update(SupportTickets customer) {
		supportTicketRepository.save(customer);
	}
	@Override
	@Transactional
	public void save(SupportTickets customer) {
		supportTicketRepository.save(customer);
	}
	@Override
	@Transactional
	public void delete(SupportTickets customer) {
		supportTicketRepository.delete(customer);
	}
}
