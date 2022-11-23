import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hongYaoZhang
 * @version 1.0
 * @since 2022/09/10 22:49
 * springboot基于Mybatis-plus的代码生成器
 * 可生成控制层、服务层、实现层、持久层、实体、mapper.xml文件
 * 注意不要删除resource/templates里面的东西
 */
@Slf4j
public class CodeGenerator {

    /**
     * 数据库链接配置
     * dcom.mysql.jdbc.Driver = 数据库加载驱动 适用于5.7之前的MySQL版本
     * com.mysql.cj.jdbc.Driver = 数据库加载驱动 适用于5.7之后的MySQL版本
     */
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/dataBase_Name?characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
    private static final String DB_USERNAME = "";
    private static final String DB_PASSWORD = "";

    /**
     * 数据库表配置,多个表之间用,分割
     */
    private static final String DB_TABLE_NAME = "";

    /**
     * 配置去除数据库表前缀,例如t_user表,则DB_TABLE_PREFIX的常量值就为t_
     */
    private static final String DB_TABLE_PREFIX = "";

    /**
     * 配置包路径
     */
    private static final String PACKAGE_ROUTE = "";

    /**
     * 设置作者
     */
    private static final String AUTHOR = "";

    public static void main(String[] args) {

        // 构建一个代码自动生成器对象
        AutoGenerator mpg = new AutoGenerator();

        /*
          1.全局配置
          {
             System.getProperty("user.dir") = 项目根路径 例如 D:/XXX/XXX
             gc.setOutputDir(projectPath + "/src/main/java") = 项目包路径 例如D:/XXX/XXX/src/main/java
             gc.setAuthor("") = 项目作者
             gc.setOpen() = 生成完成是否打开文件夹 true: 打开文件夹 / false: 不打开文件夹
             gc.setFileOverride() = 生成时是否覆盖上一次生成的文件 true: 覆盖 / false: 不覆盖 (PS: 一般选择不覆盖,生成完毕直接剪切即可)
             gc.setServiceName("%sService") = 生成Service时去掉I前缀
             gc.setIdType(IdType.XXX) = 主键策略
             gc.setSwagger2() = 开启 swagger2 模式 true: 开启 / false: 不开启
             gc.setBaseResultMap() = 生成mapper.xml文件时是否映射结果 true: 开启 / 不开启
             gc.setBaseColumnList(true) = 生成mapper.xml文件时是否生成查询通用列 true: 开启 / false: 不开启
             gc.setControllerName("%sController"); = 生成控制层类时所加的后缀 比如User表开启了此配置则变成UserController
             gc.setServiceName("%sService"); = 生成服务层接口时加的后缀 如User表开启了此配置则变成UserService true: 开启 / false: 不开启
             gc.setServiceName("%sServiceImpl"); = 生成服务层实现服务接口时加的后缀 如User表开启了此配置则变成UserServiceImpl true: 开启 / false: 不开启
             gc.setMapperName("%sMapper"); = 生成持久层接口时加的后缀 比如User表开启了此配置则变成UserMapper 也可以改变为Dao,根据项目要求所灵活配置 true: 开启 / false: 不开启
             gc.setEntityName("%sEntity") = 生成实体时所加的后缀 比如User表开启了此配置则变成UserEntity true: 开启 / false: 不开启
          }
         */
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor(AUTHOR);
        gc.setOpen(false);
        gc.setFileOverride(false);
        gc.setSwagger2(true);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        mpg.setGlobalConfig(gc);

        /*
          2.数据源配置
          {
             dsc.setDriverName("com.mysql.jdbc.Driver") = 数据库加载驱动 适用于5.7之前的MySQL版本
             dsc.setDriverName("com.mysql.cj.jdbc.Driver") = 数据库加载驱动 适用于5.7之后的MySQL版本
             dsc.setUrl("jdbc:mysql://127.0.0.1:3306/表名?characterEncoding=utf-8&serverTimezone=Asia/Shanghai") = 数据库链接地址,如果是5.7之后的版本必须配置时区: serverTimezone=Asia/Shanghai,不然报错: java.sql.SQLException: The server time zone value
             dsc.setUsername("") = 数据库用户名
             dsc.setPassword("") = 数据库密码
             dsc.setDbType(DbType.MYSQL) = 数据库类型,这里我用MySQL
          }
         */
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDriverName(DB_DRIVER);
        dsc.setUrl(DB_URL);
        dsc.setUsername(DB_USERNAME);
        dsc.setPassword(DB_PASSWORD);
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        /*
          3.package配置
          {
              pc.setParent(PACKAGE_ROUTE) = 配置包路径
          }
         */
        PackageConfig pc = new PackageConfig();
        pc.setParent(PACKAGE_ROUTE);
        mpg.setPackageInfo(pc);

        /*
          4.自定义配置(自定义配置在resource目录下创建mapper文件夹,放mapper.xml文件的)
         */
        InjectionConfig config = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        String templatePath = "/templates/mapper.xml.vm";
        // 自定义输出配置(自定义配置会被优先输出)
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        config.setFileOutConfigList(focList);
        mpg.setCfg(config);

        /*
          5.配置模板 (防止mapper层创建时,一起创建了mapper.xml文件在mapper包下)
         */
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        // 设置模板
        mpg.setTemplate(templateConfig);

        /*
          6.策略配置
          {
              strategy.setTablePrefix("") = 配置去除数据库中表的前缀
              {
                  strategy.setInclude("".split(",")) = 设置要映射的表名 多个表可以以逗号分割(此方法使用直接写入表名)
              }
          }
         */
        StrategyConfig strategy = new StrategyConfig();
        strategy.setTablePrefix(DB_TABLE_PREFIX);
        strategy.setInclude(DB_TABLE_NAME.split(","));

        /*
          7.表与字段配置
          {
              strategy.setNaming(NamingStrategy.underline_to_camel) = 表名下划线转驼峰
              strategy.setColumnNaming(NamingStrategy.underline_to_camel) = 字段名下划线转驼峰
              strategy.setLogicDeleteFieldName("") = 设置数据库逻辑删除字段
          }
         */
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setLogicDeleteFieldName("数据库逻辑删除字段,没有可不填(此处可以不动,没有影响)");

        /*
          8.自动填充配置
         */
        TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);
        TableFill gmtModified = new TableFill("gmt_modified", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmtCreate);
        tableFills.add(gmtModified);
        strategy.setTableFillList(tableFills);

        /*
          9.策略生效
         */
        strategy.setVersionFieldName("version");
        strategy.setRestControllerStyle(true);
        strategy.setEntityBuilderModel(true);
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);

        //执行代码生成器
        CodeGenerator.runExecute(mpg);
    }

    public static void runExecute(AutoGenerator mpg) {
        try {
            mpg.execute();
            log.info("代码生成成功! !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
