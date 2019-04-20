package com.duongnv.services.room;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/rooms")
@Api(value = "rooms", tags = {"rooms"}, description = "data service operation on rooms")
public class RoomController {

    private RoomRepository repository;

    public RoomController(RoomRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    @ApiOperation(value = "Get all rooms", notes = "get all room in the system", nickname = "getRooms")
    public List<Room> get(@RequestParam(required = false) String roomNumber) {

        if (StringUtils.isNotBlank(roomNumber)) {
            return Collections.singletonList(this.repository.findByRoomNumber(roomNumber));
        }

        return (List<Room>) this.repository.findAll();
    }
}
