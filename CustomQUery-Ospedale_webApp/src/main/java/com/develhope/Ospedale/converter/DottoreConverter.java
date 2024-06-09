package com.develhope.Ospedale.converter;

import com.develhope.Ospedale.dtos.DottoreDto;
import com.develhope.Ospedale.entities.Dottore;

public class DottoreConverter {
    public static Dottore dtoToEntity(DottoreDto dottoreDto) {
        // Definisce un metodo pubblico e statico che accetta un oggetto di tipo DottoreDto
        // e restituisce un oggetto di tipo Dottore
        Dottore dottore = new Dottore();
        // Crea un nuovo oggetto Dottore
        dottore.setId(dottoreDto.getId());
        // Imposta l'ID del nuovo oggetto Dottore utilizzando l'ID dell'oggetto DottoreDto
        dottore.setName(dottoreDto.getName());
        // Imposta il nome del nuovo oggetto Dottore utilizzando il nome dell'oggetto DottoreDto
        dottore.setSurname(dottoreDto.getSurname());
        // Imposta il cognome del nuovo oggetto Dottore utilizzando il cognome dell'oggetto DottoreDto
        dottore.setBirthDate(dottoreDto.getBirthDate());
        // Imposta la data di nascita del nuovo oggetto Dottore utilizzando la data di nascita dell'oggetto DottoreDto
        dottore.setFiscalCode(dottoreDto.getFiscalCode());
        // Imposta il codice fiscale del nuovo oggetto Dottore utilizzando il codice fiscale dell'oggetto DottoreDto
        dottore.setSpecialization(dottoreDto.getSpecialization());
        // Imposta la specializzazione del nuovo oggetto Dottore utilizzando la specializzazione dell'oggetto DottoreDto
        return dottore;
        // Restituisce l'oggetto Dottore popolato con i dati dell'oggetto DottoreDto
    }

    public static DottoreDto entityToDto(Dottore dottore) {
        // Definisce un metodo pubblico e statico che accetta un oggetto di tipo Dottore
        // e restituisce un oggetto di tipo DottoreDto
        DottoreDto dottoreDto = new DottoreDto();
        // Crea un nuovo oggetto DottoreDto
        dottoreDto.setId(dottore.getId());
        // Imposta l'ID del nuovo oggetto DottoreDto utilizzando l'ID dell'oggetto Dottore
        dottoreDto.setName(dottore.getName());
        // Imposta il nome del nuovo oggetto DottoreDto utilizzando il nome dell'oggetto Dottore
        dottoreDto.setSurname(dottore.getSurname());
        // Imposta il cognome del nuovo oggetto DottoreDto utilizzando il cognome dell'oggetto Dottore
        dottoreDto.setBirthDate(dottore.getBirthDate());
        // Imposta la data di nascita del nuovo oggetto DottoreDto utilizzando la data di nascita dell'oggetto Dottore
        dottoreDto.setFiscalCode(dottore.getFiscalCode());
        // Imposta il codice fiscale del nuovo oggetto DottoreDto utilizzando il codice fiscale dell'oggetto Dottore
        dottoreDto.setSpecialization(dottore.getSpecialization());
        // Imposta la specializzazione del nuovo oggetto DottoreDto utilizzando la specializzazione dell'oggetto Dottore
        dottoreDto.setLastUpdate(dottore.getLastUpdate());
        // Imposta l'ultima data di aggiornamento del nuovo oggetto DottoreDto utilizzando l'ultima data di aggiornamento dell'oggetto Dottore
        return dottoreDto;
        // Restituisce l'oggetto DottoreDto popolato con i dati dell'oggetto Dottore
    }
}

