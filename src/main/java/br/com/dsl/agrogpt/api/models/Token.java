package br.com.dsl.agrogpt.api.models;

public record Token(
        String token,
        String type,
        String prefix
) {}
