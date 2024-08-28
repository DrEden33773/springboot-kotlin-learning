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
            .also { it.javadocConfig.author = "Eden" }
            .also { it.packageConfig.setBasePackage("org.ember.demo") }
            .also { it.enableEntity().setWithLombok(true).setJdkVersion(21) }
            .also { it.enableMapper().setMapperAnnotation(true) }
            .also { it.enableService() }
            .also { it.enableServiceImpl().setCacheExample(true) }
            .also { it.enableController().setRestStyle(true) }
            .also { it.enableMapperXml() }
        val generator = Generator(dataSource, globalConfig)
        generator.generate()
    }

}
