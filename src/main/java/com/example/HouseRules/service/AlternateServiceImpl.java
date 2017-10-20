package com.example.HouseRules.service;

import com.example.HouseRules.model.Alternate;
import com.example.HouseRules.repository.AlternateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlternateServiceImpl implements AlternateService {

    @Autowired
    AlternateRepository alternateRepository;

    @Transactional
    @Override
    public void update(Alternate alternate) { alternateRepository.save(alternate); }

}
