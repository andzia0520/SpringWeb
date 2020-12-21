package com.crud.tasks.mapper;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloList;
import com.crud.tasks.domain.TrelloListDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TrelloMapperTest {
    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    public void mapToBoards() {
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("1","TestList", false ));

        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("1","TestBoard", trelloLists));

        List<TrelloListDto> listDtos = new ArrayList<>();
        listDtos.add(new TrelloListDto("1", "TestListDtos", false));

        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        trelloBoardDtos.add(new TrelloBoardDto("1", "TestBoardsDtos", listDtos));

        //When
        List<TrelloBoard> mappedToBoards = trelloMapper.mapToBoards(trelloBoardDtos);

        //Then
        assertEquals(1,mappedToBoards.size());
        assertEquals("TestBoardsDtos", mappedToBoards.get(0).getName());

    }

    @Test
    public void mapToBoardsDto() {
    }

    @Test
    public void mapToList() {
    }

    @Test
    public void mapToListDto() {
    }

    @Test
    public void mapToCardDto() {
    }

    @Test
    public void mapToCard() {
    }
}