package com.example.tweetnest.tweetnest.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ApiResponse {

    private String message;
    private boolean status;


}
