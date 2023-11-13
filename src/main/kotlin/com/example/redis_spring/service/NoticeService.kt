package com.example.redis_spring.service

import com.example.redis_spring.model.NoticeDto
import com.example.redis_spring.common.Log
import com.example.redis_spring.repository.NoticeRepository
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class NoticeService(
    private val noticeRepository: NoticeRepository
) {

    companion object: Log

    @Cacheable(cacheNames = ["notice"], key = "#id")
    fun getNotice(id: Long?): NoticeDto? {
        log.info("notice service get notice: {}", id)
        return noticeRepository.getNotice(id)
    }

    @CachePut(cacheNames = ["notice"], key = "#notice.id")
    fun addNotice(notice: NoticeDto?): NoticeDto? {
        log.info("notice service add notice: {}", notice)
        return noticeRepository.addNotice(notice)
    }
}