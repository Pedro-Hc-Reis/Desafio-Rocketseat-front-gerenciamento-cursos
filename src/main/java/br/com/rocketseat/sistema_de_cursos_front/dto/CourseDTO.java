package br.com.rocketseat.sistema_de_cursos_front.dto;

import java.time.LocalDateTime;

public record CourseDTO(Long id , String name , String teacher , String category , String active ,
                        LocalDateTime createdAt) {
    public boolean isIncomplete ( ) {
        return name == null || name.isBlank ( )
                || teacher == null || teacher.isBlank ( )
                || category == null || category.isBlank ( );
    }
}