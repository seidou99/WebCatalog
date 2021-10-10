package com.cafebabe;

import com.cafebabe.entity.OperationSystem;
import com.cafebabe.entity.OperationSystemType;
import com.cafebabe.entity.OperationSystemWithVersion;

import java.util.Arrays;
import java.util.List;

public interface OperationSystems {
    OperationSystem ANDROID = new OperationSystem("Android", OperationSystemType.MOBILE);
    List<OperationSystem> ALL_OPERATION_SYSTEMS = Arrays.asList(ANDROID);

    OperationSystemWithVersion ANDROID_ELEVEN = new OperationSystemWithVersion("11", ANDROID), ANDROID_TEN_DOT_ZERO = new OperationSystemWithVersion("10.0", ANDROID), ANDROID_NINE_DOT_ZERO_PIE = new OperationSystemWithVersion("9.0 Pie", ANDROID);
    List<OperationSystemWithVersion> ALL_OPERATION_SYSTEMS_WITH_VERSIONS = Arrays.asList(ANDROID_ELEVEN, ANDROID_TEN_DOT_ZERO, ANDROID_NINE_DOT_ZERO_PIE);
}
