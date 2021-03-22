package io.tecky.liphy

import android.R
import android.view.TextureView
import android.view.ViewGroup
import com.facebook.react.bridge.*
import com.facebook.react.modules.core.DeviceEventManagerModule
import liphy.io.liphysdk.LightFlyCamera
import liphy.io.liphysdk.LightFlyCamera.OnLightTrackedCallback

class LiphyModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext), OnLightTrackedCallback {
    var lightFlyManager: LightFlyCamera? = null

    override fun getName(): String {
        return "Liphy"
    }

    private fun initializeCamera() {
        if (lightFlyManager == null) {
            val activity = currentActivity
            lightFlyManager = LightFlyCamera.getCameraInstance(activity)
            val textureView = TextureView(activity)
            textureView.alpha = 0f
            val viewGroup = activity!!.findViewById<ViewGroup>(R.id.content)
            viewGroup.addView(textureView, 0)
            lightFlyManager!!.setTextureView(textureView)
            lightFlyManager!!.setLightTrackedCallback(this)
            lightFlyManager!!.setAcessKeyForSDK("axscbhawe873d0asc70382")
        }
    }

    @ReactMethod
    fun startTracking() {
        currentActivity!!.runOnUiThread {
            initializeCamera()
            lightFlyManager!!.startTracking()
        }
    }

    @ReactMethod
    fun stopTracking() {
        currentActivity!!.runOnUiThread {
            initializeCamera()
            lightFlyManager!!.stopTracking()
        }
    }

    @ReactMethod
    fun setIsFront(isFront: Boolean) {
        currentActivity!!.runOnUiThread {
            initializeCamera()
            lightFlyManager!!.useFrontCamera(isFront)
        }
    }

    private fun emitDeviceEvent(eventName: String, eventData: WritableMap?) {
        // A method for emitting from the native side to JS
        // https://facebook.github.io/react-native/docs/native-modules-android.html#sending-events-to-javascript
        reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter::class.java).emit(eventName, eventData)
    }

    override fun didTrackLight(s: String, b: Boolean) {
        val params = Arguments.createMap()
        params.putString("lightId", s)

        emitDeviceEvent("LightDetected", params)
    }

}
