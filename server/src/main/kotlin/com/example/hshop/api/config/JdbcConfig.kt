package com.example.hshop.api.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableJdbcAuditing
@EnableJdbcRepositories(basePackages = ["com.example.hshop.api"])
@EnableTransactionManagement
class JdbcConfig