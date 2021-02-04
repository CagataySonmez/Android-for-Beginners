#ifndef MYAPPLICATION_MYBUSINESSLOGIC_H
#define MYAPPLICATION_MYBUSINESSLOGIC_H

#include <string>

class myBusinessLogic
{
private:
    std::string msg;
    void reportStatistic(bool appendResult);

public:
    myBusinessLogic(std::string name);
    std::string  getMsg(bool withResult);
};

#endif //MYAPPLICATION_MYBUSINESSLOGIC_H
