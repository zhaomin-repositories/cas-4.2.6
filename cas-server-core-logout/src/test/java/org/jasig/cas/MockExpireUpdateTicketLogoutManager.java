package org.jasig.cas;

import java.util.List;

import org.jasig.cas.logout.LogoutManager;
import org.jasig.cas.logout.LogoutRequest;
import org.jasig.cas.ticket.TicketGrantingTicket;

/**
 * This logout manager only marks the ticket as expired and update it in the {@link MockOnlyOneTicketRegistry}.
 * 
 * @author Jerome Leleu
 * @since 4.0.0
 */
public final class MockExpireUpdateTicketLogoutManager implements LogoutManager {

    private final MockOnlyOneTicketRegistry registry;
    
    public MockExpireUpdateTicketLogoutManager(final MockOnlyOneTicketRegistry ticketRegistry) {
        this.registry = ticketRegistry;
    }

    @Override
    public List<LogoutRequest> performLogout(final TicketGrantingTicket ticket) {
        ticket.markTicketExpired();
        registry.updateTicket(ticket);
        return null;
    }

    @Override
    public String createFrontChannelLogoutMessage(final LogoutRequest logoutRequest) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
