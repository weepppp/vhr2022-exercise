package com.qfedu.vhr.admin.controller.system.controller;

import com.qfedu.vhr.system.entity.Position;
import com.qfedu.vhr.system.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author weepppp 2022/7/27 10:01
 **/
@RestController
@RequestMapping("/system/basic/position")
public class PositionController {

    @Autowired
    IPositionService positionService;

    @GetMapping("/")
    public List<Position> getAllPositions(){
        return positionService.list();
    }
}
