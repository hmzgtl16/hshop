package com.example.hshop.api.entity

import com.example.hshop.domain.model.UserRole
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.relational.core.mapping.Column
import java.time.Instant
import java.util.UUID

@Table("users")
data class UserEntity(
    @Id
    val id: UUID? = null,

    @Column("email")
    val email: String,

    @Column("password")
    val password: String,

    @Column("first_name")
    val firstName: String,

    @Column("last_name")
    val lastName: String,

    @Column("role")
    val role: UserRole = UserRole.CUSTOMER,

    @CreatedDate
    @Column("created_at")
    val createdAt: Instant = Instant.now(),

    @LastModifiedDate
    @Column("updated_at")
    val updatedAt: Instant = Instant.now()
)

