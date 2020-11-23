package org.nr.tour.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 景区门票订单游客
 *
 * @author Wujun
 */
@Entity
@Table(name = "ticket_order_visitor")
public class TicketOrderVisitor extends BaseOrderVisitor {
}
