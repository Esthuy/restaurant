package be.technifutur.restaurant.models.dto;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpMethod;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
@Builder
public class ErrorDTO {

    private final int id;
    private final String message;
    private final int status;
    private final String uri;
    private final HttpMethod method;
    private final Map<String, Object> infos = new HashMap<>();

    public ErrorDTO(String message, String uri, HttpMethod method, int id) {
        this.id = id;
        this.message = message;
        this.status = 400;
        this.uri = uri;
        this.method = method;
    }


    public ErrorDTO(String message, int status, String uri, HttpMethod method, Map<String, Object> infos, int id) {
        this.id = id;
        this.message = message;
        this.status = status;
        this.uri = uri;
        this.method = method;
        this.infos.putAll(infos);
    }
}