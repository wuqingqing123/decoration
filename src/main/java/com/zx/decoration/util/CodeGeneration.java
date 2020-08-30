package com.zx.decoration.util;


import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 */
public class CodeGeneration {
    @Autowired
    private static DataSource dataSource;

    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "!");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");//生成文件的输出目录
        gc.setAuthor("wuqingqing");//开发人员
        gc.setOpen(true);//是否打开输出目录
        gc.setServiceName("%sService");//service 命名方式
        gc.setServiceImplName("%sServiceImpl");//service impl 命名方式
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        gc.setEnableCache(false);    // XML 二级缓存
        gc.setBaseResultMap(true);   // XML ResultMap
        gc.setBaseColumnList(false);  // XML columList
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();

//        System.out.println(PropertesUtil.getCommonYml("-------------------->"+"spring.datasource.username"));

        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("960626");
        dsc.setUrl("jdbc:mysql://39.96.0.70:3306/zx?useSSL=false");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        //pc.setModuleName(scanner("模块名"));//父包模块名
        pc.setParent("com.zx.decoration");//父包名。// 自定义包路径  如果为空，将下面子包名必须写全部， 否则就只需写子包名
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };


        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                if (pc.getModuleName() == null) {
                    return projectPath + "/src/main/resources/mapper/"
                            + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                } else {
                    return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                            + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                }
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));


        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
        //  strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");//自定义继承的Entity类全称，带包名
        strategy.setEntityLombokModel(false);//【实体】是否为lombok模型（默认 false）
        //strategy.setRestControllerStyle(true);//生成 @RestController 控制器

        //strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");//自定义继承的Controller类全称，带包名
        strategy.setInclude(scanner("表名"));//需要包含的表名，允许正则表达式
        //strategy.setSuperEntityColumns("id");//自定义基础的Entity类，公共字段
        strategy.setControllerMappingHyphenStyle(true);//驼峰转连字符
        //strategy.setTablePrefix("tb_");//表前缀
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}

