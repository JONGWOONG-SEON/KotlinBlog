package com.kotlinpjt.config

import com.kotlinpjt.domain.member.Member
import io.github.serpro69.kfaker.faker
import com.kotlinpjt.domain.member.MemberRepository
import com.kotlinpjt.domain.member.Role
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.EventListener

@Configuration
class InitConfig(
    private val memberRepository: MemberRepository

) {
    val faker = faker { }
    private val log = KotlinLogging.logger {}

    @EventListener(ApplicationReadyEvent::class)
    private fun init(){


        val member = Member(
                email  = faker.internet.safeEmail(),
                password = "1234",
                role = Role.USER
        )
        log.info {"Insert $member"}
        memberRepository.save(member)
    }
}