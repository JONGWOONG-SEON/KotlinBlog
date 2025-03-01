package com.kotlinpjt.domain.member

import com.kotlinpjt.domain.AuditingEntity
import jakarta.persistence.*

@Entity
@Table(name="Member")
class Member (

    email:String,
    password:String,
    role:Role

): AuditingEntity(){

    @Column(name="email",nullable = false)
    var email:String = email
        protected set

    @Column(name="password")
    var password:String = password
        protected set

    @Enumerated(EnumType.STRING)
    var role: Role = role


    override fun toString(): String {
        return "Member(email='$email', password='$password', role=$role)"
    }


}

enum class Role {
    USER, ADMIN
}