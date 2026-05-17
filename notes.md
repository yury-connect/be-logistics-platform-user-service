## Многомодульный проект Maven (Maven Multi-module Project) с выделением API модуля (контракты) и реализации (src).

### Структура проекта
```text
be-logistics-platform-user-service/          (корень)
├── pom.xml                                   (родительский)
├── user-service-api/
│   └── pom.xml                               (API модуль)
└── user-service-src/
    └── pom.xml                               (реализация)
```

### Структура папок в IDEA
```text
be-logistics-platform-user-service/          # корневая папка проекта
├── pom.xml                                   # родительский POM
├── user-service-api/
│   ├── pom.xml
│   └── src/
│       ├── main/
│       │   └── java/
│       └── test/
│           └── java/
└── user-service-src/
    ├── pom.xml
    └── src/
        ├── main/
        │   └── java/
        └── test/
            └── java/
```


