package com.crud.tasks.controller;

import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.mapper.CreatedTrelloCardDto;
import com.crud.tasks.service.TrelloService;
import com.crud.tasks.trello.facade.TrelloFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    private TrelloFacade trelloFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/boards")
    public List<TrelloBoardDto> getTrelloBoards() {
        return trelloFacade.fetchTrelloBoards();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cards")
    public CreatedTrelloCardDto createdTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
        return trelloFacade.createCard(trelloCardDto);
    }



//    @RequestMapping(method = RequestMethod.GET, value = "/getTrelloBoards")
//    public List<TrelloBoardDto> getTrelloBoards() {
//        return trelloFacade.fetchTrelloBoards();
//
//        /*//GET request
//        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();
//
//        trelloBoards.stream()
//                .filter(dto -> dto.getName() != null)
//                .filter(dto -> dto.getId() != null)
//                .filter(dto -> dto.getName().contains("Kodilla"))
//                .forEach(trelloBoardDto -> {
//            System.out.println(trelloBoardDto.getName() + " - " + trelloBoardDto.getId());
//
//            System.out.println("This board contains lists: ");
//
//        trelloBoardDto.getLists()
//                    .forEach(trelloList ->
//            System.out.println(trelloList.getName() + " - " + trelloList.getId() + " - " + trelloList.isClosed()));
//        });*/
//    }
//
//    @RequestMapping(method = RequestMethod.POST, value = "/createTrelloCard")
//    public CreatedTrelloCardDto createdTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
//        return trelloFacade.createCard(trelloCardDto);
//    }
}
