# ClientCalculator
Обработка статистики клиентов.

Настройки утилиты хранятся в файле main/resources/config.properties:
- Папка с входящими json-файлами: параметр inbox (имена файлов имеют формат <CLIENT_ID>.json)
- Папка с исходящими json-файлами : параметр outbox

Пример оформления main/resources/config.properties:
+ **inbox = src/main/resources/inbox**
+ **outbox = src/main/resources/outbox**

Вызов из командной строки:\
usage: clientCalculator\
 __-g,--generate *arg*__        : generate *arg* count of JSON files for test\
 __-p,--properties-path *arg*__ : set path to config.property file to *arg* (by default is "./config.properties")\
 __-h,--help__                  : print this help information
 
 Вызов без параметров предполагает наличие входящих json-файлов в каталоге <inbox>\
 Исходящие файлы будут сложены в каталог "outbox".

