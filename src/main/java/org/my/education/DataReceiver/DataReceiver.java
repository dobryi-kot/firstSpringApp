package org.my.education.DataReceiver;

import org.my.education.Domain.Client;
import org.my.education.util.Settings;

import java.util.ArrayList;

public interface DataReceiver {
    boolean loadData(ArrayList<Client> clients, Settings settings);
}

