package com.company.cubatrainingtask

import com.company.cubatrainingtask.entity.Employee

/**
 * Created by lebedev on 30.03.2017.
 */

Employee employee = getBinding().getVariable("employee")
String name = employee.lastName
String age = getBinding().getVariable("age")

GString text = "Поздравляем вас с днем рождения, уважаемый  ${name} \n " +
        "Желаем всего наилучшего в ваши ${age} лет! \n " +
        "С уважением, коллектив автосервиса "

print text

return text


