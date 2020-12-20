package com.crud.tasks.trello.facade;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloList;
import com.crud.tasks.domain.TrelloListDto;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TrelloFacadeTest {

    @InjectMocks
    private TrelloFacade trelloFacade;

    @Test
    public void shouldFetchTrelloBoards() {
        //Given

        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("1","TestList", false ));

        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("1","Test", trelloLists));

        List<TrelloListDto> listDtos = new ArrayList<>();
        listDtos.add(new TrelloListDto("1", "Test", false));

        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        trelloBoardDtos.add(new TrelloBoardDto("1", "Test", listDtos));

        //When
        List<TrelloBoardDto> fetchedTrelloBoards = trelloFacade.fetchTrelloBoards();

        //Then
        assertEquals(1, fetchedTrelloBoards.size());

    }


    @Test
    void shouldCreateCard() {
    }
}