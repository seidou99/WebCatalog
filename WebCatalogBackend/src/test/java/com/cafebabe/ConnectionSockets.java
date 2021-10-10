package com.cafebabe;

import com.cafebabe.entity.ConnectionSocket;

import java.util.Arrays;
import java.util.List;

public interface ConnectionSockets {

    ConnectionSocket LIGHTNING = new ConnectionSocket("lightning"), MICRO_USB = new ConnectionSocket("microUSB"), USB_TYPE_C = new ConnectionSocket("USB Type-C");

    List<ConnectionSocket> ALL = Arrays.asList(LIGHTNING, MICRO_USB, USB_TYPE_C);
}
