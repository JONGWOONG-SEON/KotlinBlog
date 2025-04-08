package com.kotlinpjt.config

import com.kotlinpjt.domain.member.*
import io.github.serpro69.kfaker.faker
import com.kotlinpjt.domain.post.Post
import com.kotlinpjt.domain.post.PostSaveReq
import com.kotlinpjt.domain.post.PostRepository
import com.kotlinpjt.domain.post.toEntity
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.EventListener

@Configuration
class InitConfig(
    private val memberRepository: MemberRepository,
    private val postRepository: PostRepository

) {
    val faker = faker { }
    private val log = KotlinLogging.logger {}

    @EventListener(ApplicationReadyEvent::class)
    private fun init() {

        val members = generateMember(100)
        memberRepository.saveAll(members)
        val posts = generatePosts(100)
        postRepository.saveAll(posts)
//        val members = mutableListOf<Member>()
    }

    private fun generateMember(cnt: Int): MutableList<Member> {
        val members = mutableListOf<Member>()

        for (i in 1 .. cnt) {
            val member = generateMember()
            log.info { "Insert $member" }
            members.add(member)
        }
        return members
    }

    private fun generatePosts(cnt: Int): MutableList<Post> {
        val posts = mutableListOf<Post>()

        for (i in 1..cnt) {
            val post = generatePosts()
            log.info { "Insert $post" }
            posts.add(post)
        }
        return posts
    }

    private fun generateMember(): Member = MemberSaveReq(
        email = faker.internet.safeEmail(),
        password = "1234",
        role = Role.USER,
        ).toEntity()

    private fun generatePosts():Post = PostSaveReq (
        title = faker.internet.domain(),
        content = faker.internet.slug(),
        memberId = 1,
    ).toEntity()

}