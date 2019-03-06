package com.andan.plugin

import com.android.build.gradle.AppExtension
import org.gradle.api.Plugin
import org.gradle.api.Project


class MyPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        println("start plugin-------------------------------------------")
        AppExtension appExtension = (AppExtension)project.getProperties().get("android")
        if(appExtension==null){
            println("plugin is null")
        }else{
            println("plugin is not null")
            appExtension.registerTransform(new MyTransform())
        }
    }
}