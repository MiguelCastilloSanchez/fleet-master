package com.example.fleetmaster.infrastructure.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.fleetmaster.entity.assigment.model.Assignment;
import com.example.fleetmaster.infrastructure.assignment.dto.AssignmentPublicData;
import com.example.fleetmaster.usecase.assignment.SearchHistoryAssignmentUseCase;
@RestController
public class SearchHistoryAssignmentController {
     @Autowired
    SearchHistoryAssignmentUseCase searchHistoryAssignmentUseCase;

    @GetMapping("/assignment/history")
    @ResponseStatus(HttpStatus.OK)
    public List<AssignmentPublicData> searchHistoryAssignment(){
         List<Assignment> assignments = this.searchHistoryAssignmentUseCase.execute();

        return assignments.stream().map(AssignmentPublicData::new).toList();

    }
}
