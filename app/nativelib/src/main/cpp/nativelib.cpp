#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_tscore_sports_nativelib_NativeLib_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "https://60d194a45b017400178f3e51.mockapi.io/";
    return env->NewStringUTF(hello.c_str());
}