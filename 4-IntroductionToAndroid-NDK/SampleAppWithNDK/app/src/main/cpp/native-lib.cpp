#include <jni.h>
#include <string>

#include "myBusinessLogic.h"

extern "C" JNIEXPORT jstring JNICALL
Java_com_arcelik_sampleappwithndk_MainActivity_getMessageFromJNI(
        JNIEnv *env, jobject thisObj, jboolean withCurlResult) {

    jstring nameMemberOfJavaClass = jstring("unknown");
    std::string argForCppFunction = "unassigned";

    // Get a reference to this object's class
    jclass thisClass = env->GetObjectClass(thisObj);

    // Get the Field ID of the instance variables "message"
    jfieldID findName = env->GetFieldID(thisClass, "name", "Ljava/lang/String;");
    if (findName != NULL){
        // Get the object given the Field ID
        nameMemberOfJavaClass = (jstring)env->GetObjectField(thisObj, findName);

        //get the value of Field ID
        const char *cStrName = env->GetStringUTFChars(nameMemberOfJavaClass, NULL);
        if(cStrName != NULL) {
            argForCppFunction = cStrName;
        }
    }

    //we got name parameter from java class. Now ready to run our business logic
    myBusinessLogic* bl = new myBusinessLogic(argForCppFunction);
    const char* message = bl->getMsg(withCurlResult).c_str();
    delete bl;

    return env->NewStringUTF(message);
}