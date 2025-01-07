package br.com.rocketseat.sistema_de_cursos_front.service;

import br.com.rocketseat.sistema_de_cursos_front.dto.CourseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CourseService {

    private final RestTemplate restTemplate;
    @Value ( "${base-url}" )
    private String baseUrl;

    public CourseService ( RestTemplate restTemplate ) {
        this.restTemplate = restTemplate;
    }

    public CourseDTO[] list ( ) {
        return restTemplate.getForEntity ( baseUrl , CourseDTO[].class ).getBody ( );
    }

    public CourseDTO get ( String id ) {
        return restTemplate.getForEntity ( baseUrl + "/" + id , CourseDTO.class ).getBody ( );
    }

    public String add ( CourseDTO courseDTO ) {
        try {
            restTemplate.postForEntity ( baseUrl , courseDTO , Object.class );
        } catch (Exception ex) {
            return ex.getLocalizedMessage ( );
        }
        return null;
    }

    public String edit ( CourseDTO courseDTO ) {
        try {
            restTemplate.put ( baseUrl + "/" + courseDTO.id ( ) , courseDTO , Object.class );
        } catch (Exception ex) {
            return ex.getLocalizedMessage ( );
        }
        return null;
    }

    public void delete ( String id ) {
        restTemplate.delete ( baseUrl + "/" + id );
    }

    public void toggleActive ( String id ) {
        restTemplate.patchForObject ( baseUrl + "/" + id + "/active" , "" , Object.class );
    }
}
