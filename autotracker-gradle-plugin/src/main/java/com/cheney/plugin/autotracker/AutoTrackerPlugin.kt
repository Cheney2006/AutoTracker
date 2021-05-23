package com.cheney.plugin.autotracker

import org.gradle.api.Plugin
import org.gradle.api.Project

private const val AUTO_TRACKER = "autoTracker"

/**
 * gradle 自定义插件
 * https://docs.gradle.org/current/userguide/java_gradle_plugin.html
 * https://docs.gradle.org/nightly/userguide/custom_plugins.html
 *
 * https://zhuanlan.zhihu.com/p/158588813
 * https://blog.csdn.net/u013700502/article/details/85232032
 *
 *
 */
class AutoTrackerPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        println("AutoTracker Plugin start")
        //1.添加插件扩展到project.extensions集合中
//        project.extensions.create(AUTO_TRACKER, TrackerExtension::class.java)
//        project.task("generateTracker") {
//            it.doLast {
//                println("AutoTracker Plugin generator start")
//                //2.获取外界配置的 TestExtension
//                val extension: TrackerExtension =
//                    project.extensions.findByName(AUTO_TRACKER) as TrackerExtension
//                //3.输出插件扩展属性
//                println("TrackerExtension = ${extension.trackerPath}")
//            }
//        }

        val extension = project.extensions.create(AUTO_TRACKER, TrackerExtension::class.java)

        project.tasks.create("generateTracker", TrackerGenerateTask::class.java) {

//            it.description="自动生成埋点插件"

            it.doFirst { task ->
                println("doFirst start ---------->")
                println("description= ${task.description}")
                println("doFirst end ---------->")
            }

            it.doLast {
                println("doLast start ---------->")
                println("TrackerExtension= ${extension.trackerPath}")
                println("doLast end ---------->")
            }
        }

    }
}

open class TrackerExtension {
    var trackerPath: String = "/src/auto-tracker"
}