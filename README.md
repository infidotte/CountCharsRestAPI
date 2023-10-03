# CountCharsRestAPI
    Запуск:
    > java -jar RestAPI-Release.jar
## Апи для метода: 
    POST /count
## Входные данные: 
    Любой текст в теле запроса
## Формат выходных данных:
  ```
  {
    "key": "char1",
    "value": n
  },
  {
    "key": "char2",
    "value": i
  }, 
  ...
  {
    "key": "char3",
    "value": j
  }
  ```
  n >= i >= j

### Версии
    Java: 17
    Spring Boot: 3.1.3
    Maven: 4.0.0
