package com.vimal.core.models

import android.content.Intent

class ActivityNavigationData(var intent: Intent? = null, var finishCurrent: Boolean = false, var activityClass: Class<*>? = null)