package com.cafebabe;

import com.cafebabe.entity.SimCardType;

import java.util.Arrays;
import java.util.List;

public interface SimCardTypes {

    SimCardType MICRO_SIM = new SimCardType("micro-SIM"), NANO_SIM = new SimCardType("nano-SIM"), E_SIM = new SimCardType("eSIM");

    List<SimCardType> ALL = Arrays.asList(MICRO_SIM, NANO_SIM, E_SIM);
}
