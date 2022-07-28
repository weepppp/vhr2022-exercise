package com.qfedu.vhr.system.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.qfedu.vhr.system.entity.Position;
import com.qfedu.vhr.system.service.IPositionService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weepppp 2022/7/28 10:44
 **/
public class PositionListener implements ReadListener<Position> {
    public PositionListener(IPositionService positionService) {
        this.positionService = positionService;
    }

    private List<Position> positions = new ArrayList<>();
    private IPositionService positionService;

    @Override
    public void invoke(Position position, AnalysisContext analysisContext) {
        position.setId(null);
        positions.add(position);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        positionService.saveBatch(positions);
    }
}
