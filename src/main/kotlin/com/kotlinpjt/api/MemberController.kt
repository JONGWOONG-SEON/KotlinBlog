package com.kotlinpjt.api

import com.kotlinpjt.domain.member.Member
import com.kotlinpjt.domain.member.MemberRepository
import com.kotlinpjt.service.MemberService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController(
    private val memberService: MemberService
) {
    @GetMapping("/members")
    fun findAll(): MutableList<Member>{
        return memberService.findAll()
    }
}