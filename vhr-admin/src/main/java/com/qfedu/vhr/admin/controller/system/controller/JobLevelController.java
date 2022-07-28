package com.qfedu.vhr.admin.controller.system.controller;

import com.qfedu.vhr.framework.entity.RespBean;
import com.qfedu.vhr.system.entity.Joblevel;
import com.qfedu.vhr.system.service.IJoblevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author weepppp 2022/7/27 17:40
 **/
@RestController
@RequestMapping("/system/basic/jobLevel")
public class JobLevelController {

    @Autowired
    IJoblevelService joblevelService;

    @GetMapping("/")
    public List<Joblevel> getAllJobLevel(){
        return joblevelService.list();
    }

    @PostMapping("/")
    public RespBean addJobLevel(@RequestBody Joblevel joblevel){
        int result = joblevelService.addJobLevel(joblevel);
        if (result == 1 ) {
            return RespBean.ok("添加成功");
        } else if(result == -1) {
            return RespBean.error("职称名存在，添加失败");
        }
        return RespBean.error("添加失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteJobLevel(@PathVariable Integer id) {
        int result = joblevelService.deleteJobLevel(id);
        if (result == 1 ) {
            return RespBean.ok("删除成功");
        } else if(result == -1) {
            return RespBean.error("要删除的数据不存在，删除失败");
        }
        return RespBean.error("删除失败");
    }

    @PutMapping("/")
    public RespBean updateJobLevel(@RequestBody Joblevel joblevel){
        if(joblevelService.updateById(joblevel)) {
            return RespBean.ok("更新成功");
        }
        return RespBean.ok("更新失败");
    }
}
