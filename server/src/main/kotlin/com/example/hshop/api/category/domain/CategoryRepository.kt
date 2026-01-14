package com.example.hshop.api.category.domain

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CategoryRepository : CrudRepository<Category, UUID>, PagingAndSortingRepository<Category, UUID> {
}