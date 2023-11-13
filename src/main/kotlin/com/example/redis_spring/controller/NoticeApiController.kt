package com.example.redis_spring.controller

import com.example.redis_spring.common.Log
import com.example.redis_spring.model.NoticeDto
import com.example.redis_spring.service.NoticeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/notice")
class NoticeApiController(
    private val noticeService: NoticeService
) {

    companion object: Log

    @GetMapping("/get-notice")
    fun getNotice(
        @RequestParam id: Long?
    ): NoticeDto? {
        log.info("notice controller get Notice: {}", id)
        val response = noticeService.getNotice(id)
        log.info("notice controller get Notice response: {}", response)
        return response
    }

    @GetMapping("/add-notice")
    fun addNotice(
        @RequestParam notice: String?
    ): NoticeDto? {
        log.info("notice controller add Notice: {}", notice)
        val response = noticeService.addNotice(NoticeDto(notice = notice))
        log.info("notice controller add Notice response: {}", response)
        return response
    }
}