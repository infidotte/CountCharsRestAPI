# CountCharsRestAPI
## Апи для метода: 
    POST /count
## Входные данные: 
    Любой текст в теле запроса
## Формат выходныех данных:
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
