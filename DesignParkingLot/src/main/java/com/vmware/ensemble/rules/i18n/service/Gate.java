package com.vmware.ensemble.rules.i18n.service;

import com.vmware.ensemble.rules.i18n.model.Bill;
import com.vmware.ensemble.rules.i18n.model.Ticket;
import com.vmware.ensemble.rules.i18n.model.vehicle.Vehicle;

public interface Gate {
    Ticket enter(Vehicle vehicle);
    Bill exit(Ticket ticket);
}
