/**
 *
 */
package od.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.Set;


/**
 * @author ggilbert
 *
 */
public class ContextMapping extends OpenDashboardModel {
    private static final long serialVersionUID = 1L;

    private String key;
    private String context;
    private Set<Dashboard> dashboards;
    private Date modified;

    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getContext() {
        return context;
    }
    public void setContext(String context) {
        this.context = context;
    }
    public Date getModified() {
        return modified;
    }
    public void setModified(Date modified) {
        this.modified = modified;
    }
    public Set<Dashboard> getDashboards() {
        return dashboards;
    }
    public void setDashboards(Set<Dashboard> dashboards) {
        this.dashboards = dashboards;
    }

    public Card findCard(String cardId) {
        Card card = null;

        if (dashboards != null && !dashboards.isEmpty()) {
            outer:for (Dashboard dashboard : dashboards) {
                LinkedList<Card> cards = dashboard.getCards();
                if (cards != null && !cards.isEmpty()) {
                    for (Card c : cards) {
                        if (c.getId() != null && c.getId().equals(cardId)) {
                            card = c;
                            break outer;
                        }
                    }
                }
            }
        }

        return card;
    }
}
