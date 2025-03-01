package com.kotlinpjt.domain.post

import com.kotlinpjt.domain.AuditingEntity
import jakarta.persistence.*
import com.kotlinpjt.domain.member.Member

@Entity
@Table(name="Post")
class Post (
    title:String,
    content:String,
    member: Member

) : AuditingEntity() {

    @Column(name="title",nullable = false)
    var title : String = title
        protected set

    @Column(name="content")
    var content:String = content
        protected set

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Member::class)
    var member:Member = member
        protected set
}