package com.qfedu.vhr.admin.controller.system.service;

import com.qfedu.vhr.admin.controller.system.entity.Joblevel;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qf
 * @since 2022-07-25
 */
public interface IJoblevelService extends IService<Joblevel> {


    int addJobLevel(Joblevel joblevel);

    int deleteJobLevel(Integer id);
}
