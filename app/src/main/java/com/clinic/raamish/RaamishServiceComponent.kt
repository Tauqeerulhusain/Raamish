package com.clinic.raamish

import dagger.Component

@Component
interface RaamishServiceComponent {
//    fun getServiceObj(): RaamishService
    fun inject(activity: MainActivity)

}