package com.andan.plugin

import com.android.build.gradle.AppExtension
import org.gradle.api.Plugin
import org.gradle.api.Project


class MyPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        AppExtension appExtension = (AppExtension)project.getProperties().get("android")
        appExtension.registerTransform(new MyTransform())
    }
}