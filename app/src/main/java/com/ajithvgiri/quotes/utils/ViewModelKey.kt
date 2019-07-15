/*------------------------------------------------------------------------------
 -  Created by ajithvgiri on 22/11/18 10:51 PM
 -  Copyright (c) 2018 . All rights reserved.
 -  Last modified 22/11/18 12:29 PM
 -
 -----------------------------------------------------------------------------*/
package com.ajithvgiri.quotes.utils

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)