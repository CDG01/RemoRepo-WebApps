package com.develhope.Ospedale.services;

import com.develhope.Ospedale.converter.DottoreConverter;
import com.develhope.Ospedale.dtos.DottoreDto;
import com.develhope.Ospedale.entities.Dottore;
import com.develhope.Ospedale.repositories.DottoreRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DottoreService {
    @Autowired
    private DottoreRepo dottoreRepo;

    public DottoreDto createDottore(DottoreDto dottoreDto){

        Dottore dottore = DottoreConverter.dtoToEntity(dottoreDto);

        Date date = new Date();
        dottore.setInsertDate(date);
        dottore.setLastUpdate(date);
        dottore.setDeleted(false);

        Dottore dottoreSaved = dottoreRepo.save(dottore);
        return DottoreConverter.entityToDto(dottoreSaved);
    }

    public List<DottoreDto> getAllDottore(){
        List<Dottore> dottoreList =dottoreRepo.jdqlDottoreByDeleted(false);
        List<DottoreDto> dottoreDtoList = new ArrayList<>();
        for ( Dottore dottore : dottoreList){

            dottoreDtoList.add(DottoreConverter.entityToDto(dottore));
        }
        return dottoreDtoList;
    }
    public DottoreDto findById(Long id) {
        Dottore dottore = dottoreRepo.findByIdAndDeleted(id, false).orElse(null);
        if (dottore != null) {
            return DottoreConverter.entityToDto(dottore);
        }
      return null;
    }

    public DottoreDto update(DottoreDto dottoreDto) {
        Dottore dottore = dottoreRepo.findById(dottoreDto.getId()).orElse(null);
        if (dottore != null && !dottore.isDeleted()) {

            dottore.setLastUpdate(new Date());
            dottore.setName(dottoreDto.getName());
            dottore.setSurname(dottoreDto.getSurname());
            dottore.setSpecialization(dottoreDto.getSpecialization());

            Dottore dottoreSaved = dottoreRepo.save(dottore);

            return DottoreConverter.entityToDto(dottoreSaved);
        }
        return null;
    }
    @Transactional
    public boolean delete(Long id) {
        return dottoreRepo.delete(id) == 1;
//        Dottore dottore = dottoreRepo.findById(id).orElse(null);
//        if (dottore != null && !dottore.isDeleted()) {
//            dottore.setDeleted(true);
//            dottoreRepo.save(dottore);
//            return true;
//        }return false;
    }

}
