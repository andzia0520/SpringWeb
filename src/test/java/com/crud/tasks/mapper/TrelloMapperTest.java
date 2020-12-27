package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
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
        List<TrelloListDto> listDtos = new ArrayList<>();
        listDtos.add(new TrelloListDto("1", "TestListDto", false));

        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        trelloBoardDtos.add(new TrelloBoardDto("1", "TestBoardsDto", listDtos));

        //When
        List<TrelloBoard> mappedToBoards = trelloMapper.mapToBoards(trelloBoardDtos);

        //Then
        assertEquals(1, mappedToBoards.size());
        assertEquals("1", mappedToBoards.get(0).getId());
        assertEquals("TestBoardsDto", mappedToBoards.get(0).getName());
        assertEquals("TestListDto", mappedToBoards.get(0).getLists().get(0).getName());
    }

    @Test
    public void mapToBoardsDto() {
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("1", "TestList", false));

        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("1", "TestBoard", trelloLists));

        //When
        List<TrelloBoardDto> mappedToBoardsDto = trelloMapper.mapToBoardsDto(trelloBoards);

        //Then
        assertEquals(1, mappedToBoardsDto.size());
        assertEquals("1", mappedToBoardsDto.get(0).getId());
        assertEquals("TestBoard", mappedToBoardsDto.get(0).getName());
        assertEquals("TestList", mappedToBoardsDto.get(0).getLists().get(0).getName());
    }

    @Test
    public void mapToList() {
        //Given
        List<TrelloListDto> listDtos = new ArrayList<>();
        listDtos.add(new TrelloListDto("1", "TestListDto", false));

        //When
        List<TrelloList> mappedToList = trelloMapper.mapToList(listDtos);

        //Then
        assertEquals(1, mappedToList.size());
        assertEquals("1", mappedToList.get(0).getId());
        assertEquals("TestListDto", mappedToList.get(0).getName());
        assertFalse(mappedToList.get(0).isClosed());
    }

    @Test
    public void mapToListDto() {
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("1", "TestList", false));

        //When
        List<TrelloListDto> mapedToListDtos = trelloMapper.mapToListDto(trelloLists);

        //Then
        assertEquals(1, mapedToListDtos.size());
        assertEquals("1", mapedToListDtos.get(0).getId());
        assertEquals("TestList", mapedToListDtos.get(0).getName());
        assertFalse(mapedToListDtos.get(0).isClosed());
    }

    @Test
    public void mapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("trelloCard", "convert TrelloCard", "bottom", "23");

        //When
        TrelloCardDto mappedToCardDto = trelloMapper.mapToCardDto(trelloCard);

        //Then
        assertEquals("trelloCard", mappedToCardDto.getName());
        assertEquals("convert TrelloCard", mappedToCardDto.getDescription());
        assertEquals("bottom", mappedToCardDto.getPos());
        assertEquals("23", mappedToCardDto.getListId());
    }

    @Test
    public void mapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("trelloCardDto", "convert TrelloCardDto", "bottom", "13");

        //When
        TrelloCard mappedToCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        assertEquals("trelloCardDto", mappedToCard.getName());
        assertEquals("convert TrelloCardDto", mappedToCard.getDescription());
        assertEquals("bottom", mappedToCard.getPos());
        assertEquals("13", mappedToCard.getListId());
    }
}