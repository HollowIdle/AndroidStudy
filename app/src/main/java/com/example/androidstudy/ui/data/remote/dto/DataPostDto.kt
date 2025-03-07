package com.example.androidstudy.ui.data.remote.dto


data class DataPostDto(
    val id : Int,
    val title : String? = null,
    val description: String? = null
)

fun DataPostDto.toDomainPost() =
    DomainPost(
        id = id,
        title = title,
        description = description
    )

fun List<DataPostDto>.toDomainPostList() =
    DomainPostList(
        this.map {
            it.toDomainPost()
        }
    )