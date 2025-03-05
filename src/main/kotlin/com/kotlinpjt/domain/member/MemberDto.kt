package com.kotlinpjt.domain.member

data class MemberSaveReq (
    val email:String,
    val password:String,
    val role:Role
){
    fun toEntity (): Member{
        return Member(
            email = this.email,
            password = this.password,
            role = this.role,
        )
    }
}