package com.springboot.simplespringboot.resonse;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ResponseStructure<T> {
private String statusCode;
private LocalDateTime dateTime;
private String statusMassage;
private String description;
private T data;
}
