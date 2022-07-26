package com.qfedu.vhr.admin;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

/**
 * @author weepppp 2022/7/22 15:25
 **/

@SpringBootTest
public class MainTest {

    @Test
    public void Test1() {
        FastAutoGenerator.create("jdbc:mysql:///vhr?serverTimezone=Asia/Shanghai", "root", "1234")
                .globalConfig(builder -> {
                    builder.author("qf") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D:\\testtesttesttesttesttesttesttesttesttest\\vhr\\vhr-employee\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.qfedu.vhr") // 设置父包名
                            .moduleName("employee") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D:\\testtesttesttesttesttesttesttesttesttest\\vhr\\vhr-employee\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("mail_send_log") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
