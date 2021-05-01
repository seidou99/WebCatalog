package com.cafebabe.repository.mobilephone;

import com.cafebabe.entity.mobilephone.PhoneModel;
import com.cafebabe.repository.BaseDataObjectRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneModelRepository extends BaseDataObjectRepository<PhoneModel> {

    @Query("select distinct phoneModel.marketLaunchYear from PhoneModel phoneModel")
    List<Integer> findDistinctMarketLaunchYears();

    @Query("select distinct phoneModel.screenDiagonalInInches from PhoneModel phoneModel")
    List<Double> findDistinctScreenDiagonals();

    @Query("select distinct p.horizontalScreenResolution, p.verticalScreenResolution from PhoneModel p")
    List<List<Integer>> findDistinctScreenResolutions();

    @Query("select distinct p.screenRefreshRate from PhoneModel p")
    List<Integer> findDistinctScreenRefreshRates();

    @Query("select distinct p.camerasAmount from PhoneModel p")
    List<Integer> findDistinctCamerasAmountVariants();

    @Query("select distinct p.cameraInMp from PhoneModel p")
    List<Float> findDistinctCamerasInMp();

    @Query("select distinct p.simCardsAmount from PhoneModel p")
    List<Integer> findDistinctSimCardsAmountVariants();

    @Query("select distinct p.batteryCapacity from PhoneModel p")
    List<Integer> findDistinctBatteryCapacities();

    @Query("select distinct p.frontCamera from PhoneModel p")
    List<Float> findDistinctFrontCameraVariants();

    @Query("select distinct p.length from PhoneModel p")
    List<Integer> findDistinctLengthVariants();

    @Query("select distinct p.width from PhoneModel p")
    List<Integer> findDistinctWidthVariants();

    @Query("select distinct p.thickness from PhoneModel p")
    List<Integer> findDistinctThicknessVariants();

    @Query("select distinct p.weight from PhoneModel p")
    List<Integer> findDistinctWeightVariants();

}
