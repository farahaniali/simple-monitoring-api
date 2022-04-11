package com.example.monitoringapi.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/queries")
public class QueryController {

    final private QueryService queryService;


    @Autowired
    public QueryController(QueryService queryService) {
        this.queryService = queryService;
    }

    @PostMapping("/")
    public QueryResult getQuery(@RequestBody Query query){

        QueryResult queryResult = queryService.query(query);

        return queryResult;
    }
}
