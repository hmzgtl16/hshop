package com.example.hshop.api.repository

import com.example.hshop.api.entity.UserEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.*

interface UserRepository : CoroutineCrudRepository<UserEntity, UUID> {
}