package com.sebastianttr.dinamico.models

import com.fasterxml.jackson.annotation.JsonProperty

data class User(
    @JsonProperty("name") val name: String,
    @JsonProperty("email") val email: String,
    @JsonProperty("password") val password: String
)
