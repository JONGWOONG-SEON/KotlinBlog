package com.kotlinpjt.domain.post

import com.kotlinpjt.domain.post.Post
import org.springframework.data.jpa.repository.JpaRepository

interface  PostRepository : JpaRepository<Post, Long> {

}