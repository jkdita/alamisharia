# ALAMI Sharia REST API

### Prerequisites
   - Project : Maven
   - Java : JDK 1.8
   - Database : MySQL
   - Framework : Spring Boot
   
## Postman Documentation
```sh
https://www.getpostman.com/collections/eae70952d07e338338c0
```

## Connection
  - HTTP

## How To Deploy
### Local
Build
```sh
$ sh compile.sh
```

Run
```sh
$ sh start.sh
```

Stop
```sh
$ sh stop.sh
```

### Docker

Build
```sh
$ docker build . -t alami
```

Run
```sh
$ docker run --name alami -p <port>:8080 alami
```

Stop
```sh
$ docker stop alami
$ docker rm alami
```

Restart
```sh
$ docker restart alami
```


