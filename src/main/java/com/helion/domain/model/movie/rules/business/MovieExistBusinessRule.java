package com.helion.domain.model.movie.rules.business;

import com.helion.domain.model.GenericValidationRule;
import com.helion.domain.model.movie.exceptions.MovieAlreadyExistException;
import com.helion.domain.ports.output.MovieRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MovieExistBusinessRule implements GenericValidationRule<String> {

    private final MovieRepositoryPort movieRepositoryPort;


    @Override
    public void validate(String title) {

        if(movieRepositoryPort.existsByTitle(title)){
            throw new MovieAlreadyExistException();
        }

    }
}
