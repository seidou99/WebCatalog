package com.cafebabe.controller.phone;

import com.cafebabe.dto.PhoneFilterDto;
import com.cafebabe.entity.phone.Phone;
import com.cafebabe.service.interfaces.PhoneFilterService;
import com.cafebabe.service.interfaces.PhoneService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
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
    @Transactional
    protected PhoneFilterDto getPhoneFilter() {
        return phoneFilterService.loadPhoneFilterPossibleValues();
    }

    @GetMapping("api/phones")
    public Iterable<Phone> findAll() {
        return phoneService.findAll();
    }

//    @PostMapping("api/phones")
//    public void save(@RequestBody Phone phone) {
//        phoneService.save(phone);
//    }

    @PostMapping("api/phones")
    public void save(@ModelAttribute("mainImage") MultipartFile mainImage, @ModelAttribute("images") List<MultipartFile> images, @ModelAttribute("jsonBody") String jsonBody) throws IOException {
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().build();
        Phone phone = objectMapper.readValue(jsonBody, Phone.class);
        phoneService.save(phone, mainImage, images);
    }

    @PutMapping("api/phones")
    public void update(@ModelAttribute("newMainImage") MultipartFile newMainImage, @ModelAttribute("newImages") List<MultipartFile> newImages, @ModelAttribute("jsonBody") String jsonBody) throws IOException {
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().build();
        Phone phone = objectMapper.readValue(jsonBody, Phone.class);
        phoneService.update(phone, newMainImage, newImages);
    }

    @DeleteMapping("api/phones/{id}")
    public void delete(@PathVariable BigInteger id) throws IOException {
        phoneService.delete(id);
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
}
