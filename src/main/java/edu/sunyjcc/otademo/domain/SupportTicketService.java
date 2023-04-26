package edu.sunyjcc.otademo.domain;
import java.util.List;
import java.util.Optional;

public interface SupportTicketService {
	public List<SupportTickets> findSupportTickets();
	public void save(SupportTickets customer);
	public void delete(SupportTickets customer);
	public Optional<SupportTickets> findSupportTicket(Long id);
	void update(SupportTickets customer);
}
