package com.challenge.demo.services;

import com.challenge.demo.models.PersonaModel;
import com.challenge.demo.models.ResponseModel;
import com.challenge.demo.repos.PersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Service
public class PersonaService {
    @Autowired
    PersonaRepo personaRepo;

    @PersistenceContext
    EntityManager entityManager;

    public ResponseEntity<ResponseModel> newPersona(PersonaModel persona){
        try{
            if(persona.getDni() != null){
                personaRepo.save(persona);
                return ResponseEntity.status(200).body(new ResponseModel("Persona insertada con exito",null,200));
            } else return ResponseEntity.status(500).body(new ResponseModel(null,"No se pudo insertar la persona. Ingrese el DNI",500));

        } catch (org.springframework.dao.DataIntegrityViolationException dive){
            return ResponseEntity.status(500).body(new ResponseModel(null,"No se pudo insertar la persona. Ya existe el DNI",500));
        } catch (Exception e){
            return ResponseEntity.status(501).body(new ResponseModel(null,e.getMessage(),501));
        }
    }

    @Transactional
    public ResponseEntity<ResponseModel> updatePersona(PersonaModel persona){
        try{
            if(persona.getDni() != null){
                PersonaModel obj = getPersonaByDNI(persona.getDni());
                if(obj != null){
                    Query query = entityManager.createNativeQuery("UPDATE persona SET nombre= ?1, apellido= ?2, es_empleado = ?3 WHERE dni = ?4");
                    query.setParameter(4,persona.getDni());
                    query.setParameter(1,persona.getNombre());
                    query.setParameter(2,persona.getApellido());
                    query.setParameter(3,persona.isEs_empleado());
                    query.executeUpdate();
                    entityManager.flush();
                    return ResponseEntity.status(200).body(new ResponseModel("Persona actualizada",null,200));
                } else return ResponseEntity.status(500).body(new ResponseModel(null,"Persona no encontrada",500));
            } else return ResponseEntity.status(500).body(new ResponseModel(null,"No se especifica el id",500));
        } catch (Exception e){
            return ResponseEntity.status(501).body(new ResponseModel(null,e.getMessage(),501));
        }

    }

    public PersonaModel getPersonaByDNI(Integer dni) {
        try{
            Query query = entityManager.createNativeQuery("SELECT * FROM persona WHERE dni = ?1",PersonaModel.class);
            query.setParameter(1,dni);
            PersonaModel obj = (PersonaModel) query.getSingleResult();
            return obj;

        } catch (Exception e) {
            return null;
        }

    }

    @Transactional
    public ResponseEntity<ResponseModel> deletePersonaByDNI(Integer dni){
        try{
            PersonaModel personaModel = getPersonaByDNI(dni);
            if(personaModel != null){
                Query query = entityManager.createNativeQuery("DELETE FROM persona WHERE dni = ?1");
                query.setParameter(1,dni);
                query.executeUpdate();
                entityManager.flush();
                return ResponseEntity.status(200).body(new ResponseModel("Persona eliminada con exito",null,200));
            } else{
                return ResponseEntity.status(500).body(new ResponseModel(null,"Persona no encontrada",200));
            }

        } catch (Exception e) {
            return ResponseEntity.status(501).body(new ResponseModel(null, e.getMessage(), 501));
        }

    }

}
