package com.basespringboot.service;

import com.basespringboot.dto.FormDto;
import com.basespringboot.entity.Form;

public interface FormService {
    Form save(FormDto formDto);
}