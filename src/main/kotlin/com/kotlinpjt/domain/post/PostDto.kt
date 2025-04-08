package com.kotlinpjt.domain.post

import com.kotlinpjt.domain.member.Member

data class PostSaveReq (
    val title:String,
    val content:String,
    val memberId: Long
)

fun PostSaveReq.toEntity() : Post{

    return Post(
        title = this.title,
        content = this.content,
        member = Member.createFakerMember (this.memberId)
    )
}