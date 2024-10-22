package com.relgs.userapi;

import com.github.javafaker.Faker;
import com.relgs.userapi.dto.UserDTO;

import java.time.ZoneId;

public class Factories {

    private static final Faker faker = new Faker();

    private Factories() {
        throw new IllegalStateException("Utility class");
    }

    public static UserDTO generateUserDTO() {
        return new UserDTO(
                faker.leagueOfLegends().champion(),
                faker.idNumber().valid(),
                faker.address().fullAddress(),
                faker.internet().emailAddress(),
                faker.phoneNumber().cellPhone(),
                faker.date().past(365, java.util.concurrent.TimeUnit.DAYS)
                        .toInstant().atZone(ZoneId.of("America/Sao_Paulo")).toLocalDateTime()
        );
    }

}
