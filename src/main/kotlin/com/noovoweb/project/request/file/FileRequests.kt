package com.noovoweb.project.request.file

import com.noovoweb.validator.*
import kotlinx.serialization.Serializable

@Validated
@Serializable
data class FileExtensionRequest(
    @FileExtension(["txt", "pdf", "doc"])
    val filePath: String?
)

@Validated
@Serializable
data class MimeTypeRequest(
    @MimeType(["image/png", "image/jpeg", "application/pdf"])
    val filePath: String?
)

@Validated
@Serializable
data class MaxFileSizeRequest(
    @MaxFileSize(1048576) // 1MB
    val filePath: String?
)
