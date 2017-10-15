package org.my.education.DataWriter;

import org.my.education.Domain.Client;
import org.my.education.util.Settings;

import java.util.ArrayList;

public interface DataWriter {
    boolean uploadData(ArrayList<Client> clients, Settings settings);
}
