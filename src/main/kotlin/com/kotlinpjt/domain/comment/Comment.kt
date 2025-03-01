package com.kotlinpjt.doamin.comment

import com.kotlinpjt.domain.AuditingEntity
import jakarta.persistence.*
import com.kotlinpjt.domain.post.Post

@Entity
@Table(name="Comment")
class Comment (

    title:String,
    content:String,
    post: Post

): AuditingEntity(){

    @Column(name = "content", nullable = false)
    var content:String = content
        protected set

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Post::class)
    var post:Post = post
        protected set

}