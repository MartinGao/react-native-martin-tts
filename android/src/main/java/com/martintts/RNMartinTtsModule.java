
package com.martintts;

import java.util.*;
import java.util.Locale;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;

import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.speech.tts.TextToSpeech.OnUtteranceCompletedListener;
import android.speech.tts.TextToSpeech.EngineInfo;
import android.util.Log;
import android.media.AudioManager;

public class RNMartinTtsModule extends ReactContextBaseJavaModule implements OnInitListener, OnUtteranceCompletedListener {

  private final ReactApplicationContext reactContext;
  private static final String TAG = "RNMartinTtsModule";

  private TextToSpeech mSpeech = null;
  private Promise onUtteranceCompletedPromise = null;

  public RNMartinTtsModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNMartinTts";
  }

  @ReactMethod
  public void initTTS(final Promise promise) {
    Log.i(TAG, "initTTS: 开始初始化TTS引擎");
    mSpeech = new TextToSpeech(getReactApplicationContext(), this, "com.iflytek.speechcloud");
  }

  @Override
  public void onInit(int status) {
    if (status == TextToSpeech.SUCCESS) {
      Log.i(TAG, "onInit: TTS引擎初始化成功");
      mSpeech.setOnUtteranceCompletedListener(this);
    }
    else{
      Log.i(TAG, "onInit: TTS引擎初始化失败");
    }
  }
  public void onUtteranceCompleted(String utteranceId) {
    Log.i(TAG, "onUtteranceCompleted: 结束" + " " + utteranceId);
    if (this.onUtteranceCompletedPromise != null) {
      Log.i(TAG, "onUtteranceCompleted: 并执行JS回调 Promise" + " " + utteranceId);
      this.onUtteranceCompletedPromise.resolve(utteranceId);
    }
  }

  @ReactMethod
  public void speak(final String payload, final String volume, String taskId, Promise promise) {
    Log.i(TAG, "speak: 开始说话" + " " + taskId + " " + payload);
    this.onUtteranceCompletedPromise = promise;
    // Log.i(TAG, "TTS getDefaultEngine() " + mSpeech.getDefaultEngine());

    // if (mSpeech.getDefaultVoice() != null) {
    //   Log.i(TAG, "TTS getDefaultVoice() " + mSpeech.getDefaultVoice().getLocale().toString());
    // } else {
    //   Log.i(TAG, "TTS getDefaultVoice() NULL");
    // }

    // for (EngineInfo oneEngineInfo : mSpeech.getEngines()) {
      // Log.i(TAG, "TTS mSpeech.getEngines() oneEngineInfo " + oneEngineInfo.name);
		// }

    // Log.i(TAG, "TTS mSpeech.getAvailableLanguages() " + mSpeech.getAvailableLanguages().toString());
    // Log.i(TAG, "TTS mSpeech.getVoices() " + mSpeech.getVoices().toString());

    // Log.i(TAG, "TTS mSpeech.setLanguage() Result: " + mSpeech.setLanguage(new Locale("zh")));

    HashMap<String, String> myHashAlarm = new HashMap<String, String>();
    myHashAlarm.put(TextToSpeech.Engine.KEY_PARAM_STREAM, String.valueOf(AudioManager.STREAM_ALARM));
    myHashAlarm.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, taskId);
    myHashAlarm.put(TextToSpeech.Engine.KEY_PARAM_VOLUME, volume);
    mSpeech.speak(payload, TextToSpeech.QUEUE_FLUSH, myHashAlarm);

    Log.i(TAG, "speak: 结束说话" + " " + taskId + " " + payload);
  }

  @ReactMethod
  public void stop(Promise promise) {
    Log.i(TAG, "STOP: 结束这一切");
    mSpeech.stop();
  }
}