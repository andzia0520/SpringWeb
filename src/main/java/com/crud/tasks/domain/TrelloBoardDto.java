package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TrelloBoardDto {
    private String name;
    private String id;

}
