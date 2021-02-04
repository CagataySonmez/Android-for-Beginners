#include "myBusinessLogic.h"

#include <android/log.h>
#include <curl/curl.h>
#include <iostream>

myBusinessLogic::myBusinessLogic(std::string name) {
    msg = "Hello " + name + "! ";
}

std::string  myBusinessLogic::getMsg(bool withResult) {
    reportStatistic(withResult);
    return msg;
}

void myBusinessLogic::reportStatistic(bool appendResult){
    CURL *curl;
    CURLcode res;
    curl = curl_easy_init();
    std::string resultAsStr;

    if(curl) {
        curl_easy_setopt(curl, CURLOPT_URL, "http://scooterlabs.com/echo");
        res = curl_easy_perform(curl);
        curl_easy_cleanup(curl);

        if(res == CURLE_OK) {
            __android_log_print(ANDROID_LOG_DEBUG, "reportStatistic", "Success.");
            resultAsStr = "HTTP GET Success";
        }
        else {
            __android_log_print(ANDROID_LOG_DEBUG, "reportStatistic",
                                "NOK: curl_easy_perform failed! error code: %d", res);
            resultAsStr = "HTTP GET Failed, curl error code: " + std::to_string(res);
        }
    } else {
        __android_log_print(ANDROID_LOG_DEBUG  , "reportStatistic","NOK: curl_easy_init failed!");
        resultAsStr = "HTTP GET Failed, curl cannot be initialized";
    }

    if(appendResult)
        msg += resultAsStr;
}