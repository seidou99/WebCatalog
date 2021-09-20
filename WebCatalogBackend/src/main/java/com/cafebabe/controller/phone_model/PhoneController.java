package com.cafebabe.controller.phone_model;

import com.cafebabe.dto.PhoneFilterDto;
import com.cafebabe.entity.Phone;
import com.cafebabe.service.interfaces.PhoneFilterService;
import com.cafebabe.service.interfaces.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
public class PhoneController {

    @Autowired
    protected PhoneService phoneService;

    @Autowired
    protected PhoneFilterService phoneFilterService;

    @GetMapping("/api/phones/filter")
    protected PhoneFilterDto getPhoneFilter() {
        return phoneFilterService.loadPhoneFilterPossibleValues();
    }

    @GetMapping("api/phones")
    public Iterable<Phone> findAll() {
        return phoneService.findAll();
    }

    @PostMapping("api/phones")
    public void save(@RequestBody Phone phone) {
        phoneService.save(phone);
    }

    @GetMapping("api/phones/{id}")
    public Phone findById(@PathVariable BigInteger id) {
        Optional<Phone> phoneModel = phoneService.findById(id);
        return phoneModel.orElse(null);
    }

    @PostMapping("api/phones/filtered")
    public List<Phone> findFilteredPhoneModels(@RequestBody PhoneFilterDto filterDto, @RequestParam int pageIndex, @RequestParam int pageSize) {
        return phoneService.findFilteredPhones(filterDto, pageIndex, pageSize);
    }

    @PostMapping("api/phones/filtered/count")
    public Long findFilteredPhoneModelsCount(@RequestBody PhoneFilterDto filterDto) {
        return phoneService.findFilteredPhonesCount(filterDto);
    }

    //    @PostMapping(value = "api/phones/models", consumes = {MediaType.ALL_VALUE})
//    public void save(@ModelAttribute(name = "images") List<MultipartFile> images, @ModelAttribute(name = "phoneModelJson") String phoneModelJson) throws IOException {
//        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().build();
//        PhoneModel phoneModel = objectMapper.readValue(phoneModelJson, PhoneModel.class);
//        phoneModelService.save(phoneModel, images);
//    }
}
