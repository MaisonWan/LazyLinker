package com.domker.lazylinker.data

import com.google.gson.annotations.SerializedName

data class Linker(val type: String,
                  val name: String,
                  @SerializedName("run_path") val runPath: String,
                  val content: String)