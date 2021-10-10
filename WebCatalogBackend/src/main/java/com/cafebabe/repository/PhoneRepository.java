package com.cafebabe.repository;

import com.cafebabe.entity.phone.Phone;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface PhoneRepository extends CrudRepository<Phone, BigInteger> {

    Optional<Phone> findByName(String name);

    @Query("select distinct p.marketLaunchYear from Phone p")
    List<Integer> findDistinctMarketLaunchYears();

    @Query("select distinct p.screenDiagonalInInches from Phone p")
    List<Float> findDistinctScreenDiagonals();

    @Query("select distinct p.horizontalScreenResolution, p.verticalScreenResolution from Phone p")
    List<List<Integer>> findDistinctScreenResolutions();

    @Query("select distinct p.screenRefreshRate from Phone p")
    List<Integer> findDistinctScreenRefreshRates();

    @Query("select distinct p.camerasAmount from Phone p")
    List<Integer> findDistinctCamerasAmountVariants();

    @Query("select distinct p.cameraInMp from Phone p")
    List<Float> findDistinctCamerasInMp();

    @Query("select distinct p.simCardsAmount from Phone p")
    List<Integer> findDistinctSimCardsAmountVariants();

    @Query("select distinct p.batteryCapacity from Phone p")
    List<Integer> findDistinctBatteryCapacities();

    @Query("select distinct p.frontCameraInMp from Phone p")
    List<Float> findDistinctFrontCameraVariants();

    @Query("select distinct p.length from Phone p")
    List<Float> findDistinctLengthVariants();

    @Query("select distinct p.width from Phone p")
    List<Float> findDistinctWidthVariants();

    @Query("select distinct p.thickness from Phone p")
    List<Float> findDistinctThicknessVariants();

    @Query("select distinct p.weight from Phone p")
    List<Float> findDistinctWeightVariants();

    @Query("select distinct p.ramSizeInGB from Phone p")
    List<Float> findDistinctRamVariants();

    @Query("select distinct p.romSizeInGB from Phone p")
    List<Float> findDistinctRomVariants();
}
