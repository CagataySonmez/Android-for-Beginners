#ifndef MYAPPLICATION_MYBUSINESSLOGIC_H
#define MYAPPLICATION_MYBUSINESSLOGIC_H

#include <string>

class myBusinessLogic
{
private:
    std::string msg;
    void reportStatistic();

public:
    myBusinessLogic(std::string name);
    std::string  getMsg();
};

#endif //MYAPPLICATION_MYBUSINESSLOGIC_H
