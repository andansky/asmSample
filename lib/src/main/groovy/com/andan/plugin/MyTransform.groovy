package com.andan.plugin

import com.example.lib.TimeWeaver
import com.quinn.hunter.transform.HunterTransform
import org.gradle.api.Project

class MyTransform extends HunterTransform{

    private Project project
    MyTransform(Project project) {
        super(project)
        this.project=project
        this.bytecodeWeaver=new TimeWeaver()
    }
}