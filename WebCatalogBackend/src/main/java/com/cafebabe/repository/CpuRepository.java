package com.cafebabe.repository;

import com.cafebabe.entity.mobilephone.PhoneCpu;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CpuRepository extends BaseDataObjectRepository<PhoneCpu> {

    //    @Query("select distinct sum(block.coresAmount) from PhoneCpu cpu join CpuCoresBlock block group by cpu.id")
    @Query(nativeQuery = true,
            value = "select distinct sum(ccb.cores_amount) from phone_cpu\n" +
                    "join phone_cpu_cores_blocks pccb on phone_cpu.id = pccb.phone_cpu_id\n" +
                    "join cpu_cores_block ccb on ccb.id = pccb.cores_blocks_id\n" +
                    "group by phone_cpu.id;")
    List<Integer> findDistinctCoresAmountVariants();

    @Query(nativeQuery = true,
            value = "select distinct max(ccb.clock_speed_inmhz) from phone_cpu cpu\n" +
                    "join phone_cpu_cores_blocks pccb on cpu.id = pccb.phone_cpu_id\n" +
                    "join cpu_cores_block ccb on pccb.cores_blocks_id = ccb.id\n" +
                    "group by cpu.id")
    List<Integer> findDistinctCpuClockSpeedVariants();

    @Query("select distinct cpu.techprocessInNm from PhoneCpu cpu")
    List<Integer> findDistinctCpuTechprocessVariants();
}
