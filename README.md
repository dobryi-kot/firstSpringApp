# ClientCalculator
Обработка статистики клиентов.

Настройки утилиты в файле main/resources/config.properties:
- Папка с входящими json-файлами: параметр inbox (имена файлов имеют формат <CLIENT_ID>.json)
- Папка с исходящими json-файлами : параметр outbox

Пример оформления main/resources/config.properties\
inbox = src/main/resources/inbox\
outbox = src/main/resources/outbox

Вызов из командной строки:\
usage: clientCalculator\
 -g,--generate <arg>   generate <arg> count of JSON files for test\
 -h,--help             print this help information
 
 Вызов без параметров предполагает наличие входящих json-файлов в каталоге <inbox>\
 Исходящие файлы будут сложены в каталог <outbox>, входящие удалены.

