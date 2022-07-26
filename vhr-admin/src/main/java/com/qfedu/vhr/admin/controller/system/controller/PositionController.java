package com.qfedu.vhr.admin.controller.system.controller;

import com.alibaba.excel.EasyExcel;
import com.qfedu.vhr.framework.entity.RespBean;
import com.qfedu.vhr.framework.entity.RespPageBean;
import com.qfedu.vhr.admin.controller.system.entity.Position;
import com.qfedu.vhr.admin.controller.system.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author weepppp 2022/7/27 10:01
 **/
@RestController
@RequestMapping("/system/basic/position")
public class PositionController {

    @Autowired
    IPositionService positionService;

    @GetMapping("/")
    public RespPageBean getAllPositions(@RequestParam(defaultValue = "1") Integer page,
                                        @RequestParam(defaultValue = "10") Integer size){
        return positionService.getPositionByPage(page,size);
    }

    @PostMapping("/")
    public RespBean addPosition(@RequestBody Position position) {
        int result = positionService.savePosition(position);
        if (result == 1 ) {
            return RespBean.ok("添加成功");
        } else if(result == -1) {
            return RespBean.error("职位名存在，添加失败");
        }
        return RespBean.error("添加失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deletePosition(@PathVariable Integer id) {
        int result = positionService.deletePositionById(id);
        if (result == 1){
            return RespBean.ok("删除成功");
        } else if(result == -1) {
            return RespBean.error("要删除的数据不存在，删除失败");
        }
        return RespBean.error("删除失败");
    }

    @PutMapping("/")
    public RespBean updatePosition(@RequestBody Position position) {
        if (positionService.updateById(position)) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @GetMapping("/export")
    public void download(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("职位数据", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition","attachment;filename*=utf-8''"+fileName+".xlsx");
        EasyExcel.write(response.getOutputStream(),Position.class).sheet("职位信息").doWrite(positionService.list());
    }

    @PostMapping("/import")
    public RespBean importPositionData(MultipartFile file){
        return positionService.importPositionData(file);
    }


}
