package com.cheney.plugin.autotracker

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * 参考：https://juejin.cn/post/6917486983946338318#heading-13
 */
open class TrackerGenerateTask : DefaultTask() {

    init {
        group="tracker"
        description="自定义生成埋点插件"
    }


    @TaskAction
    fun start(){
        println("TrackerGenerateTask start")
    }
}