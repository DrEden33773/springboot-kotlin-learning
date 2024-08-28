package org.ember.demo

import com.mybatisflex.codegen.Generator
import com.mybatisflex.codegen.config.GlobalConfig
import com.zaxxer.hikari.HikariDataSource
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private lateinit var dataSource: HikariDataSource

    @Test
    fun mybatisFlexCodeGen() {
        val globalConfig = GlobalConfig()
            .also {
                it.javadocConfig.author = "Eden"
            }
            .also {
                it.packageConfig.setBasePackage("org.ember.demo")
            }.also {
                it.enableEntity()
                    .setWithLombok(true)
                    .setOverwriteEnable(true)
                    .setJdkVersion(21)
            }.also {
                it.enableMapper()
                    .setOverwriteEnable(true)
                    .setMapperAnnotation(true)
            }.also {
                it.enableService()
                    .setOverwriteEnable(true)
            }.also {
                it.enableServiceImpl()
                    .setOverwriteEnable(true)
                    .setCacheExample(true)
            }.also {
                it.enableController()
                    .setOverwriteEnable(true)
                    .setRestStyle(true)
            }.also {
                it.enableMapperXml()
                    .setOverwriteEnable(true)
            }
        val generator = Generator(dataSource, globalConfig)
        generator.generate()
    }

}
