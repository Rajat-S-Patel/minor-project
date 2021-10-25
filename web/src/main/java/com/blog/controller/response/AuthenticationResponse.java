package com.blog.controller.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class AuthenticationResponse {
    @Setter @Getter
    private String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

}
