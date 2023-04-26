package edu.sunyjcc.otademo.controller;
import edu.sunyjcc.otademo.domaim.SupportTickets;
import edu.sunyjcc.otademo.domaim.SupportTicketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
    @RequestMapping
    public class HomePageController {
    @Resource(name="supportTicketServicImpl")
    SupportTicketService supportTicketService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
        public String viewPage(Model model) {
            return "home_page";
    }
    @RequestMapping(value = "/read", method = RequestMethod.POST)
    public String customers(HttpServletRequest req) {
        if(req.getParameter("project").equals("1")) {
            List tickets = supportTicketService.findSupportTickets();
            req.setAttribute("tickets", tickets);
        }
        else{
            req.setAttribute("error", "Please select a project");
        }
            return "home_page";
    }
    @RequestMapping(value = "/createPage", method = RequestMethod.GET)
    public String createPage(Model model) {
        model.addAttribute("ticket", new SupportTickets());
        model.addAttribute("pageTitle", "Create Ticket");
        model.addAttribute("formAction", "/create");
        return "create_page";
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("ticket") SupportTickets customer, Model model) {
        customer.setDate(new Date());
        supportTicketService.save(customer);
        List tickets = supportTicketService.findSupportTickets();
        model.addAttribute("tickets", tickets);
        return "home_page";
    }
    @RequestMapping(value = "/updatePage", method = RequestMethod.GET)
    public String updatePage(HttpServletRequest req) {
        Long ticketId = Long.valueOf(req.getParameter("id"));
        req.setAttribute("ticket", supportTicketService.findSupportTicket(ticketId));
        req.setAttribute("pageTitle", "Update Ticket");
        req.setAttribute("formAction", "/update");
        return "create_page";
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("ticket") SupportTickets customer, Model model) {
        customer.setDate(new Date());
        supportTicketService.update(customer);
        List tickets = supportTicketService.findSupportTickets();
        model.addAttribute("tickets", tickets);
        return "home_page";
    }
    @RequestMapping(value = "/deletePage", method = RequestMethod.GET)
    public String deletePage(HttpServletRequest req) {
        Long ticketId = Long.valueOf(req.getParameter("id"));
        req.setAttribute("ticket", supportTicketService.findSupportTicket(ticketId));
        req.setAttribute("pageTitle", "Delete Ticket");
        req.setAttribute("formAction", "/delete");
        return "create_page";
    }
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(HttpServletRequest req) {
            Long ticketId = Long.valueOf(req.getParameter("id"));
            SupportTickets customer = supportTicketService.findSupportTicket(ticketId).get();
        supportTicketService.delete(customer);
            List tickets = supportTicketService.findSupportTickets();
            req.setAttribute("tickets", tickets);
            return "home_page";
    }
}
